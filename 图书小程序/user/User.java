package Java_0118图书小程序.user;

import Java_0118图书小程序.book.BookList;
import Java_0118图书小程序.operation.IOperation;

public abstract class User {

    public String name;
    public IOperation[] operations;

    public  User(String name){
        this.name = name;
    }

    public abstract int menu();

    public void doOperation(int choice, BookList bookList){
        //看这个数组中  存的到底是哪些操作
        this.operations[choice].work(bookList);
    }
}
