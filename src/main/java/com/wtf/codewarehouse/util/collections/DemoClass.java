package com.wtf.codewarehouse.util.collections;

import lombok.Data;

/**
 * @author wangtengfei
 * @since 2020/12/19 11:37
 */
@Data
public class DemoClass {
    private String A;
    private Integer B;

    public DemoClass(String a,Integer b){
        this.A=a;
        this.B=b;
    }
    public DemoClass(){
    }
}
