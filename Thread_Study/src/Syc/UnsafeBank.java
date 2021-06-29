package Syc;

public class UnsafeBank {

    public static void main(String[] args) {
        Account account = new Account(100,"结婚基金");
        Drawing you =  new Drawing(account,50,"你");
        Drawing wife =  new Drawing(account,100,"wife");

        you.start();
        wife.start();

    }
}

//账户
class  Account{
    int money; //余额
    String name; //卡号

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

//银行：模拟取款
class Drawing extends Thread{
    Account account; //账户
    int drawingMoney; //取了多少钱
    int nowMoney; //手里有多少钱

    public Drawing(Account account, int drawingMoney, String name){
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public void run() {
        synchronized (account){
            if(account.money-drawingMoney < 0){
                System.out.println(Thread.currentThread().getName()+"钱不够，取不出来");
                return;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //账户余额
            account.money = account.money-drawingMoney;
            //手里的钱
            nowMoney = nowMoney+drawingMoney;

            System.out.println(account.name+"余额为: "+account.money);
            System.out.println(this.getName()+"手里的钱为: "+nowMoney);
        }
    }
}
