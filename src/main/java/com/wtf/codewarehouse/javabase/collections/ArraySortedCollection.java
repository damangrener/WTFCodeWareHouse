package com.wtf.codewarehouse.javabase.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

/**
 * @author wangtengfei
 * @since 2020/8/5 12:09
 */
public class ArraySortedCollection<E> implements SortedCollection<E>, Iterable {
    private Comparator<E> comparator;
    private ArrayList<E> list;
    public ArraySortedCollection(Comparator<E> c)
    {
        this.list = new ArrayList<E>();
        this.comparator = c;
    }
    @Override
    public Comparator<E> getComparator() {
        return null;
    }

    @Override
    public void setComparator(Comparator<E> comp) {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
