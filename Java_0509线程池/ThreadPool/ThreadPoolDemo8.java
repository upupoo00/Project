package Java_0509线程池.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo8 {
    static class MyOOMClass{
        //1M 的空间（M KB Byte）
        private  byte[] bytes = new byte[1024*1024];
    }
    public static void main(String[] args) {
        //
       ExecutorService executorService =  Executors.newCachedThreadPool();
        for (int i = 0; i<15000;i++) {
            final  int finalI = i;
            executorService.execute(new Runnable() {
               @Override
               public void run() {
                   new MyOOMClass();
                   System.out.println("任务"+finalI);
               }
           });
        }
    }
}
