package Syc;

public class UnsafeBuyTickets {

    public static void main(String[] args) {
        BuyTickets buyTickets = new BuyTickets();
        new Thread(buyTickets,"程序员张三").start();
        new Thread(buyTickets,"测试人员李四").start();
        new Thread(buyTickets,"万恶的黄牛党").start();
    }
}

class BuyTickets implements Runnable{

    //票
    private int ticketNum = 10;
    private boolean flag = true;
    
    @Override
    public void run() {
        //买票
        while (flag){
            try {
                buy();
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private  synchronized void buy() throws InterruptedException {
        if(ticketNum<=0){
            flag = false;
            return;
        }

        System.out.println(Thread.currentThread().getName()+"拿到"+ticketNum--);
    }
}
