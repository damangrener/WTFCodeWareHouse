package com.wtf.codewarehouse.javabase.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;

/**
 * @author wangtengfei
 * @since 2020/8/28 11:49
 */
public class JsonReplace {
    public static void main(String[] args) {
        String json="{\n" +
                "\t\"data\": [{\n" +
                "\t\t\"name\": \"wtf\",\n" +
                "\t\t\"age\": 1\n" +
                "\t}, {\n" +
                "\t\t\"name\": \"lbb\",\n" +
                "\t\t\"age\": 2\n" +
                "\t}],\n" +
                "\t\"errCode\": 0,\n" +
                "\t\"message\": \"string\",\n" +
                "\t\"success\": true\n" +
                "}";

        JSONObject object= JSON.parseObject(json);
        object.put("data",10);
        System.out.println(object);
    }
}
