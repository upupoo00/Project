package Java_0117.demo2;

import java.awt.*;

/**
 * 接口：使用关键字interface修饰
 * 1.接口当中的方法，不能有具体的实现
 *    接口当中的方法，默认是: public abstract
 * 2.接口当中的成员变量，默认是 public static final修饰的
 * 3.JDK1.8引入的新特性。 default 修饰的方法，默认方法，可以有具体的实现
 * 4.接口不可以进行实例化： Ishape ishape = new Ishape();
 * 5.类和接口之间的关系是：implements
 * 6.一个类可以实现多个接口 class Test implements A,B,C
 * 7.一个类可以继承类，同时实现多个接口 class Test extends TestAbstract implements A,B,C
 * 8.接口可以扩展多个接口interface D extends A,B,C
 *      接口的出现就是为了解决Java 的多继承问题
 */
interface Ishape{
//    int age = 100;
//    default void func(){
//        System.out.println("func()");
//    }
    void  draw();

}
//extends：理解为扩展 而不是继承
interface Ishape2 extends Ishape{

}

class Rect implements Ishape {
    @Override
    public void draw() {
        System.out.println("◇");
    }
}
class Cycle implements Ishape{
    @Override
    public void draw() {
        System.out.println("○");
    }
}
public class TestDemo {
    public static void drawMap(Ishape shape){
        shape.draw();
    }
    public static void main(String[] args) {
//        Ishape shape = new Rect();
//        drawMap(shape);
        drawMap(new Rect());
    }
}
