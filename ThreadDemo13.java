package Java_0318;

import java.util.Scanner;

public class ThreadDemo13 {
     static class Counter{
         //volatile 关键字的作用：
         // 保持内存可见性，进制编译器进行刚才这种场景的优化。
         // (一个线程读，一个线程在写，修改对于读线程来说可能没生效)
        public volatile int  flag = 0;
    }
    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread t1 = new Thread(){
            @Override
            public void run(){
                 while (counter.flag == 0){

                }
                System.out.println("循环结束!!");
            }
        };
         t1.start();

         Thread t2 = new Thread(){
             @Override
             public void run(){
                 Scanner scanner = new Scanner(System.in);
                 System.out.print("请输入一个整数: ");
                 counter.flag = scanner.nextInt();
             }
         };
          t2.start();
    }
}
