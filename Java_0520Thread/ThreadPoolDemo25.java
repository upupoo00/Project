package Java_0520Thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo25 {


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
        //私有对象解决线程安全问题
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
            String result=  simpleDateFormat.format(date);
            System.out.println("格式化时间: " +result);
    }
}
