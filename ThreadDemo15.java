package Java_0318;

/**
 * wait的工作过程：
 * 1.释放锁 ---->得先有一个锁，才能释放~~
 * 2.等待通知(过程可能很久)
 * 3.当收到通知后，尝试重新获取锁，继续往下执行
 *
 * wait方法必须在synchronized代码块内部使用
 *
 */
public class ThreadDemo15 {
    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        synchronized (object) {
            System.out.println("等待前");
            object.wait();
            System.out.println("等待后");
        }
    }
}
