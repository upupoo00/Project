package Java_0509线程池.ThreadPool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ThreadPoolExecutor 执行流程：核心线程数，最大线程数，任务队列
 *   当任务量小于核心线程数的时候，它会创建一个线程来执行此任务；
 *   当任务量大于核心线程数的时候，并且没有空闲线程的时候，且当前线程池的线程数小于最大线程数，此时会将任务存到任务队列里面:
 * (注意：因为把多出来的任务存储在任务队列的成本最小，所以此时线程池会将新任务存在任务队列当中，而非创建新线程来执行任务)；
 *   当任务量比较大的时候，此时没有空闲的线程，并且任务队列已经满了，此时会判断当前线程池的任务数量是否大于等于最大线程数，
 * 如果当前线程池的数量小于最大线程数，创建线程来执行任务。当前线程池的线程数量等于最大线程数，并且任务队列已经满了，此时会
 * 执行拒绝策略
 */
public class ThreadPoolDemo9 {
    //原始的线程池创建方式ThreadPool方式
    private static int count = 1;//计数器
    public static void main(String[] args) {
        //参数1：核心线程的数量，线程池正常情况下的数量
        //参数2：最大线程数量，当有大量的任务的时候，可以创建的最多的线程数(必须大于等于核心线程数)
        //参数3：表示最大线程存活时间（临时工的存活时间）
        //参数4：配合参数三一起使用的，表示存活时间的时间单位
        //参数5：任务队列
        //参数6：线程工厂
        //参数7：拒绝策略
        ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setName("myThreadPool-"+count++);
                return thread;
            }
        };

        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(2,2,
                        60, TimeUnit.SECONDS,
                        new LinkedBlockingQueue<>(1),threadFactory);
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
