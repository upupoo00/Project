package Java_0706;

import java.util.LinkedList;
import java.util.Queue;

public class MyStackBy2Queue {

    private Queue<Integer> A = new LinkedList<>();
    private Queue<Integer> B = new LinkedList<>();

    public  void push(int x){
        A.offer(x);
    }


    public Integer pop(){
        if(empty()){
            return null;
        }
        //吧A中元素往B挪
        while (A.size() > 1){
            Integer front = A.poll();
            B.offer(front);
        }
        //当循环结束，A中就是一个元素，这个元素就是被出栈的元素
        int ret = A.poll();
        //交换 A B 的身份
        swapAB();
        return ret;
    }

    public void swapAB(){
        Queue<Integer> tmp = A;
        A = B;
        B = tmp;
    }


    public Integer top(){
        if(empty()){
            return null;
        }
        //吧A中元素往B挪
        while (A.size() > 1){
            Integer front = A.poll();
            B.offer(front);
        }
        //当循环结束，A中就是一个元素，这个元素就是被出栈的元素
        int ret = A.poll();
        B.offer(ret);
        //交换 A B 的身份
        swapAB();
        return ret;
    }

    public boolean empty(){
        return A.isEmpty() && B.isEmpty();
    }
}
