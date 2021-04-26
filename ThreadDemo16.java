package Java_0318;

import java.util.Scanner;

public class ThreadDemo16 {
    public static void main(String[] args) {
        Object locker = new Object();

        Thread  t1= new Thread(){
            @Override
            public void run(){
                //使用的锁对象和wait调用的对象得是对应的
                synchronized (locker) {
                    while (true){
                        try {
                            System.out.println("wait 开始");
                            locker.wait();
                            System.out.println("wait 结束");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
         t1.start();

         Thread  t2= new Thread(){
             @Override
             public void run(){
                 Scanner scanner = new Scanner(System.in);
                 System.out.println("输入任意一个整数，继续执行 notify");
                 int num = scanner.nextInt();
                 synchronized (locker) {
                     //此处notify对象和锁对象 也得和上面两个对应起来
                     System.out.println("notify 开始");
                     locker.notify();
                     System.out.println("notify 结束");
                 }
             }
         };
          t2.start();
    }
}
