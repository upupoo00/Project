package Java_0509线程池;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 线程池的优点：
 * 1.可以避免频繁的创建和销毁线程
 * 2.可以更好地管理线程的个数和资源的个数
 * 3.线程池拥有更多的功能：比如线程池可以进行定时任务的执行
 * 4.可以更有好的拒绝不能处理的任务
 *
 * 线程池的创建总共分为7种
 * 线程池第一种创建方式：创建固定个数的线程池
 *           第二种：创建一个带缓存的线程池
 *           第三种：创建可以执行定时任务的线程池
 *           第四种：创建单线程执行定时任务的线程池
 *           第五种：创建单个线程
 *           第六种：根据当前的硬件生成对应个数的线程池，并且是异步执行的，最大生成数为CPU核数
 *           第七种：（推荐方式）原始的线程池创建方式ThreadPool方式
 *如果使用前6种创建线程池的方式会导致的问题
 * 1.线程数量不可控（比如创建带缓存的线程池）
 * 2.工作量不可控，可能会造成内存溢出
 *
 * 线程池的五种拒绝策略
 * 1.不执行任务，抛出异常  ThreadPoolExecutor.AbortPolicy()
 * 2.把当前任务交给主线程执行 ThreadPoolExecutor.CallerRunsPolicy()
 * 3.丢弃最老的任务 ThreadPoolExecutor.DiscardOldestPolicy()
 * 4.丢弃最新的任务  ThreadPoolExecutor.DiscardPolicy()
 *
 * 线程池执行的2种方式：
 * 1.执行任务无返回值 excute(new Runnable...)
 * 2.执行任务有返回值sumbit(Runnable 无返回值/ Callable 有返回值)
 */
public class ThreadDemo21 {
    //使用这个类来描述当前的工作线程是啥样的
    static class Worker extends Thread{
        private int id = 0;
        //每个Worker线程都需要从任务队列中去任务
        //需要能获取到任务队列的实例
        private BlockingQueue<Runnable> queue = null;

        public Worker(BlockingQueue<Runnable> queue,int id) {
            this.queue = queue;
            this.id = id;
        }

        @Override
        public void run() {
            //注意 此处的try 吧while包裹进去了
            //目的是只要线程受到异常，就会立刻结束run 方法(也就是结束线程)
            try{
                while (!Thread.currentThread().isInterrupted()){
                    Runnable command = queue.take();
                    System.out.println("thread "+id+"running...");
                    command.run();
                }
            } catch (InterruptedException e) {
                //线程被结束，
                System.out.println("线程被终止!");
            }
        }
    }

    //本质上就是一个生产者消费者模型
    // 调用 execute 的代码就是生产者，生产了任务(Runnable对象)
    // worker 线程就是消费者，消费了队列中的任务
    // 交易场所就是 BlockingQueue
    static class MyThreadPool{
        //这个阻塞队列用来组织若干个任务
        private BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
        //这个List用来组织若干个工作线程
        private List<Worker> workers = new ArrayList<>();
        //一个线程池内部应该有多少个线程，需要根据实际情况来确定
        // 当前写的"10" 纯粹是拍脑门
        private static final int maxWorkerCount = 10;

        // 实现 execute 方法 和 shutdown 方法
        public void execute(Runnable command) throws InterruptedException {
            //也是使用延时加载的方式来创建线程
            //当线程池中线程数目比较少的时候，新创建线程来作为工作线程
            //如果线程数目要是比较多了(达到我们设定的阈值)，就不用新建线程了。
            if(workers.size() < maxWorkerCount){
                Worker worker = new Worker(queue,workers.size());
                worker.start();
                workers.add(worker);
            }
            queue.put(command);
        }

        //当 shutdown 结束之后，意味着所有的线程一定都结束了
        public void shutdown() throws InterruptedException {
            //终止掉所有的线程
            for (Worker worker : workers){
                worker.interrupt();
            }
            //还需要等待每个线程执行结束
            for (Worker worker : workers){
                worker.join();
            }
        }
    }

    static  class Command implements Runnable{
        private int num;
        public Command(int num){
            this.num = num;
        }

        @Override
        public void run() {
            System.out.println("正在执行任务: "+num);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThreadPool pool = new MyThreadPool();
        for (int i = 0; i <1000 ; i++) {
            pool.execute(new Command(i));
        }
        Thread.sleep(2000);
        pool.shutdown();
        System.out.println("线程池已经被销毁");
    }
}
