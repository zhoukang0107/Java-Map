package com.study.architecture.Iterator;

/**
 * 抽象迭代接口
 * @param <T>
 */
public interface Iterator<T> {
    /**
     * 是否含有下一个元素
     * @return
     */
    public boolean hasNext();

    /**
     * 元素
     * @return
     */
    public T next();
}
