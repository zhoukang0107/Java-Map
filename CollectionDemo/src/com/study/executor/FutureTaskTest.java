package com.study.executor;
/**
 * 类 FutureTask<V>
 * 类型参数：
 * V - 此 FutureTask 的 get 方法所返回的结果类型。
 * public class FutureTask<V>
 * extends Object
 * implements RunnableFuture<V>
 * 
 * 可取消的异步计算。利用开始和取消计算的方法、查询计算是否完成的方法和获取计算结果的方法，此类提供了对 Future 的基本实现。仅在计算完成时才能获取结果；如果计算尚未完成，则阻塞 get 方法。一旦计算完成，就不能再重新开始或取消计算。
 * 可使用 FutureTask 包装 Callable 或 Runnable 对象。因为 FutureTask 实现了 Runnable，所以可将 FutureTask 提交给 Executor 执行。
 * 除了作为一个独立的类外，此类还提供了 protected 功能，这在创建自定义任务类时可能很有用。
 * 
 * 
 * 
 * 
 */
public class FutureTaskTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
