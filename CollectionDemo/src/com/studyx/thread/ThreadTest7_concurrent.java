package com.studyx.thread;

import java.util.Random;
/**
 * Atomic：原子性操作类
 * atomic包中类可以对基本数据，对数组中的基本数据，对类中的基本数据等进行操作
 * 
 * AtomicIntegerFieldUpdater<T>
 * T - 保持可更新字段的对象类型。
 * 基于反射的实用工具，可以对指定类的指定 volatile int 字段进行原子更新。
 * 此类用于原子数据结构，该结构中同一节点的几个字段都独立受原子更新控制。
 * 注意，此类中 compareAndSet 方法的保证弱于其他原子类中该方法的保证。因
 * 为此类不能确保所有使用的字段都适合于原子访问目的，所以对于相同更新器上的 
 * compareAndSet 和 set 的其他调用，它仅可以保证原子性和可变语义。
 * 
 * int addAndGet(T obj, int delta)  以原子方式将给定值添加到此更新器管理的给定对象的字段当前值。
 * 
 */

public class ThreadTest7_concurrent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


