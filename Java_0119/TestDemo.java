package Java_0119;


class MyException  extends RuntimeException{
    public MyException(String message) {
        super(message);
    }
}
class MyException2 extends Exception{
    public MyException2(String message) {
        super(message);
    }
}
public class TestDemo {
    public static void main(String[] args) {
        try {
            throw new MyException("bit");
        }catch (MyException e){
            e.printStackTrace();
        }
    }
}
