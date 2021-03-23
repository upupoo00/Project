package Java_0118图书小程序.operation;

import Java_0118图书小程序.book.Book;
import Java_0118图书小程序.book.BookList;

import java.util.Scanner;

public class AddOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("添加图书");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入图书的名字");
        String name = scanner.nextLine();
        System.out.println("请输入图书的作者");
        String author = scanner.nextLine();
        System.out.println("请输入图书的价格");
        int price = scanner.nextInt();
        System.out.println("请输入图书的类型");
        String type = scanner.next();
        int currentSize = bookList.getUsedSize();
        Book book = new Book(name,author,price,type);

        bookList.setBooks(currentSize,book);
        bookList.setUsedSize(currentSize+1);


    }
}
