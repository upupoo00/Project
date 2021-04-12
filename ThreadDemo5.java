package Java_0318;

public class ThreadDemo5 {
    public static void main(String[] args) throws InterruptedException {
        Thread  t= new Thread(){
            @Override
            public void run(){
                //此处直接使用线程内部的标记位进行判定
                while(!Thread.currentThread().isInterrupted()){
                    System.out.println("别管我，我在忙着转账呢");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        //正确做法
                        break;
                    }
                }
                System.out.println("转账被终止.");
            }
        };
         t.start();

         Thread.sleep(5000);
        System.out.println("对方是内鬼，快终止交易");
        //这个操作本质上是给该线程触发一个异常 InterruptedException
        //此时线程内部就会收到这个异常，具体针对这个异常怎么处理，这是catch内部的事情
        t.interrupt();
    }
}
