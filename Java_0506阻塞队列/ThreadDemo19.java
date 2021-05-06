package Java_0506阻塞队列;

/**
 * 阻塞队列的特点：
 * 1.当队列为空时候，继续出队就会阻塞队列，一直阻塞到其他线程入队成功为止
 * 2.当队列为满时候，继续入队就会阻塞队列，一直阻塞到其他线程出队列成功为止
 */
public class ThreadDemo19 {
    static class BlockingQueue{
        //普通的队列咋实现
        //1.基于链表
        //2.基于数组[使用这个方式]
        private final int[] array = new int[1000];
        private volatile int head = 0;
        private volatile int tail = 0;
        //head 和 tail 构成的是一个前闭后开区间
        //当两者重合的时候，可能表示队列空，也可能表示队列满
        //为了区分空还是满，就需要额外引入一个size 来表示
        private volatile int size = 0;

        //队列的基本操作
        //1.入队列
        //2.出队列
        //3.取队首元素
        //针对阻塞队列来说，只提供前两个操作，不支持取队首元素

        //阻塞版本的入队列，为了和之前版本区分，用了不同的名字
        public  void put(int value) throws InterruptedException {
            synchronized (this) {
                if(size == array.length){
                    wait();
                }

                //把value 放到队尾
                array[tail] = value;
                tail++;
                if(tail == array.length){
                    tail = 0;
                }
                size++;

                notify();
            }
        }

        //阻塞版本的出队列，用了不同的名字
        public  int take() throws InterruptedException {
            int ret = -1;
            synchronized (this) {
                if (size == 0){
                    wait();
                }

                ret = array[head];
                head++;
                if(head == array.length){
                    head = 0;
                }
                size--;

                notify();
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        BlockingQueue blockingQueue = new BlockingQueue();
        //搞两个线程分别模拟生产者消费者
        //第一次，让消费者消费的快一些，生产者生产的慢一些
        //此时，预期看到消费者线程阻塞等待，每次有新生产的元素的时候，消费者才能消费
        //第二次，让消费者消费的慢一些，生产者生产的快一些
        //此时，预期看到生产者线程刚开始会快速往队列中插入元素，插入满了之后就会阻塞等待
        //随后消费者线程每次消费一个线程，就会阻塞队列
        Thread  producer= new Thread(){
            @Override
            public void run(){
                for (int i = 0; i <10000 ; i++) {
                    try {
                        blockingQueue.put(i);
                        System.out.println("生产元素: " + i);
//    first                    Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        producer.start();

        Thread  consumer= new Thread(){
            @Override
            public void run(){
                while (true){
                    try {
                        int ret = blockingQueue.take();
                        System.out.println("消费元素: "+ ret);
                        Thread.sleep(500); //second
                        //暂时不sleep
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        consumer.start();
    }
    /**
     * 假设吧代码中的notify改成notifyAll，此时代码是否可行？
     *   假设现在有三个线程，一个线程生产，两个线程消费
     *   假设消费速度快，生产速度慢
     *
     *   两个消费者线程都会触发wait操作
     *   接下来当我们调用notifyAll的时候
     *   此时就把上面的两个线程都唤醒了！！
     *   于是两个线程都去尝试重新获取锁
     *   消费者1，先获取到锁，于是就执行下面的出队列操作(执行完毕，释放锁)
     *   消费者2，后获取到锁了，于是也执行下面的出队列操作！！但是[注意！！]刚才生产者生产的第一个元素，已经被消费者1线程给取走了
     *   当前实际是一个空的队列，如果强行往下执行取队列元素操作，就会出现逻辑上的错误
     *
     *解决方法
     *             synchronized (this) {
     *                 while (size == 0){
     *                     wait();
     *                 }
     *
     *              synchronized (this) {
     *                 while(size == array.length){
     *                     wait();
     *                 }
     *     把if改成while
     *     这种实现方式更严谨稳健
     *     能够保证条件肯定是成立的时候再真的执行后面的实际操作
     *     否则就只能强制进行wait
     *
     */
}

