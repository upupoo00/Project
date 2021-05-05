package Java_1230;

public class TestDemo {
    public static void main(String[] args) {

        MyLinkedList myLinkedList = new MyLinkedList();
        //这条代码结束，获得链表的头结点
        myLinkedList.createLinked();
        myLinkedList.display();
        System.out.println("=================");
        Node cur = myLinkedList.findLastNode();
        System.out.println(cur.val);
        System.out.println("=================");
        System.out.println(myLinkedList.Size());
        System.out.println("=================");
        System.out.println(myLinkedList.contains(42));
        myLinkedList.addLast(3);
        myLinkedList.display();
        System.out.println("================");
        myLinkedList.addIndex(2,21);
        myLinkedList.display();
        System.out.println("================");
        myLinkedList.remove(22);
        myLinkedList.display();
        Node ret =myLinkedList.middleNodeplus();
        System.out.println(ret.val);
        Node ret1 = myLinkedList.reverseList1();
        myLinkedList.display(ret1);
        System.out.println("================");
        Node node = myLinkedList.createLinked();
        myLinkedList.deleteDuplication(node);
        myLinkedList.display();
    }
}

