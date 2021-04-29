package Thread;

/**
 * 守护线程需要注意的事项：
 * 1.守护线程的设置必须放在开启线程之前
 * 2.在守护线程中创建的线程默认就是守护线程
 *
 * 使用场景
 * 1.Java垃圾回收器
 * 2.健康检测任务
 */
public class ThreadDemo1 {
    public static void main(String[] args) {
        Thread  t1= new Thread(){
            @Override
            public void run(){
                System.out.println("线程名："+Thread.currentThread().getName());
            }
        };
        System.out.println("thread 守护线程："+t1.isDaemon());
        //设置守护线程 不能放在 start之后，否则会报错
        t1.setDaemon(true);
        t1.start();
        System.out.println("thread 守护线程："+t1.isDaemon());
    }
}
