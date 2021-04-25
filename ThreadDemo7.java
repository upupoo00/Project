package Java_0318;

/**
 * 线程等待
 * 线程之间是并发执行的关系：抢占式执行
 * 虽然咱们没法控制哪个线程先走哪个后走
 * 但是可以控制让哪个线程先结束，哪个线程后结束。(借助线程等待)-> join方法
 * 执行join方法的线程就会阻塞，一直阻塞到对应线程执行结束之后，才会继续执行
 * 存在的意义就是为了控制线程结束的先后顺序
 */
public class ThreadDemo7 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(){
            @Override
            public void run(){
                while (true){
                    System.out.println("我是新线程");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        };
         t.start();
         while (true){
             System.out.println("我是主线程");
             Thread.sleep(100);
         }
    }
}
