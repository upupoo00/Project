package jvm;

public class JVMDemo1 {
    public static void main(String[] args) {
        A();
    }

    public static void A(){
        System.out.println("执行了方法A");
        B();
    }

    private static void B() {
        System.out.println("执行了方法B");
        C();
    }

    private static void C() {
        System.out.println("执行了方法B");
    }
}
