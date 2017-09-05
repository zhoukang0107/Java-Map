package com.study.architecture.Iterator;

import java.util.ArrayList;

/**
 * 具体容器类
 * @param <T>
 */
public class NameRepository<T> implements Container<T> {
    private ArrayList<T> list = new ArrayList();
    @Override
    public Iterator<T> getIterator() {
        return new NameIterator<T>();
    }

    @Override
    public void add(T t) {
        list.add(t);
    }

    @Override
    public void remove(T t) {
        list.remove(t);
    }

    public class NameIterator<T>  implements Iterator<T>{
        int index = 0;
        @Override
        public boolean hasNext() {
            return index != list.size();
        }

        @Override
        public T next() {
            return (T) list.get(index++);
        }
    }
}
