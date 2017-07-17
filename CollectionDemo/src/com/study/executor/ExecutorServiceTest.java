package com.study.executor;
/**
 * public interface ExecutorService extends Executor
 * 
 * ExecutorService：
 * 
 * Executor 提供了管理终止的方法，以及可为跟踪一个或多个异步任务执行状况而生成 Future 的方法。
 * 
 * 可以关闭 ExecutorService，这将导致其拒绝新任务。提供两个方法来关闭 ExecutorService。
 * shutdown() 方法在终止前允许执行以前提交的任务，而 shutdownNow() 方法阻止等待任务启动
 * 并试图停止当前正在执行的任务。在终止时，执行程序没有任务在执行，也没有任务在等待执行，并且无
 * 法提交新任务。应该关闭未使用的 ExecutorService 以允许回收其资源。
 * 
 * Executors 类提供了用于此包中所提供的执行程序服务的工厂方法。
 * 
 * 用法示例
 * 下面给出了一个网络服务的简单结构，这里线程池中的线程作为传入的请求。它使用了预先配置的 
 * Executors.newFixedThreadPool(int) 工厂方法
 *  
    class NetworkService implements Runnable {
    private final ServerSocket serverSocket;
    private final ExecutorService pool;

    public NetworkService(int port, int poolSize)
        throws IOException {
      serverSocket = new ServerSocket(port);
      pool = Executors.newFixedThreadPool(poolSize);
    }
 
    public void run() { // run the service
      try {
        for (;;) {
          pool.execute(new Handler(serverSocket.accept()));
        }
      } catch (IOException ex) {
        pool.shutdown();
      }
    }
  }

  class Handler implements Runnable {
    private final Socket socket;
    Handler(Socket socket) { this.socket = socket; }
    public void run() {
      // read and service request on socket
    }
 }
 
 * 下列方法分两个阶段关闭 ExecutorService。第一阶段调用 shutdown 拒绝传入任务，然后调用 shutdownNow（如有必要）取消所有遗留的任务：
 * 
   void shutdownAndAwaitTermination(ExecutorService pool) {
   pool.shutdown(); // Disable new tasks from being submitted
   try {
     // Wait a while for existing tasks to terminate
     if (!pool.awaitTermination(60, TimeUnit.SECONDS)) {
       pool.shutdownNow(); // Cancel currently executing tasks
       // Wait a while for tasks to respond to being cancelled
       if (!pool.awaitTermination(60, TimeUnit.SECONDS))
           System.err.println("Pool did not terminate");
     }
   } catch (InterruptedException ie) {
     // (Re-)Cancel if current thread also interrupted
     pool.shutdownNow();
     // Preserve interrupt status
     Thread.currentThread().interrupt();
   }
 }
 * 
 * 
 * 
 */


public class ExecutorServiceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
