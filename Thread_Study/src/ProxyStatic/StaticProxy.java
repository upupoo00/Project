package ProxyStatic;


//静态代理模式
//真实对象和代理对象都要实现同一个接口
//代理对象要代理真实角色
//好处
    //代理对象可以做很多真实对象做不了的事情
    //真实对象专注做自己的事情
//线程底部的实现原理就是代理模式

public class StaticProxy {

    public static void main(String[] args) {
        new Thread(()-> System.out.println("i love you")).start();
        new WeddingCompany(new You()).HappyMarry();
    }
}

interface Marry{
    void HappyMarry();
}

//真实角色，你去结婚
class You implements Marry{
    @Override
    public void HappyMarry() {
        System.out.println("今天结婚，很开心");
    }
}

//代理角色，婚庆公司，帮助你结婚
class WeddingCompany implements Marry{

    //代理谁-->真实角色
    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry();  //这就是真实对象
        after();
    }

    private void before() {
        System.out.println("结婚之前，布置现场。");
    }

    private void after() {
        System.out.println("结婚之后，收尾款。");
    }
}
