package Java_0318;

/**
 * 线程不安全的场景
 * 1.一个线程读，一个线程写：volatile来解决
 * 2.两个线程写：加锁解决线程安全问题
 */
public class ThreadDemo14 {
    static class Counter {
        public  int count = 0;

        synchronized public void increase(){
            count++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread  t1= new Thread(){
            @Override
            public void run(){
                for (int i = 0; i <50000 ; i++) {
                    counter.increase();
                }
            }
        };
         t1.start();

        Thread  t2= new Thread(){
            @Override
            public void run(){
                for (int i = 0; i <50000 ; i++) {
                    counter.increase();
                }
            }
        };
        t2.start();

        t1.join();
        t2.join();
        System.out.println(counter.count);
    }
}
