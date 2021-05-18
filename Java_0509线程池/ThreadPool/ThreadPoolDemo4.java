package Java_0509线程池.ThreadPool;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo4 {
    public static void main(String[] args) {
        //创建可以执行定时任务的线程池
        ScheduledExecutorService scheduledExecutorService =
                Executors.newScheduledThreadPool(2);
        //执行定时任务
        System.out.println("设置定时任务: " + new Date());

        //以上次任务的开始时间作为下一次任务的开始时间
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("执行任务1: " + new Date());
            }
        },1,3, TimeUnit.SECONDS);

        scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("执行任务2: " + new Date());
            }
        },1,TimeUnit.SECONDS);

        //以上一次任务的结束时间作为下一次任务的开始时间
        scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("执行任务3: " + new Date());
            }
        },1,3,TimeUnit.SECONDS);
    }
}
