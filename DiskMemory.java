package MianShi;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DiskMemory {
    private int totalSize;
    public  int getSize(){
        return (new Random().nextInt(3)+1)*100;
    }

    public synchronized void setSize(int size){
        totalSize +=size;
    }

    public int getTotalSize(){
        return totalSize;
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(4);
        CountDownLatch countDownLatch = new CountDownLatch(4);
        DiskMemory diskMemory = new DiskMemory();
        for (int i = 0; i <4 ; i++) {
            service.execute(()->{
                int timer = new Random().nextInt(5);
                try {
                    Thread.sleep(timer * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int diskSize = diskMemory.getSize();
                System.out.printf("完成任务，耗时%d,磁盘大小%d.\n",timer,diskSize);
                diskMemory.setSize(diskSize);

                countDownLatch.countDown();
                System.out.println("count num = "+ countDownLatch.getCount());
            });
        }
        countDownLatch.await();
        System.out.println("所有磁盘总大小 "+ diskMemory.getTotalSize());
        service.shutdown();
    }
}
