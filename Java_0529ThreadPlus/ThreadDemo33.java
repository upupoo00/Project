package Java_0529ThreadPlus;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 信号量：Semaphore
 * 可以实现限流功能
 */
public class ThreadDemo33 {
    public static void main(String[] args) {

        //创建信号量
        Semaphore semaphore = new Semaphore(2);

        //创建线程池
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10,10,
                0, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(1000));
        //任务1
        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" 车辆进入了停车场");
                try {
                    Thread.sleep(1000);
                    //尝试获取锁
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //执行到此行代码，表示获取到停车位
                System.out.println("<<<< "+Thread.currentThread().getName()+"进入了停车场>>>>");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("<<<< "+Thread.currentThread().getName()+"离开了停车场>>>>");
                //释放锁
                semaphore.release();
            }
        });

        //任务2
        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" 车辆进入了停车场");
                try {
                    Thread.sleep(1000);
                    //尝试获取锁
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //执行到此行代码，表示获取到停车位
                System.out.println("<<<< "+Thread.currentThread().getName()+"进入了停车场>>>>");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("<<<< "+Thread.currentThread().getName()+"离开了停车场>>>>");
                //释放锁
                semaphore.release();
            }
        });

        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" 车辆进入了停车场");
                try {
                    Thread.sleep(1000);
                    //尝试获取锁
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //执行到此行代码，表示获取到停车位
                System.out.println("<<<< "+Thread.currentThread().getName()+"进入了停车场>>>>");
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("<<<< "+Thread.currentThread().getName()+"离开了停车场>>>>");
                //释放锁
                semaphore.release();
            }
        });

        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" 车辆进入了停车场");
                try {
                    Thread.sleep(1000);
                    //尝试获取锁
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //执行到此行代码，表示获取到停车位
                System.out.println("<<<< "+Thread.currentThread().getName()+"进入了停车场>>>>");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("<<<< "+Thread.currentThread().getName()+"离开了停车场>>>>");
                //释放锁
                semaphore.release();
            }
        });
    }
}
