package Java_0509线程池.ThreadPool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo10 {

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
                new ThreadPoolExecutor(1,1,
                        60, TimeUnit.SECONDS,
                        new LinkedBlockingQueue<>(1),
                        threadFactory,
                        new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i=0;i<3;i++) {
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程名: " +Thread.currentThread().getName());
                }
            });
        }
    }
}

