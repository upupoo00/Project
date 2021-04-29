package Thread;

/**
 * 查看线程的状态
 */
public class ThreadDemo3 {
    public static void main(String[] args) {

        for(Thread.State state : Thread.State.values()){
            System.out.println(state);
        }
    }
}
