package Java_0318;

public class ThreadDemo {

    static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("hello world,我是一个线程");
            while (true){

            }
        }
    }

    public static void main(String[] args) {
        //创建线程需要使用Thread类，来创建一个Thread 的实例，
        //另一方面还需要给这个线程指定要执行哪些指令/代码。
        //指定指令的方法有很多种方式，此处先用一种简单的，直接继承 Thread类
        //重写Thread 类中的run方法


        //注意，当Thread对象被创建出来的时候，内核中并没有随之产生一个pcb(线程)
        Thread t = new MyThread();
        //执行这个start 方法，才是真的创建出了一个线程
        //此时内核中才随之出现了一个pcb，这个pcb就会对应让CPU来执行该线程的代码上面的run方法
        t.start();

        while (true){
            //这里啥都不干
        }
    }
}
