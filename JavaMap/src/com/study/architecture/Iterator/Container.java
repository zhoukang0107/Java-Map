package com.study.architecture.Iterator;

public interface Container<T> {
    public Iterator<T> getIterator();

    public void add(T t);

    public void remove(T t);
}
