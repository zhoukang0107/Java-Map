package com.study.executor;

/**
 * 执行已提交的Runnable任务的对象，此接口提供一种将任务提交与每个任务将如何运行的知己
 * （包括线程使用的细节、调度等）分离开的方法。通常使用Executor而不是显式地创建线程。
 * 例如，可能使用如下的方法，而不是为一组任务中的每个任务调用new
 * Thread(new(RunnableTask)).start();
 * 
 * Executor excutor = anExcutor;
 * executor.excute(new RunnableTask1())
 * executor.excute(new RunnableTask2())
 * ...
 * 
 * 不过，Executor接口并没有严格地要求执行是异步的。在最简单的情况下，执行程序可以在
 * 调用者的线程中立即允许已提交的任务
 * class DirectExecutor implements Executor {
 *     public void execute(Runnable r) {
 *         r.run();
 *     }
 * }
 * 
 * 更常见的是，任务是在某个不是调用者线程的线程中执行的。一下执行程序将为每个任务生成一
 * 个新线程。
 * class ThreadPerTaskExecutor implements Executor{
 * 		public void execute(Runnable r){
 * 			new Thread(r).start();
 * 		}
 * }
 * 
 * 许多Executor实现都对调度任务的方式和时间强加了某种限制。以下执行程序是任务提交与
 * 第二个执行程序保持连续，这说明了一个符合执行程序
 * class SerialExecutor implements Executor{
 * 		final Queue<Runnable> tasks = new ArrayDeque<Runnable>();
 * 		final Executor executor;
 * 		Runnable active;
 *  	SerialExecutor(Executor executor) {
 *         this.executor = executor;
 *    	}
 *		
 *		public synchronized void execute(final Runnable r){
 *			tasks.offer(new Runnable(){
 *				public void run(){
 *					try{
 *					   r.run();				
 *					}finally{
 *						scheduleNext();
 *					}
 *				}
 *			});
 *			if (active == null){
 *				scheduleNext();	
 *			}
 *		}
 *		protected synchronized void scheduleNext(){
 *			if ((active=tasks.poll())!=null){
 *				executor.execute(active);
 *			}
 *		}
 * }
 * 此包中提供可Executor实现了ExecutorSercice,这是一个使用广泛的接口
 * 
 * ThreadPoolExecutor类提供了一个可扩展的线程池实现，Executors类为
 * 这些Executor提供了便捷的工厂方法
 * 
 * Executor
 * |
 * ExecutorService ScheduledExecutorService
 * |
 * ThreadPoolExecutor
 * 
 * 
 */

public class ExecutorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
