package Java_0520Thread;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadDemo23 {
    public static void main(String[] args) {
        for (int i = 1; i <11 ; i++) {
            int fianlI = i;
            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    Date date = new Date(fianlI*1000);
                    myFormatTime(date);
                }
            });
            thread1.start();
        }
    }

    /**
     * 时间格式化方法
     * @param date 带格式化的时间
     */
    private static void myFormatTime(Date date){
        SimpleDateFormat format = new SimpleDateFormat("mm:ss");
        String result =  format.format(date);
        System.out.println(Thread.currentThread().getName()+"格式化的时间: " +result);
    }
}
