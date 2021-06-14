package Java_0107;

public class TestDemo {
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addFirst(1);
        doubleLinkedList.addFirst(2);
        doubleLinkedList.addFirst(3);
        doubleLinkedList.addLast(3);
        doubleLinkedList.display();
        doubleLinkedList.addIndex(0,99);
        doubleLinkedList.display();
        doubleLinkedList.addIndex(5,55);
        doubleLinkedList.display();
        doubleLinkedList.removeAllKey(3);
        doubleLinkedList.display();

    }
}
