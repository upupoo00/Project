package Java_0526ThreadPlus;

import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 */
public class ThreadDemo31 {

    public static void main(String[] args) {

        //创建一个读写锁
        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        //得到读锁
        ReentrantReadWriteLock.ReadLock readLock =  readWriteLock.readLock();
        //写锁
        ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();
        //创建线程池
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                10,10,0, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(1000));
        //任务一：读锁演示
        executor.execute(new Runnable() {
            @Override
            public void run() {
                //加锁
                readLock.lock();
                try{
                    System.out.println(Thread.currentThread().getName()+" 进入了读锁--> Time: "+new Date());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    readLock.unlock();
                }
            }
        });

        //任务一：读锁演示
        executor.execute(new Runnable() {
            @Override
            public void run() {
                //加锁
                readLock.lock();
                try{
                    System.out.println(Thread.currentThread().getName()+" 进入了读锁--> Time: "+new Date());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    readLock.unlock();
                }
            }
        });

        //任务三：写锁
        executor.execute(new Runnable() {
            @Override
            public void run() {
                writeLock.lock();
                try{
                    System.out.println(Thread.currentThread().getName()+" 执行了写锁--> Time: " + new Date());
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    writeLock.unlock();
                }
            }
        });

        //任务三：写锁
        executor.execute(new Runnable() {
            @Override
            public void run() {
                writeLock.lock();
                try{
                    System.out.println(Thread.currentThread().getName()+" 执行了写锁--> Time: " + new Date());
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    writeLock.unlock();
                }
            }
        });
    }
}
