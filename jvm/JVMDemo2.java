package jvm;

public class JVMDemo2 {
    private Object obj = null;
    private Object[] objects = new Object[5*1024*1024];

    public static void main(String[] args) {
        JVMDemo2 j1 = new JVMDemo2();
        JVMDemo2 j2 = new JVMDemo2();
        //循环引用
        j1.obj = j2;
        j2.obj = j1;
        //强制垃圾回收
        System.gc();
        j1 = null;
        j2 = null;
    }
}
