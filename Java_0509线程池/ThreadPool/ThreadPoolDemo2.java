package Java_0509线程池.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo2 {
    public static void main(String[] args) {
        //创建一个带缓存的线程池:
        //使用场景：短期有大量任务的时候使用 newCachedThreadPool()
        ExecutorService executorService =  Executors.newCachedThreadPool();
        for (int i = 0; i <100 ; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程名: "+ Thread.currentThread().getName());
                }
            });
        }
    }
}
