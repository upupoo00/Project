package Java_0318;

public class ThreadDemo3 {
    static class MyRunnable implements Runnable{
        @Override
        public void run() {
            System.out.println("我是一个线程");
        }
    }
    static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("我是一个线程！！！");
        }
    }
    public static void main(String[] args) {
//        Thread t = new Thread(){
//            @Override
//            public void run() {
//                System.out.println("我是一个线程");
//            }
//        };
//        t.start();
        //2.显示创建一个类，实现Runnable 接口，然后把这个 Runnable的实例关联到Thread实例上
//        Thread t = new Thread(new MyRunnable());
//        t.start();
        //3.显示继承Thread 类
//        Thread t = new MyThread();
//        t.start();
        //4
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("通过匿名内部类实现 Runnable 接口");
//            }
//        };
//        Thread T = new Thread(runnable);
//        T.start();

        //5.lambda表达式
        Thread t = new Thread(()->{
            System.out.println("使用lambda 表达式来指定 线程执行的内容");
        });
        t.start();
    }
}
