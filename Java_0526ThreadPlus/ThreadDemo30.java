package Java_0526ThreadPlus;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;


/**
 * 使用代码的方式演示ABA问题
 *
 * AtomicStampedReference注意事项
 * 里面旧值对比的是引用
 */
public class ThreadDemo30 {

    private static AtomicStampedReference money = new AtomicStampedReference(100,1);
    public static void main(String[] args) throws InterruptedException {

        //两次转账

        //转账-100
        Thread  t1= new Thread(new Runnable() {
            @Override
            public void run() {
                boolean result = money.compareAndSet(100,0,1,2);
                System.out.println("first---->>>"+result);

            }
        });
        t1.start();
        t1.join();
        //账户增加100
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean result = money.compareAndSet(0,100,2,3);
                System.out.println("<<<<enter 100>>>>" +result);
            }
        });
        t3.start();

        Thread  t2= new Thread(new Runnable() {
            @Override
            public void run() {
                boolean result = money.compareAndSet(100,0,1,2);
                System.out.println("second--->>>"+result);
            }
        });
        t2.start();
    }
}
