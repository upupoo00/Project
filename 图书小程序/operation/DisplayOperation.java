package Java_0118图书小程序.operation;

import Java_0118图书小程序.book.Book;
import Java_0118图书小程序.book.BookList;

public class DisplayOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("展示书籍");

        for (int i = 0; i <bookList.getUsedSize() ; i++) {
            Book book = bookList.getBook(i);
            System.out.println(book);
        }
    }
}
