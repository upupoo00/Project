package Java_0318;

import java.sql.SQLOutput;

public class ThreadDemo2 {
    static class MyRunnable implements Runnable{
        @Override
        public void run() {
            System.out.println("我是一个新线程");
        }
    }
    public static void main(String[] args) {
        //创建线程的方式
        //1.显示继承 Thread
        //2.匿名内部类的方式继承Thread
//        Thread t = new Thread(){
//            @Override
//            public void run() {
//
//            }
//        };
//        t.start();
        //3.显示创建一个类，实现Runnable 接口，然后把这个 Runnable的实例关联到Thread实例上
//        Thread  t = new Thread(new MyRunnable());
//        t.start();
        //4.通过匿名内部类实现 Runnable 接口
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("我是一个新线程");
//            }
//        };
//        Thread t = new Thread(runnable);
//        t.start();

        //5.使用lambda 表达式来指定 线程执行的内容
        Thread t = new Thread(()->{
            System.out.println("我是一个新线程");
        });
        t.start();
    }
}
