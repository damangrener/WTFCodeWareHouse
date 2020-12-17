package com.wtf.codewarehouse.util.rank.listrank;

import lombok.Data;

/**
 * @author wangtengfei
 * @since 2020/11/24 15:23
 */
@Data
public abstract class BaseRank<T> {

    //要比较的值
    private T t;

    //排名
    private Integer rank;

    abstract void setTFromU(T t,T from);

}
