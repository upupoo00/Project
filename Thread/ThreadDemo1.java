package Java_0318;
//创建线程的两种方式
//1.显示继承 Thread
//2.匿名内部类的方式继承Thread
//3.显示创建一个类，实现Runnable 接口，然后把这个 Runnable的实例关联到Thread实例上
public class ThreadDemo1 {
    private static long count = 100_0000_0000L;

    public static void main(String[] args) {
        //串行
        serial();
        //并行
        concurrency();
    }

    private static void serial() {
        //获取当前时间戳
        long beg = System.currentTimeMillis();

        int a = 0;
        for(long i = 0;i<count;i++){
            a++;
        }
        int b = 0;
        for(long i = 0;i<count;i++){
            b++;
        }

        long end = System.currentTimeMillis();
        System.out.println("time: "+(end-beg)+"ms");
    }

    private static void concurrency() {

        long beg = System.currentTimeMillis();

        //匿名内部类，创建了一个没有名字的类，只知道这个类继承自Thread
        //{}中是这个类的具体代码，同时也会new出来一个这个类的实例
        Thread t1 = new Thread(){
            @Override
            public void run() {
                int a = 0;
                for(long i = 0;i<count;i++){
                    a++;
                }
            }
        };

        Thread t2 = new Thread(){
            @Override
            public void run() {
                int b = 0;
                for(long i = 0;i<count;i++){
                    b++;
                }
            }
        };
        t1.start();
        t2.start();
        try {
            //线程等待，让主线程等待t1 和 t2 执行结束，然后在继续往下执行
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //t1 t2 和  main 线程之间都是并发执行的
        //调用t1.start 和 t2.start之后
        //此时主线程仍然会继续执行，下面的end就随之被计算了
        //正确的做法应该是要保证 t1和t2都计算完毕，再来计算这个end的时间戳
        long end = System.currentTimeMillis();
        System.out.println("time: "+(end-beg)+"ms");
    }

}
