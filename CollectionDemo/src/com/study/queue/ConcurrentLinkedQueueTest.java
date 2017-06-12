package com.study.queue;
/**
 * ConcurrentLinkedQueue ：
 * 一个基于链接节点的无界线程安全队列。此队列按照 FIFO（先进先出）原则对元素进行排序。
 * 队列的头部 是队列中时间最长的元素。队列的尾部 是队列中时间最短的元素。新的元素插入到
 * 队列的尾部，队列获取操作从队列头部获得元素。当多个线程共享访问一个公共 collection
 * 时，ConcurrentLinkedQueue 是一个恰当的选择。此队列不允许使用 null 元素。
 * 此实现采用了有效的“无等待 (wait-free)”算法，该算法基于 Maged M. Michael 和 
 * Michael L. Scott 合著的 Simple, Fast, and Practical Non-Blocking 
 * and Blocking Concurrent Queue Algorithms 中描述的算法。
 * 
 * 需要小心的是，与大多数 collection 不同，size 方法不是 一个固定时间操作。由于这些
 * 队列的异步特性，确定当前元素的数量需要遍历这些元素。
 */
public class ConcurrentLinkedQueueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
