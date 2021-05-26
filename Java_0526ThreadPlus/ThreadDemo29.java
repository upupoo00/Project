package Java_0526ThreadPlus;

import java.util.concurrent.atomic.AtomicReference;


/**
 * 使用代码的方式演示ABA问题
 */
public class ThreadDemo29 {

    private static AtomicReference money = new AtomicReference(100);
    public static void main(String[] args) throws InterruptedException {

        //两次转账

        //转账-100
        Thread  t1= new Thread(new Runnable() {
            @Override
            public void run() {
                boolean result = money.compareAndSet(100,0);
                System.out.println("first---->>>"+result);

            }
        });
        t1.start();
        t1.join();

        //账户增加100
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean result = money.compareAndSet(0,100);
                System.out.println("<<<<enter 100>>>>" +result);
            }
        });
        t3.start();

        Thread  t2= new Thread(new Runnable() {
            @Override
            public void run() {
                boolean result =  money.compareAndSet(100,0);
                System.out.println("second--->>>"+result);
            }
        });
        t2.start();
        t2.join();
        System.out.println("<<<<end>>>>");
    }
}
