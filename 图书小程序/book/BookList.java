package Java_0118图书小程序.book;

public class BookList {
    private Book[] books;
    private int usedSize;

    public BookList() {
        this.books = new Book[10];

        books[0] = new Book("三国演义" ,"罗贯中 ",120,"小说");
        books[1] = new Book("水浒传", "施耐庵", 100, "小说");
        books[2] = new Book("西游记", "吴承恩", 100, "小说");
        this.usedSize = 3;
    }
    //尾插法
    public void setBooks(int pos,Book book){
        books[pos] = book;
    }

    public Book getBook(int pos){
        return this.books[pos];
    }

    public int getUsedSize() {
        return usedSize;
    }

    public void setUsedSize(int usedSize) {
        this.usedSize = usedSize;
    }


}
