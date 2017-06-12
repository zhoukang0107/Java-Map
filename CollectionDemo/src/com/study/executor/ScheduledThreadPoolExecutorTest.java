package com.study.executor;

/**
 * public class ScheduledThreadPoolExecutor
 * extends ThreadPoolExecutor
 * implements ScheduledExecutorService
 * 
 * ThreadPoolExecutor，它可另行安排在给定的延迟后运行命令，或者定期执行命令。需要多个辅助线程时，或者要求 ThreadPoolExecutor 具有额外的灵活性或功能时，此类要优于 Timer。
 * 
 * 一旦启用已延迟的任务就执行它，但是有关何时启用，启用后何时执行则没有任何实时保证。按照提交的先进先出 (FIFO) 顺序来启用那些被安排在同一执行时间的任务。
 * 
 * 虽然此类继承自 ThreadPoolExecutor，但是几个继承的调整方法对此类并无作用。特别是，因为它作为一个使用 corePoolSize 线程和一个无界队列的固定大小的池，所以调整 maximumPoolSize 没有什么效果。
 * 
 * 扩展注意事项：此类重写 AbstractExecutorService 的 submit 方法，以生成内部对象控制每个任务的延迟和调度。若要保留功能性，子类中任何进一步重写的这些方法都必须调用超类版本，超类版本有效地禁用附加任务的定制。但是，此类提供替代受保护的扩展方法 decorateTask（为 Runnable 和 Callable 各提供一种版本），可定制用于通过 execute、submit、schedule、scheduleAtFixedRate 和 scheduleWithFixedDelay 进入的执行命令的具体任务类型。默认情况下，ScheduledThreadPoolExecutor 使用一个扩展 FutureTask 的任务类型。但是，可以使用下列形式的子类修改或替换该类型。

 public class CustomScheduledExecutor extends ScheduledThreadPoolExecutor {

   static class CustomTask<V> implements RunnableScheduledFuture<V> { ... }

   protected <V> RunnableScheduledFuture<V> decorateTask(
                Runnable r, RunnableScheduledFuture<V> task) {
       return new CustomTask<V>(r, task);
   }

   protected <V> RunnableScheduledFuture<V> decorateTask(
                Callable<V> c, RunnableScheduledFuture<V> task) {
       return new CustomTask<V>(c, task);
   }
   // ... add constructors, etc.
 }
 * 
 *
 */
public class ScheduledThreadPoolExecutorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
