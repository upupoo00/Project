package Java_0318;

public class ThreadDemo11 {
    static class Test{
        private Object o = new Object();
        public void method(){
            synchronized (this){
                System.out.println("hello");
            }
        }
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.method();
    }
}
