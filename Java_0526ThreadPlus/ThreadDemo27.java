package Java_0526ThreadPlus;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadDemo27 {
    private static int count= 0;
    private static final int MAX_SIZE = 100000;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                    for (int i = 0; i <MAX_SIZE ; i++) {
                        count++;
                    }
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                    for (int i = 0; i <MAX_SIZE ; i++) {
                        count--;
                    }
            }
        });
        t2.start();
        t1.join();
        t2.join();
        System.out.println("result: "+count);
    }
}
