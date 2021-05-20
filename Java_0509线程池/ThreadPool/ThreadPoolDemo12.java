package Java_0509线程池.ThreadPool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo12 {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(2,5,
                60, TimeUnit.SECONDS,
                 new LinkedBlockingQueue<>(10));
        for (int i = 0; i < 3; i++) {
            int finalI = i;
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(finalI+" 线程名: "+Thread.currentThread().getName());
                }
            });
        }
        //终止线程池
        threadPoolExecutor.shutdown();
        //立即终止线程池（线程池的任务不会执行完）
        threadPoolExecutor.shutdownNow();
    }
}
