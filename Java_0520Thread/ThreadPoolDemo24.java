package Java_0520Thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo24 {
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");

    public static void main(String[] args) {
        //定义线程池
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(10,10,0, TimeUnit.SECONDS,
                        new LinkedBlockingQueue<>(1000));
        for (int i = 1; i < 1001; i++) {
            final int finalI = i;
            threadPoolExecutor.submit(new Runnable() {
                @Override
                public void run() {
                    Date date = new Date(1000*finalI);
                    myFormatTime(date);
                }
            });
        }
    }

    private static void myFormatTime(Date date) {
        //加锁可以解决线程安全的问题，但是同时因为排队处理，会带来一定的性能问题
        synchronized (ThreadPoolDemo24.class) {
            String result=  simpleDateFormat.format(date);
            System.out.println("格式化时间: " +result);
        }
    }
}
