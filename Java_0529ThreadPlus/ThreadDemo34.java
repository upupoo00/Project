package Java_0529ThreadPlus;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 计数器
 * 等待所有的线程进入某个步骤之后，在统一执行某个流程
 * 好像跑步比赛，10个选手依次就位，哨声响才同时出发；所有选手都通过终点，才能公布成绩。
 *
 * 每次线程到达await的时候，计数器+1，直到计数器到达创建CountDownLatch创建的个数
 */
public class ThreadDemo34 {
    public static void main(String[] args) throws InterruptedException {
        //创建
        CountDownLatch countDownLatch = new CountDownLatch(3);

        ThreadPoolExecutor executor = new ThreadPoolExecutor(10,10,
                0, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(100));

        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" 开跑");
                int num = new Random().nextInt(5);
                num +=1;
                try {
                    Thread.sleep(num*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+" 到达了终点");
                //阻塞等待其他线程也到达此处
                countDownLatch.countDown();
            }
        });

        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" 开跑");
                int num = new Random().nextInt(5);
                num +=1;
                try {
                    Thread.sleep(num*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+" 到达了终点");
                //阻塞等待其他线程也到达此处
                countDownLatch.countDown();
            }
        });

        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" 开跑");
                int num = new Random().nextInt(5);
                num +=1;
                try {
                    Thread.sleep(num*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+" 到达了终点");
                //阻塞等待其他线程也到达此处
                countDownLatch.countDown();
            }
        });

        //等待所有选手到达终点，计数器为0
        countDownLatch.await();
        System.out.println("比赛结束，宣布成绩");
    }
}
