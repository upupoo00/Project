package Java_0509线程池.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo7 {
    public static void main(String[] args) {
        //JDK8+以上才可以使用
        //根据当前的硬件生成对应个数的线程池，并且是异步执行的
       ExecutorService executorService =  Executors.newWorkStealingPool();
        for (int i = 0; i<10;i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程名: "+ Thread.currentThread().getName());
                }
            });
        }
        //表示等待线程池执行完成
        while (!executorService.isTerminated()){

        }
    }
}
