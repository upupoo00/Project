package Java_0510IO;

import java.io.*;

public class IODemo4 {

    public static void main(String[] args) {
        //分别使用缓冲区和不使用缓冲区来进行读取一个大文件操作~感受时间上的差异
        testNoBuffer();
        testBuffer();
    }

    private static void testBuffer() {
        //读的时候就一个字节一个字节的读，完全不使用任何缓冲区
        long beg = System.currentTimeMillis();
        try(FileInputStream fileInputStream = new FileInputStream("")){
            int ch = -1;
            while ((ch = fileInputStream.read()) != -1){
                //啥都不干
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("no buffer: "+(end-beg) +"ms");
    }

    private static void testNoBuffer() {
        long beg = System.currentTimeMillis();
        long end = System.currentTimeMillis();
        try(BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(""))){
            int ch = -1;
            while ((ch = bufferedInputStream.read()) != -1){
                //啥都不干
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("has buffer: "+(end-beg) +"ms");
    }
}
