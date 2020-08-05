package com.wtf.codewarehouse.javabase.thread;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wangtengfei
 * @since 2020/7/31 15:50
 */
public class NameList {

    private List nameList= Collections.synchronizedList(new LinkedList<>());

    public void add(String name){
        nameList.add(name);
    }

    public Integer removeFirst(){
        if(nameList.size()>0){
            return nameList.size();
        }else return null;
    }

}
