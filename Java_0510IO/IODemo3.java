package Java_0510IO;

import java.io.*;

public class IODemo3 {
    public static void main(String[] args) {
        copyFile2();
    }

    private static void copyFile() throws IOException {
        //需要创建的实例是 BufferedInputStream 和 BufferdeOutStream
        //要创建这样的实例，需要先创建 FileInputStream 和FileOutputStream
        FileInputStream fileInputStream = new FileInputStream("d:/test_dir");
        FileOutputStream fileOutputStream = new FileOutputStream("d:/test_dir");

        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        byte[] buffer = new byte[1024];
        int  length = -1;
        while ((length = bufferedInputStream.read(buffer)) != -1){
            bufferedOutputStream.write(buffer,0,length);
        }
        //此处涉及到四个流对象~~
        //调用这一组close 时，就会自动关闭内部包含的FileInputStream 和 FileOutputStream
        //此处不需要关闭4处close
        bufferedInputStream.close();
        bufferedOutputStream.close();
    }

    private static void copyFile2(){
        try(BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("d:/test_dir"));
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("d:/test_dir"))){
            int len = -1;
            byte[] buffer = new byte[1024];
            while ((len = bufferedInputStream.read(buffer)) != -1){
                bufferedOutputStream.write(buffer);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
