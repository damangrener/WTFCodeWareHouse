package com.wtf.codewarehouse.javabase.annotation.demo;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: WTF
 * @Date: 2021/1/26 19:25
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MyAnnotationTemplate {

    private String taskCode;
    private String taskName;
    private String message;
    private String targetUserCode;

    /**
     * 模板1
     * @return
     */
    private String template1(){
        MyAnnotationTemplate template=
                MyAnnotationTemplate
                        .builder()
                        .taskCode("1")
                        .taskName("任务1")
                        .message("")
                        .build();
        return JSON.toJSONString(template);
    }
}
