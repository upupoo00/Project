package Java_0526ThreadPlus;

/**
 * 可重入锁
 */
public class ThreadDemo32 {
    private  static Object object = new Object();

    public static void main(String[] args) {
        synchronized (object) {
            System.out.println("进入了主方法·······");
            synchronized (object){
                System.out.println("重复进入了方法·······");
            }
        }
    }
}
