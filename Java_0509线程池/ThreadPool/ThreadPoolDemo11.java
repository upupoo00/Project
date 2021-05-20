package Java_0509线程池.ThreadPool;


import java.util.concurrent.*;

public class ThreadPoolDemo11 {

    private static int count = 1;//计数器
    public static void main(String[] args) {
        ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setName("myThreadPool-"+count++);
                return thread;
            }
        };

        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(1, 1,
                        60, TimeUnit.SECONDS,
                        new LinkedBlockingQueue<>(1),
                        threadFactory,
                        new RejectedExecutionHandler() {
                            @Override
                            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                                //自定义拒绝策略，可以写到日志里面，也可以存储到数据库，也可以啥都不做
                                System.out.println("发生了未知的错误，执行拒绝策略~~");
                            }
                        });
        for (int i=0;i<3;i++) {
            int finalI = i;
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(finalI+" 线程名: " +Thread.currentThread().getName());
                }
            });
        }
    }
}


