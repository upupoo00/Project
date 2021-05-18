package Java_0510IO;

import java.io.*;

public class IODemo5 {
    public static void main(String[] args) {

    }

    private static void copyFile(){
        //处理文本文件，需要使用字符流
        //这是一个不带缓冲区的版本
        try(FileReader fileReader = new FileReader("");
            FileWriter fileWriter = new FileWriter("")){
            char[] buffer = new char[1024];
            int len = -1;
            while ((len = fileReader.read(buffer)) != -1){
                fileWriter.write(buffer,0,len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void copyFile2(){
        //带缓冲区的字符流
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(""));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(""))){
            int len = -1;
            char[] buffer = new char[1024];
            while ((len = bufferedReader.read(buffer)) != -1){
                bufferedWriter.write(buffer,0,len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void copyFile3(){
        //带缓冲区的字符流中有一种特殊的用法，按行读取
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(""));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(""))){
            String line = "";
            //readLine()表示读一行，读到换行符为止，如果读取文件完毕，就会返回null
            while ((line = bufferedReader.readLine()) != null){
                //readLine读到的一行数据，会自动吧结尾的换行符删掉，加上"\n"可以解决
                bufferedWriter.write(line + "\n");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
