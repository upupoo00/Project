package Java_0318;

/**
 * 线程中断操作
 *Thread.interrupted()来判断中断标记的话，返回结果为true,
 * 同时会把中断标记设回false  ->结束闹钟
 *Thread.currentThread().isInterrupted()判断中断标记，
 * 返回结果一直为true  ->暂停闹钟
 */
public class ThreadDemo6 {
    public static void main(String[] args) {
        Thread t = new Thread(){
            @Override
            public void run(){
                for (int i = 0; i <10 ; i++) {
//                    System.out.println(Thread.interrupted());
                    System.out.println(Thread.currentThread().isInterrupted());
                }

            }
        };
         t.start();
         t.interrupt();

    }
}
