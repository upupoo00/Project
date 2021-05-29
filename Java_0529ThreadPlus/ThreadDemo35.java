package Java_0529ThreadPlus;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.concurrent.*;

/**
 * 循环屏障
 * CyclicBarrier执行原理
 * 内有一个计数器，每次执行线程到await方法的时候，计数器+1，
 * 直到计数器个数等于创建时声明的个数的时候，就会突破屏障，执行之后的代码；
 * 在突破屏障之后，计数器清零可以进行下一轮执行
 */
public class ThreadDemo35 {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new Runnable() {
            @Override
            public void run() {
                System.out.println("-----------------到达了屏障-----------------");
            }
        });

        ThreadPoolExecutor executor = new ThreadPoolExecutor(10,10,
                0, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(1000));

        for (int i=1;i<5; i++) {
            final int finalI = i;
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000*finalI);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+" 进入了任务");
                    try {
                        //等待其他线程的执行
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+" 执行结束");
                }
            });
        }
    }
}
