package com.study.executor;
/**
 * 
 * http://tool.oschina.net/uploads/apidocs/jdk-zh/java/util/concurrent/ThreadPoolExecutor.html
 * public class ThreadPoolExecutor extends AbstractExecutorService
 * 一个 ExecutorService，它使用可能的几个池线程之一执行每个提交的任务，
 * 通常使用 Executors 工厂方法配置。
 * 
 * 线程池可以解决两个不同问题：由于减少了每个任务调用的开销，它们通常可以在执行大量异步
 * 任务时提供增强的性能，并且还可以提供绑定和管理资源（包括执行任务集时使用的线程）的方
 * 法。每个 ThreadPoolExecutor 还维护着一些基本的统计数据，如完成的任务数。
 * 
 * 为了便于跨大量上下文使用，此类提供了很多可调整的参数和扩展钩子 (hook)。但是，强烈建
 * 议程序员使用较为方便的 Executors 工厂方法 Executors.newCachedThreadPool()
 * （无界线程池，可以进行自动线程回收）、Executors.newFixedThreadPool(int)（固
 * 定大小线程池）和 Executors.newSingleThreadExecutor()（单个后台线程），它们
 * 均为大多数使用场景预定义了设置。否则，在手动配置和调整此类时，使用以下指导：
 * 
 * 核心和最大池大小
 * ThreadPoolExecutor 将根据 corePoolSize（参见 getCorePoolSize()）和 
 * maximumPoolSize（参见 getMaximumPoolSize()）设置的边界自动调整池大小。
 * 当新任务在方法 execute(java.lang.Runnable) 中提交时，如果运行的线程少于 
 * corePoolSize，则创建新线程来处理请求，即使其他辅助线程是空闲的。如果运行的线
 * 程多于 corePoolSize 而少于 maximumPoolSize，则仅当队列满时才创建新线程。
 * 如果设置的 corePoolSize 和 maximumPoolSize 相同，则创建了固定大小的线程池。
 * 如果将 maximumPoolSize 设置为基本的无界值（如 Integer.MAX_VALUE），则允许
 * 池适应任意数量的并发任务。在大多数情况下，核心和最大池大小仅基于构造来设置，不过也
 * 可以使用 setCorePoolSize(int) 和 setMaximumPoolSize(int) 进行动态更改。
 * 
 * 按需构造
 * 默认情况下，即使核心线程最初只是在新任务到达时才创建和启动的，也可以使用方法 prestartCoreThread() 或 prestartAllCoreThreads() 对其进行动态重写。如果构造带有非空队列的池，则可能希望预先启动线程。
 * 
 * 创建新线程
 * 使用 ThreadFactory 创建新线程。如果没有另外说明，则在同一个 ThreadGroup 中一律使用 Executors.defaultThreadFactory() 创建线程，并且这些线程具有相同的 NORM_PRIORITY 优先级和非守护进程状态。通过提供不同的 ThreadFactory，可以改变线程的名称、线程组、优先级、守护进程状态，等等。如果从 newThread 返回 null 时 ThreadFactory 未能创建线程，则执行程序将继续运行，但不能执行任何任务。
 * 
 * 保持活动时间
 * 如果池中当前有多于 corePoolSize 的线程，则这些多出的线程在空闲时间超过 keepAliveTime 时将会终止（参见 getKeepAliveTime(java.util.concurrent.TimeUnit)）。这提供了当池处于非活动状态时减少资源消耗的方法。如果池后来变得更为活动，则可以创建新的线程。也可以使用方法 setKeepAliveTime(long, java.util.concurrent.TimeUnit) 动态地更改此参数。使用 Long.MAX_VALUE TimeUnit.NANOSECONDS 的值在关闭前有效地从以前的终止状态禁用空闲线程。默认情况下，保持活动策略只在有多于 corePoolSizeThreads 的线程时应用。但是只要 keepAliveTime 值非 0， allowCoreThreadTimeOut(boolean) 方法也可将此超时策略应用于核心线程。
 * 
 * 排队
 * 所有 BlockingQueue 都可用于传输和保持提交的任务。可以使用此队列与池大小进行交互：
 * 如果运行的线程少于 corePoolSize，则 Executor 始终首选添加新的线程，而不进行排队。
 * 如果运行的线程等于或多于 corePoolSize，则 Executor 始终首选将请求加入队列，而不添加新的线程。
 * 如果无法将请求加入队列，则创建新的线程，除非创建此线程超出 maximumPoolSize，在这种情况下，任务将被拒绝。
 * 
 * 排队有三种通用策略：
 * 直接提交。工作队列的默认选项是 SynchronousQueue，它将任务直接提交给线程而不保持它们。在此，如果不存在可用于立即运行任务的线程，则试图把任务加入队列将失败，因此会构造一个新的线程。此策略可以避免在处理可能具有内部依赖性的请求集时出现锁。直接提交通常要求无界 maximumPoolSizes 以避免拒绝新提交的任务。当命令以超过队列所能处理的平均数连续到达时，此策略允许无界线程具有增长的可能性。
 * 无界队列。使用无界队列（例如，不具有预定义容量的 LinkedBlockingQueue）将导致在所有 corePoolSize 线程都忙时新任务在队列中等待。这样，创建的线程就不会超过 corePoolSize。（因此，maximumPoolSize 的值也就无效了。）当每个任务完全独立于其他任务，即任务执行互不影响时，适合于使用无界队列；例如，在 Web 页服务器中。这种排队可用于处理瞬态突发请求，当命令以超过队列所能处理的平均数连续到达时，此策略允许无界线程具有增长的可能性。
 * 有界队列。当使用有限的 maximumPoolSizes 时，有界队列（如 ArrayBlockingQueue）有助于防止资源耗尽，但是可能较难调整和控制。队列大小和最大池大小可能需要相互折衷：使用大型队列和小型池可以最大限度地降低 CPU 使用率、操作系统资源和上下文切换开销，但是可能导致人工降低吞吐量。如果任务频繁阻塞（例如，如果它们是 I/O 边界），则系统可能为超过您许可的更多线程安排时间。使用小型队列通常要求较大的池大小，CPU 使用率较高，但是可能遇到不可接受的调度开销，这样也会降低吞吐量。
 * 
 * 被拒绝的任务
 * 当 Executor 已经关闭，并且 Executor 将有限边界用于最大线程和工作队列容量，且已经饱和时，在方法 execute(java.lang.Runnable) 中提交的新任务将被 拒绝。在以上两种情况下， execute 方法都将调用其 RejectedExecutionHandler 的 RejectedExecutionHandler.rejectedExecution(java.lang.Runnable, java.util.concurrent.ThreadPoolExecutor) 方法。下面提供了四种预定义的处理程序策略：
 * 在默认的 ThreadPoolExecutor.AbortPolicy 中，处理程序遭到拒绝将抛出运行时 RejectedExecutionException。
 * 在 ThreadPoolExecutor.CallerRunsPolicy 中，线程调用运行该任务的 execute 本身。此策略提供简单的反馈控制机制，能够减缓新任务的提交速度。
 * 在 ThreadPoolExecutor.DiscardPolicy 中，不能执行的任务将被删除。
 * 在 ThreadPoolExecutor.DiscardOldestPolicy 中，如果执行程序尚未关闭，则位于工作队列头部的任务将被删除，然后重试执行程序（如果再次失败，则重复此过程）。
 * 定义和使用其他种类的 RejectedExecutionHandler 类也是可能的，但这样做需要非常小心，尤其是当策略仅用于特定容量或排队策略时。
 * 
 * 
 * 钩子 (hook) 方法
 * 此类提供 protected 可重写的 beforeExecute(java.lang.Thread, java.lang.Runnable) 和 afterExecute(java.lang.Runnable, java.lang.Throwable) 方法，这两种方法分别在执行每个任务之前和之后调用。它们可用于操纵执行环境；例如，重新初始化 ThreadLocal、搜集统计信息或添加日志条目。此外，还可以重写方法 terminated() 来执行 Executor 完全终止后需要完成的所有特殊处理。
 * 如果钩子 (hook) 或回调方法抛出异常，则内部辅助线程将依次失败并突然终止。
 * 
 * 
 * 队列维护
 * 方法 getQueue() 允许出于监控和调试目的而访问工作队列。强烈反对出于其他任何目的而使用此方法。 remove(java.lang.Runnable) 和 purge() 这两种方法可用于在取消大量已排队任务时帮助进行存储回收。
 * 
 * 扩展示例。此类的大多数扩展可以重写一个或多个受保护的钩子 (hook) 方法。例如，下面是一个添加了简单的暂停/恢复功能的子类：
   class PausableThreadPoolExecutor extends ThreadPoolExecutor {
   private boolean isPaused;
   private ReentrantLock pauseLock = new ReentrantLock();
   private Condition unpaused = pauseLock.newCondition();

   public PausableThreadPoolExecutor(...) { super(...); }
 
   protected void beforeExecute(Thread t, Runnable r) {
     super.beforeExecute(t, r);
     pauseLock.lock();
     try {
       while (isPaused) unpaused.await();
     } catch(InterruptedException ie) {
       t.interrupt();
     } finally {
       pauseLock.unlock();
     }
   }
 
   public void pause() {
     pauseLock.lock();
     try {
       isPaused = true;
     } finally {
       pauseLock.unlock();
     }
   }
 
   public void resume() {
     pauseLock.lock();
     try {
       isPaused = false;
       unpaused.signalAll();
     } finally {
       pauseLock.unlock();
     }
   }
 }
 * 
 * 
 * 终止
 * 程序 AND 不再引用的池没有剩余线程会自动 shutdown。如果希望确保回收取消引用的池（即使用户忘记调用 shutdown()），则必须安排未使用的线程最终终止：设置适当保持活动时间，使用 0 核心线程的下边界和/或设置 allowCoreThreadTimeOut(boolean)。
 * 
 * 
 */
public class ThreadPoolExecutorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
