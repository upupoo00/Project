package Thread;

/**
 * 多线程（至少三个线程）分别打印A、B、C，要求按ABC的顺序循环打印10次。
 */
public class ThreadDemo5 {

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            Thread a = new Thread(new Runner("A"));
            a.start();
            a.join();
            Thread b = new Thread(new Runner("B"));
            b.start();
            b.join();
            Thread c = new Thread(new Runner("C"));
            c.start();
            c.join();
            System.out.println();
        }
    }

}

class Runner implements Runnable {
    private String name;

    public Runner(String name) {
        this.name = name;
    }

    public void run() {
        System.out.print(name);
    }
}