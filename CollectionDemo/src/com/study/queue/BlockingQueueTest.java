package com.study.queue;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 
 * 并行和并发区别
 * 1、并行是指两者同时执行一件事，比如赛跑，两个人都在不停的往前跑；
 * 2、并发是指资源有限的情况下，两者交替轮流使用资源，比如一段路(单核CPU资源)同时只能过一个人，A走一段后，让给B，B用完继续给A ，交替使用，目的是提高效率
 * 
 * BlockingQueue：
 * BlockingQueue接口定义了一种阻塞的FIFO Queue,每一个BlockingQueue都有一个容量，
 * 当容量满时，往BlockingQueue中添加数据时会造成阻塞，当容量为空时，取元素操作会阻塞。
 * 
 * BlockingQueue 方法以四种形式出现，对于不能立即满足但可能在将来某一时刻可以满足的操作，这四种形式的处理方式不同：第一种是抛出一个异常，第二种是返回一个特殊值（null 或 false，具体取决于操作），第三种是在操作可以成功前，无限期地阻塞当前线程，第四种是在放弃前只在给定的最大时间限制内阻塞。下表中总结了这些方法：
 * 
 *      抛出异常	          特殊值	          阻塞	          超时
 * 插入	add(e)	    offer(e)	put(e)	offer(e, time, unit)
 * 移除	remove()	poll()	    take()	poll(time, unit)
 * 检查	element()	peek()	         不可用	不可用
 * 
 * BlockingQueue 不接受 null 元素。试图 add、put 或 offer 一个 null 元素时，某些实现会抛出 NullPointerException。null 被用作指示 poll 操作失败的警戒值。
 * 
 * ArrayBlockingQueue：是一个由数组支持的有界阻塞队列，在读写操作上都需要锁住整个容器，因此
 * 吞吐量与一般的实现是相似的，适合实现生产者消费者模式
 * 
 * LinkedBlockingQueue：基于链表的线程安全的阻塞队列，其内部也维持这一个数据缓存队列，该队列由
 * 一个列表构成，当生产者往队列中放入一个数据时，队列会从生产者手中获取数据，并缓存在队列内部，
 * 而生产者立即返回；只有当队列缓冲区达到最大值缓存容量时，才会阻塞生产者队列，直到消费者从队列中消费掉
 * 一份数据，生产者线程会被唤醒。反之对于消费者这端的处理也基于同样的原理，而LinkedBlockingQueue
 * 之所以能够高效的处理并发数据，还因为其对于生产者端和消费者端分别采用了独立的锁来控制数据同步，这也意
 * 味着在高并发的情况下生产者和消费者可以并行地操作队列中的数据，以此来提高整个队列的并发性能
 * 
 * ArrayBlockingQueue和LinkedBlockingQueue的区别：
 * 1. 队列中锁的实现不同
 *  ArrayBlockingQueue实现的队列中的锁是没有分离的，即生产和消费用的是同一个锁；
 *  LinkedBlockingQueue实现的队列中的锁是分离的，即生产用的是putLock，消费是takeLock
 * 2. 在生产或消费时操作不同
 *  ArrayBlockingQueue实现的队列中在生产和消费的时候，是直接将枚举对象插入或移除的；
 *  LinkedBlockingQueue实现的队列中在生产和消费的时候，需要把枚举对象转换为Node<E>进行插入或移除 ，会影响性能
 * 3. 队列大小初始化方式不同
 *  ArrayBlockingQueue实现的队列中必须指定队列的大小；
 *  LinkedBlockingQueue实现的队列中可以不指定队列的大小，但是默认是Integer.MAX_VALUE
 * 
 * offer
 * 将元素插入队列，成功返回true，如果当前没有可用的空间，则返回false
 * offer(E e, long timeout, TimeUnit unit) 
 * 将元素插入队列，在到达指定的等待时间前等待可用的空间
 * E poll(long timeout, TimeUnit unit) 
 * 获取并移除队列的头部，在指定的等待时间前等待可用的元素
 * void put(E e) 
 * 将元素插入队列，将等待可用的空间（堵塞）
 * take() 
 * 获取并移除队列的头部，在元素变得可用之前一直等待（堵塞）
 *
 *	
 *
 *
 *
 * ：
 *
 */
public class BlockingQueueTest {
	private static ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(5, true); //最大容量为5的数组堵塞队列  
	private static CountDownLatch producerLatch; //倒计时计数器  
	private static CountDownLatch consumerLatch;  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BlockingQueueTest queueTest = new BlockingQueueTest();  
        queueTest.test();  
	}
	private void test(){  
        producerLatch = new CountDownLatch(10); //state值为10  
        consumerLatch = new CountDownLatch(10); //state值为10  
          
        Thread t1 = new Thread(new ProducerTask());  
        Thread t2 = new Thread(new ConsumerTask());  
  
        //启动线程  
        t1.start();  
        t2.start();  
          
        try {  
            System.out.println("producer waiting...");  
            producerLatch.await(); //进入等待状态，直到state值为0，再继续往下执行  
            System.out.println("producer end");  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
          
        try {  
            System.out.println("consumer waiting...");  
            consumerLatch.await(); //进入等待状态，直到state值为0，再继续往下执行  
            System.out.println("consumer end");  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
  
        //结束线程  
        t1.interrupt();   
        t2.interrupt();  
          
        System.out.println("end");  
    }  
      
    //生产者  
    class ProducerTask implements Runnable{  
        private Random rnd = new Random();  
          
        @Override  
        public void run() {  
            try {  
                while(true){  
                    queue.put(rnd.nextInt(100)); //如果queue容量已满，则当前线程会堵塞，直到有空间再继续  
                      
                    //offer方法为非堵塞的  
                    //queue.offer(rnd.nextInt(100), 1, TimeUnit.SECONDS); //等待1秒后还不能加入队列则返回失败，放弃加入  
                    //queue.offer(rnd.nextInt(100));  
                      
                    producerLatch.countDown(); //state值减1  
                    //TimeUnit.SECONDS.sleep(2); //线程休眠2秒  
                }  
            } catch (InterruptedException e) {  
                //e.printStackTrace();  
            }  catch (Exception ex){  
                ex.printStackTrace();  
            }  
        }  
    }  
      
    //消费者  
    class ConsumerTask implements Runnable{  
        @Override  
        public void run() {  
            try {  
                while(true){  
                    Integer value = queue.take(); //如果queue为空，则当前线程会堵塞，直到有新数据加入  
                      
                    //poll方法为非堵塞的  
                    //Integer value = queue.poll(1, TimeUnit.SECONDS); //等待1秒后还没有数据可取则返回失败，放弃获取  
                    //Integer value = queue.poll();  
                      
                    System.out.println("value = " + value);  
                      
                    consumerLatch.countDown(); //state值减1  
                    TimeUnit.SECONDS.sleep(2); //线程休眠2秒  
                }  
            } catch (InterruptedException e) {  
                //e.printStackTrace();  
            } catch (Exception ex){  
                ex.printStackTrace();  
            }  
        }  
    }  
}
