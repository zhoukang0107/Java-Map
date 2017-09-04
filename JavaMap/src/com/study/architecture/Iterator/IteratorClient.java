package com.study.architecture.Iterator;

/**
 * http://www.runoob.com/design-pattern/iterator-pattern.html
 * 迭代器模式：用来遍历容器
 * 提供一种方法顺序访问一个容器对象的各个元素，而又不需要暴露该对象的内部表示
 *
 *
 *
 *
 *
 */
public class IteratorClient {

    public static void main(String[] args){
        NameRepository<String> nameRepository = new NameRepository<>();
        nameRepository.add("111");
        nameRepository.add("222");
        nameRepository.add("333");
        nameRepository.add("444");
        nameRepository.add("555");
        Iterator iterator = nameRepository.getIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
