package Java_0510IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IODemo2 {

    public static void main(String[] args) throws IOException {
        copyFile("","");

    }

    private static void copyFile(String srcPath, String destPath) throws IOException {
        //0.先打开文件，才能读写.(创建InputStream/OutputStream 对象的过程)
        FileInputStream  fileInputStream = new FileInputStream(srcPath);
        FileOutputStream fileOutputStream = new FileOutputStream(destPath);
        //1.需要读取srcPath 对应文件内容
        byte[] bytes = new byte[1024];
        //单次读取 的内容是存在上限的(缓冲区的长度)，要想把文件整个都读完，需要搭配循环来使用
        int len = -1;
        //如果读到的len是-1说明读取结束，循环就结束了
        while ((len = fileInputStream.read(bytes))!=-1){
            //读取成功,就把读到的内容写入另外一个文件中即可
            //因为len 的值不一定就和缓冲区一样长
            //2.把读取到的内容写入到 destPath 对应的文件中
            fileOutputStream.write(bytes,0,len);
            System.out.println("拷贝成功!!!");
        }
        fileInputStream.close();
        fileOutputStream.close();
    }

    //升级版
    private static void copyFile2(String srcPath, String destPath){
        FileInputStream  fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            //0.先打开文件，才能读写.(创建InputStream/OutputStream 对象的过程)
            fileInputStream = new FileInputStream(srcPath);
            fileOutputStream = new FileOutputStream(destPath);
            //1.需要读取srcPath 对应文件内容
            byte[] bytes = new byte[1024];
            //单次读取 的内容是存在上限的(缓冲区的长度)，要想把文件整个都读完，需要搭配循环来使用
            int len = -1;
            //如果读到的len是-1说明读取结束，循环就结束了
            while ((len = fileInputStream.read(bytes))!=-1){
                //读取成功,就把读到的内容写入另外一个文件中即可
                //因为len 的值不一定就和缓冲区一样长
                //2.把读取到的内容写入到 destPath 对应的文件中
                fileOutputStream.write(bytes,0,len);
                System.out.println("拷贝成功!!!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream!=null) {
                    fileInputStream.close();
                }
                if(fileOutputStream!=null){
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void copyFile3(){
        //当代码写成这个样子的时候，就不需要显式调用close了
        //try 语句会在代码执行完毕后，自动调用close 方法(前提是这个类必须要实现Closable接口)
        try (FileInputStream fileInputStream = new FileInputStream("");
              FileOutputStream fileOutputStream = new FileOutputStream("")){
            byte[] bytes = new byte[1024];
            int len = -1;
            while ((len = fileInputStream.read(bytes)) != -1){
                fileOutputStream.write(bytes,0,len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
