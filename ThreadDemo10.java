package Java_0318;

/**
 * 线程不安全：多线程并发执行某个代码时，产生了逻辑上的错误，就是"线程不安全"。
 * 线程安全：多线程并发执行某个代码，没有逻辑上的错误，就是"线程安全"。
 *
 * 线程不安全的原因？
 * 1.线程是抢占式执行的。(线程不安全的万恶之源)
 *     线程之间的调度完全由内核负责，用户代码中感知不到，也无法控制。
 *     线程之前谁先执行，谁后执行，谁执行到哪里从CPU上下来，
 *     这样的过程都是用户无法控制也无法感知的
 * 2.自增操作不是原子的。
 * 每次++都能拆分成三个步骤：
 *     1.把内存中的数据读取到CPU中  ->load
 *     2.在CPU中把数据+1          ->incr
 *     3.把计算结束的数据写回到内存中 ->save
 *          当CPU执行到上面三个步骤中的任何一步的时候，
 *          都可能会被调度器调度走，让给其他线程来执行
 * 3.多个线程尝试修改同一个变量
 *     如果是一个线程修改一个变量。线程安全
 *     如果多个线程尝试读取同一个变量。线程安全    如果有多个线程，一个读数据，一个写数据，此时可能导致线程不安全。
 *     如果多个线程尝试修改不同的变量。线程安全
 * 4.内存可见性导致的线程安全问题
 * 5.指令重排序(Java 的编译器在编译代码时，会针对指令进行优化，
 *         调整指令的先后顺序，保证原有逻辑不变的情况下，提高程序的运行效率)
 *
 * 如何解决线程不安全的问题？
 * 1.抢占式执行(这个没法解决，操作系统内核实现)
 * 2.自增操作非原子(这个有办法，可以给自增操作加上锁) -->适用范围最广
 * 3.多个线程同时修改同一个变量(这个能不能有办法，不一定。得看具体的绣需求)
 * 
 */
public class ThreadDemo10 {
    static class Counter{
        public int count = 0;
        public void increase(){
            count++;
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread  t1= new Thread(){
            @Override
            public void run(){
                for (int i = 0; i < 50000; i++) {
                    counter.increase();
                }
            }
        };


         Thread  t2= new Thread(){
             @Override
             public void run(){
                 for (int i = 0; i < 50000; i++) {
                     counter.increase();
                 }
             }
         };
          t1.start();
          t2.start();

          t1.join();
          t2.join();

          //两个线程，各自自增 5w次，最终预期结果 ,应该是10w
          //际结果 取值为[5w,10w]
          //
        System.out.println(counter.count);
    }
}
//如果是串行执行的，此时计算结果仍然是正确的，
// 此时计算结果仍然是正确的。
