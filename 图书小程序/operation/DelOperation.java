package Java_0118图书小程序.operation;

import Java_0118图书小程序.book.BookList;

public class DelOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("删除书籍");
    }
}
