package Java_0520Thread;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadPoolDemo26 {
    //ThreadLocal 使用
    //set
    //get
    //remove
    private static ThreadLocal<SimpleDateFormat> threadLocal =
            new ThreadLocal<>();
    public static void main(String[] args) {
        //设置私有变量
        threadLocal.set(new SimpleDateFormat("mm:ss"));

        //得到ThreadLocal
        SimpleDateFormat simpleDateFormat = threadLocal.get();
        Date date = new Date(1000);
        String result = simpleDateFormat.format(date);
        System.out.println("Time: "+result);
    }
}
