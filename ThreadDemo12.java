package Java_0318;

import java.util.Scanner;

public class ThreadDemo12 {
    public static void main(String[] args) {
        Object locker1 = new Object();
        Object locker2 = new Object();


        Thread  t1= new Thread(){
            @Override
            public void run(){
                Scanner scanner = new Scanner(System.in);
                synchronized (locker1.getClass()){
                    System.out.println("请输入一个整数");
                    int num = scanner.nextInt();//用户如果不输入，就会一直阻塞在nextInt
                    System.out.println("num= "+num);
                }
            }
        };
         t1.start();

         Thread  t2= new Thread(){
             @Override
             public void run(){
                 while (true){
                     synchronized (locker2.getClass()){
                         System.out.println("线程2 获取到锁了");
                         try {
                             Thread.sleep(1000);
                         } catch (InterruptedException e) {
                             e.printStackTrace();
                         }
                     }
                 }
             }
         };
          t2.start();
    }
}
