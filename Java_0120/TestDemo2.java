package Java_0120;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GaoBo
 * Date: 2021-01-21
 * Time: 11:30
 */
class Student {
    public String name;
    public int age;
    public double score;

    public Student(String name, int age, double score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}
public class TestDemo2 {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(9);
        Collections.sort(list);
        System.out.println(list);
    }

    public static void main3(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("bit",19,89.9));
        list.add(new Student("bit2",219,189.9));
        /*for (int i = 0;i < list.size();i++) {
            System.out.println(list.get(i));
        }*/

        /*for(Student student : list) {
            System.out.println(student);
        }*/
        /*Iterator<Student> it =list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }*/

        System.out.println(list);
    }


    public static void main2(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        //System.out.println(list);//1 2 3 4 5

        //迭代器  用来打印集合中的元素的
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        //建议大家 慎用iterator.remove
        iterator.remove();
        System.out.println(list);

        /*List<Integer> list1 = new ArrayList<>();
        list1 = list.subList(1,3);
        System.out.println(list1);//2 3

        list1.set(0,88);
        System.out.println(list1);//88 3

        System.out.println(list);*/

    }

    public static void main1(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        /*
          ArrayList底层是一个数组，每次放元素的时候
            放在了数组的最后。public boolean add(E e) {
             public void add(int index, E element) {
             这个方法是放在index位置
             问题：ArrayList底层是数组 那么他是多大？？
             1、new ArrayList<>()  调用的是 不带有参数的构造方法
               那么大小默认为0。
             2、当调用饿了默认的构造方法之后，当你添加第一个元素的时候
             会进行扩容，第一次扩容的时候，大小为10；
             3、当后续进行扩容的时候 ，是进行了1.5倍的方式进行扩容
         */
        list.add(1);
        System.out.println(list);

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(10);
        arrayList.add(20);

        list.addAll(arrayList);
        System.out.println(list);
        Integer integer = 1;
        list.remove(integer);
        System.out.println(list);
        list.set(0,99);
        System.out.println(list);
    }

}
