package Java_0706;

import java.util.Stack;

public class MyQueueBy2Stack {
    private Stack<Integer> A = new Stack<>();
    private Stack<Integer> B = new Stack<>();

    public  void push(int x){
        //1.先把B中的元素都倒腾到A里
        while (!B.isEmpty()){
            int tmp = B.pop();
            A.push(tmp);
        }
        //2.吧新元素入A
        A.push(x);
    }

    public Integer pop(){
        if(empty()) return null;
        while (!A.isEmpty()){
            int tmp = A.pop();
            B.push(tmp);
        }
        return B.pop();
    }

    public Integer peek(){
        if(empty()) return null;
        while (!A.isEmpty()){
            int tmp = A.pop();
            B.push(tmp);
        }
        return B.peek();
    }

    public boolean empty(){
        return A.isEmpty() && B.isEmpty();
    }
}
