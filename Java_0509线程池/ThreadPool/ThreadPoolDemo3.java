package Java_0509线程池.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class ThreadPoolDemo3 {
    public static void main(String[] args) {
        MyThreadFactory threadFactory = new MyThreadFactory() ;
        ExecutorService executorService =  Executors.newFixedThreadPool(10,threadFactory);
        for (int i = 0; i < 10; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程名: "+ Thread.currentThread().getName()+
                            " 优先级: " + Thread.currentThread().getPriority());
                }
            });
        }
    }
    private static int count = 1;
    static class MyThreadFactory implements ThreadFactory{
        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setName("mythreadpool-" +count++);
            thread.setPriority(10);
            return thread;
        }
    }
}
