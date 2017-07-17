package com.study.executor;
/**
 * 接口 Future<V>
 * 类型参数：
 * V - 此 Future 的 get 方法所返回的结果类型
 * 
 * public interface Future<V>
 * 
 * Future 表示异步计算的结果。它提供了检查计算是否完成的方法，以等待计算的完成，并获取计算的结果。计算完成后只能使用 get 方法来获取结果，如有必要，计算完成前可以阻塞此方法。取消则由 cancel 方法来执行。还提供了其他方法，以确定任务是正常完成还是被取消了。一旦计算完成，就不能再取消计算。如果为了可取消性而使用 Future 但又不提供可用的结果，则可以声明 Future<?> 形式类型、并返回 null 作为底层任务的结果。
 * 
 * 用法示例（注意，下列各类都是构造好的。）
 interface ArchiveSearcher { String search(String target); }
 class App {
   ExecutorService executor = ...
   ArchiveSearcher searcher = ...
   void showSearch(final String target)
       throws InterruptedException {
     Future<String> future
       = executor.submit(new Callable<String>() {
         public String call() {
             return searcher.search(target);
         }});
     displayOtherThings(); // do other things while searching
     try {
       displayText(future.get()); // use future
     } catch (ExecutionException ex) { cleanup(); return; }
   }
 }
 * FutureTask 类是 Future 的一个实现， Future 可实现 Runnable，所以可通过 Executor 来执行。例如，可用下列内容替换上面带有 submit 的构造：
 * 
 FutureTask<String> future = new FutureTask<String>(new Callable<String>() {
        public String call() {
          return searcher.search(target);
 }});
 executor.execute(future);
 * 
 * 
 */
public class FutureTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
