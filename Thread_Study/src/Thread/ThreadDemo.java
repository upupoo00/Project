package Thread;

//线程停止的方式，设置标记位，这种方式比较温和
public class ThreadDemo {
    private static boolean flag = false;
    public static void main(String[] args) throws InterruptedException {

        Thread  t1= new Thread(){
            @Override
            public void run(){
                while (!flag){
                    System.out.println("别烦我，我在忙着转账");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
                System.out.println("转账操作被终止");
            }
        };
         t1.start();
         Thread.sleep(5000);
        System.out.println("有内鬼终止交易！！");
        flag=true;
    }
}
