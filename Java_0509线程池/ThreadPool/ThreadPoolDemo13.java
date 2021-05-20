package Java_0509线程池.ThreadPool;

import java.util.Random;
import java.util.concurrent.*;

public class ThreadPoolDemo13 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(10,10,60, TimeUnit.SECONDS,
                        new LinkedBlockingQueue<>(100));
        //执行任务方式一
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("执行execute方法");
            }
        });

        //执行一个带返回值的任务
        Future<Integer> future =  threadPoolExecutor.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int num = new Random().nextInt(10);
                System.out.println("执行submit方法，生成随机数："+num);
                return num;
            }
        });
        System.out.println("得到线程池执行结果" + future.get());

        //使用submit执行Runnable任务
        threadPoolExecutor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("执行submit方法，使用Runnable对象");
            }
        });

        threadPoolExecutor.shutdown();
    }
}
