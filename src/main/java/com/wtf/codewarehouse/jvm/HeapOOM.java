package com.wtf.codewarehouse.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangtengfei
 * @since 2020/8/11 15:43
 */
public class HeapOOM {
    static class OOMObject {

    }
    public static void main(String[] args) {
        List<OOMObject> list=new ArrayList<>();
        while (true){
            list.add(new OOMObject());
        }
    }
}
