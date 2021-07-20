package com.wtf.codewarehouse.freemarker;


import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import org.slf4j.Logger;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.util.*;

/*******************************************
 *
 * @Package com.cccuu.project.utils
 * @Author duan
 * @Date 2018/7/27 11:51
 * @Version V1.0
 *******************************************/


public class FreemarkerUtil {


    private static final String ENCODING = "UTF-8";

    private static Configuration cfg = new Configuration();

    //初始化cfg


    static {
        //设置模板所在文件夹
        cfg.setClassForTemplateLoading(FreemarkerUtil.class, "/templates");
        // setEncoding这个方法一定要设置国家及其编码，不然在ftl中的中文在生成html后会变成乱码
        cfg.setEncoding(Locale.getDefault(), ENCODING);
        // 设置对象的包装器
        cfg.setObjectWrapper(new DefaultObjectWrapper());
        // 设置异常处理器,这样的话就可以${a.b.c.d}即使没有属性也不会出错
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);


    }

    //获取模板对象


    public static Template getTemplate(String templateFileName) throws IOException {
        return cfg.getTemplate(templateFileName, ENCODING);

    }

    /**
     * 据数据及模板生成文件
     *
     * @param data             Map的数据结果集
     * @param templateFileName ftl模版文件名
     * @param outFilePath      生成文件名称(可带路径)
     */


    public static File crateFile(Map<String, Object> data, String templateFileName, String outFilePath) {
        Writer out = null;
        File outFile = new File(outFilePath);
        try {
            // 获取模板,并设置编码方式，这个编码必须要与页面中的编码格式一致
            Template template = getTemplate(templateFileName);
            if (!outFile.getParentFile().exists()) {
                outFile.getParentFile().mkdirs();

            }
            out = new OutputStreamWriter(new FileOutputStream(outFile), ENCODING);
            // 处理模版
            template.process(data, out);
            out.flush();
//            log.info("由模板文件" + templateFileName + "生成" + outFilePath + "成功.");

        } catch (Exception e) {
//            log.error("由模板文件" + templateFileName + "生成" + outFilePath + "出错");
            e.printStackTrace();

        } finally {
            try {
                if (out != null) {
                    out.close();

                }

            } catch (IOException e) {
//                log.error("关闭Write对象出错", e);
                e.printStackTrace();

            }

        }
        return outFile;

    }

    //获得图片的base64码


    public static String getImageBase(String src) throws Exception {
        if (src == null || src == "") {
            return "";

        }
        File file = new File(src);
        if (!file.exists()) {
            return "";

        }
        InputStream in = null;
        byte[] data = null;
        try {
            in = new FileInputStream(file);
            data = new byte[in.available()];
            in.read(data);
            in.close();

        } catch (IOException e) {
            e.printStackTrace();

        }
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);

    }


    public static void main(String[] args) {
        try {
            Map<String, Object> data = new HashMap<String, Object>();
            data.put("title","WTF-freemarker-模板测试");
            data.put("name", "王某");
            data.put("sex", "男");
            data.put("img1Flag",false);
            data.put("img2Flag",true);
            data.put("img3Flag",true);
            List<Map<String, String>> educations = new ArrayList<Map<String, String>>();
            Map<String, String> paramsMap = new HashMap<String, String>();
            paramsMap.put("school", "禹州一高");
            paramsMap.put("startYear", "2008-09");
//            paramsMap.put("endDate", "2012-06");
            paramsMap.put("sbName", "李磊");
            Map<String, String> paramsMap2 = new HashMap<String, String>();
            paramsMap2.put("school", "江西科技师范大学");
            paramsMap2.put("startYear", "2012-09");
//            paramsMap2.put("endDate", "2016-07");
            paramsMap2.put("sbName", "李杰");
            educations.add(paramsMap);
            educations.add(paramsMap2);
            data.put("educations", educations);
            List<String> images = new ArrayList<String>();
            images.add(null);
//            images.add(getImageBase("E:/图片/test/图片1.png"));
            images.add(getImageBase("E:/图片/test/图片2.png"));
            images.add(getImageBase("E:/图片/test/图片3.png"));
            data.put("images", images);
            crateFile(data, "wtf模板.ftl", "C:/Users/WTF/Desktop/WTF-freemarker-模板测试"+System.currentTimeMillis()+".doc");

        } catch (Exception e) {
            e.printStackTrace();

        }

    }

}
