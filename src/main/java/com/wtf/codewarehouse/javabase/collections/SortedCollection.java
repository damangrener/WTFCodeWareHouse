package com.wtf.codewarehouse.javabase.collections;

import java.util.Collection;
import java.util.Comparator;

/**
 * @author wangtengfei
 * @since 2020/8/5 12:04
 */
public interface SortedCollection<E> extends Collection {

    public Comparator<E> getComparator();
    public void setComparator(Comparator<E> comp);
}
