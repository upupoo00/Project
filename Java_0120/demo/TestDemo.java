package Java_0120.demo;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GaoBo
 * Date: 2021-01-21
 * Time: 10:55
 */
public class TestDemo {

    /*
    选择题：
     */
    public static void main(String[] args) {
        Integer a = 200;
        Integer b = 200;
        System.out.println(a == b);
    }
    //拆包：包装类 变为简单类型
    public static void main2(String[] args) {
        Integer i = 10;
        int a = i;//自动拆箱 -> i.intValue()
        System.out.println(a);
        int a2 =i.intValue();//显示拆箱int
        System.out.println(a2);
        double d = i.doubleValue();//double
        System.out.println(d);
    }
    public static void main1(String[] args) {
        int a = 10;
        Integer integer1 = new Integer(a);//显示的装包
        System.out.println(integer1);
        Integer integer2 = Integer.valueOf(a);//显示装包
        System.out.println(integer2);
        Integer integer3 = a;//自动装包   其实也是调用了 Integer.valueOf
    }
}
