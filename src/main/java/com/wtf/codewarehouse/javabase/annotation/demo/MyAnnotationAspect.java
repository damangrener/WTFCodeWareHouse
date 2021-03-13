package com.wtf.codewarehouse.javabase.annotation.demo;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import com.netflix.hystrix.contrib.javanica.utils.AopUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @Author: WTF
 * @Date: 2021/1/26 19:29
 */
@Aspect
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MyAnnotationAspect implements ApplicationContextAware {

    private final MyAnnotationTemplate myAnnotationTemplate;

    ApplicationContext applicationContext;

    /**
     * 熔断资源控制注解锚点
     */
    @Pointcut("@annotation(com.wtf.codewarehouse.javabase.annotation.demo.MyAnnotation)")
    public void pointcut() {
    }

    @After(value = "pointcut()")
    public void afterMethod(JoinPoint joinPoint) {
        log.info(">>>>>>>>>>>>>>>>>>App消息推送中【{}】>>>>>>>>>>>>>>>>", joinPoint.getTarget().toString());
        try {
            Method method = AopUtils.getMethodFromTarget(joinPoint);

            MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);

            //获取注解上的方法名，并得到方法返回值
            Method templateMethod = ReflectionUtils.findMethod(MyAnnotationTemplate.class, myAnnotation.json());
            if (null == method) {
                log.error("!!!!!!!!!!AppPushTemplate类中无此方法，【方法名={}】", myAnnotation.json());
            }
            templateMethod.setAccessible(true);
            String templateJson = (String) ReflectionUtils.invokeMethod(templateMethod, myAnnotationTemplate);

            List<MyAnnotationTemplate> list = JSON.parseArray(templateJson, MyAnnotationTemplate.class);

            //正则匹配信息中的${XXX}
            Pattern pattern = Pattern.compile("\\$\\{(.*?)}");
            List<String> paramList = Lists.newArrayListWithCapacity(10);

            List<String> targetList = Lists.newArrayListWithCapacity(list.size() + 4);
            list.forEach(template -> {
                //按格式提取key中的多个目标，以及动态参数名
                String userCodes = template.getTargetUserCode();
                this.checkParam(userCodes);
                targetList.addAll(Arrays.asList(userCodes.split(",")));
                paramList.addAll(Arrays.asList(userCodes.split(",")));

                String message = template.getMessage();
                Matcher matcher = pattern.matcher(message);
                while (matcher.find()) {
                    paramList.add(matcher.group());
                }
            });

            //补充额外参数

            if (CollectionUtils.isEmpty(targetList)) {
                throw new RuntimeException("!!!!!!!!!!!!!!AppPush无目标人员属性名,请查看templateJson中userCodeFieldNames");
            }

            //去除参数列表中的${}三个符号
            for (int i = 0; i < paramList.size(); i++) {
                if (paramList.get(i).contains("$")) {
                    paramList.set(i, paramList.get(i).replace("${", "").replace("}", ""));
                }
            }

            List<String> finalParamList = paramList.stream().distinct().collect(Collectors.toList());
            List<String> finalTargetList = targetList.stream().distinct().collect(Collectors.toList());

            Map<String, Object> paramMap = new HashMap<>();

            //把自定义需要的参数以及值放在map中
            for (Object obj : joinPoint.getArgs()) {
                for (String param : finalParamList) {
                    try {
                        BeanWrapper bw = PropertyAccessorFactory.forBeanPropertyAccess(obj);
                        paramMap.put(param, bw.getPropertyValue(param));
                    } catch (Exception ignored) {

                    }
                }
            }
            log.info("><><><【动态参数列表={}】", paramMap.toString());

            //jPusherMsgDto中可共用的参数
//            JPusherMsgDto jPusherMsgDto = new JPusherMsgDto();
//            jPusherMsgDto.setJumpFlag(1);
//            jPusherMsgDto.setBizNo(checkParam(paramMap.get(appPush.bizNoFieldName())));
//            jPusherMsgDto.setJumpUrlParams(gson.toJson(paramMap));
//            list.forEach(template -> {
//                //替换信息中的动态参数
//                for (String param : finalParamList) {
//                    if (template.getMessage().contains(param)) {
//                        if (!StringUtils.isEmpty(paramMap.get(param))) {
//                            template.setMessage(template.getMessage().replace("${" + param + "}", paramMap.get(param).toString()));
//                        } else {
//                            log.error("!!!!!!!未获取到参数值，【参数名={}】", param);
//                        }
//                    }
//                }
//                jPusherMsgDto.setNotifyCode(appPush.prefixNotify() + sequenceService.nextId());
//                jPusherMsgDto.setBizType(Integer.parseInt(checkParam(template.getBizType())));
//                jPusherMsgDto.setBizTypeName(checkParam(template.getBizTypeName()));
//                jPusherMsgDto.setTitle(checkParam(template.getBizTypeName()));
//                jPusherMsgDto.setBizTypeEvent(checkParam(template.getBizTypeEvent()));
//                jPusherMsgDto.setMsg(checkParam(template.getMessage()));
//                jPusherMsgDto.setSource(template.getSource());
//                finalTargetList.forEach(target -> {
//                    if (template.getUserCodeFieldNames().contains(target)) {
//                        log.info("><><><【目标字段名={}】", target);
//                        jPusherMsgDto.setUserCode(checkParam(paramMap.get(target)));
//                        applicationContext.publishEvent(jPusherMsgDto);
//                        log.info("<<<<<<<<<<<<<App消息推送完毕<<【{}】",jPusherMsgDto.toString());
////                    jPusherProducer.produce(gson.toJson(jPusherMsgDto));
//                    }
//                });
//            });
        } catch (RuntimeException exception) {
            log.error("!!!!!!!!AppPush出现异常", exception);
        }
    }

//    @Async
//    @EventListener(JPusherMsgDto.class)
//    public void eventListHandler(JPusherMsgDto jPusherMsgDto) {
//        log.info("><><><监听到AppPush事件，接收到的值为：{}", JSON.toJSONString(jPusherMsgDto));
//        jPusherProducer.produce(gson.toJson(jPusherMsgDto));
//    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    private String checkParam(Object obj) {
        if (ObjectUtils.isEmpty(obj)) {
            throw new RuntimeException("参数不能为空,参数为上一行字段名");
        }
        return obj.toString();
    }

}
