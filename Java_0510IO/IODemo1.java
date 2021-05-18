package Java_0510IO;

import java.io.File;
import java.io.IOException;

public class IODemo1 {
    public static void main(String[] args) throws IOException {
        File file = new File("d:/test.txt");
        System.out.println("文件是否存在: "+file.exists());
        System.out.println("文件是否是普通文件: "+file.isFile());
        System.out.println("文件是否是目录: "+file.isDirectory());
//        file.delete();
//        System.out.println("文件是否存在: "+file.exists());
//        file.createNewFile();
        //目录操作
        File file1 = new File("d:/test_dir");
        System.out.println(file1.exists());
        System.out.println(file1.isDirectory());
        file1.mkdir();
        System.out.println(file1.exists());
        listAllFiles(file);

    }

    //递归罗列出一个目录中的所有文件
    private static void listAllFiles(File f){
        if(f.isDirectory()){
            //如果是目录，就把目录中包含的文件都罗列出来
            File[] files = f.listFiles();
            for (File file: files) {
                listAllFiles(file);
            }
        }else {
            //吧这个文件的路径直接打印出来
            System.out.println(f);
        }
    }
}
