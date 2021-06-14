package Java_0107;

class ListNode {
    private int val;
    private ListNode next;
    private ListNode prev;

    public int getVal() {
        return val;
    }

    public ListNode getNext() {
        return next;
    }

    public ListNode getPrev() {
        return prev;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public void setPrev(ListNode prev) {
        this.prev = prev;
    }

    //alt+insert  ->  constructor
    public ListNode(int val) {
        this.val = val;
    }
}
public class DoubleLinkedList {

    private ListNode head; //当前链表的头
    private ListNode last;//当前链表的尾

    //打印链表
    public void display() {
        ListNode cur = this.head;
        while (cur != null) {
            System.out.print(cur.getVal() + " ");
            cur = cur.getNext();
        }
        System.out.println();
    }

    //头插法
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        //链表判空
        if (this.head == null) {
            this.head = node;
            this.last = node;
        } else {
//            node.next = this.head;
            node.setNext(this.head);
//            this.head.prev = node;
            head.setPrev(node);
            this.head = node;
        }
    }

    //尾插法
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        if (this.head == null) {
            this.head = node;
            this.last = node;
        } else {
            this.last.setNext(node);
            node.setPrev(this.last);
            this.last = node;
        }
    }

    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index, int data) {
        if (index < 0 || index > size()) {
            return;
        }
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == size()) {
            addLast(data);
            return;
        }
        ListNode cur = this.head;
        while (index != 0) {
            cur = cur.getNext();
            index--;
        }
        ListNode node = new ListNode(data);
        //node.next = cur;
        node.setNext(cur);
        //node.prev = cur.prev;
        node.setPrev(cur.getPrev());
        //node.prev.next = node;
        node.getPrev().setNext(node);
        //cur.prev = node;
        cur.setPrev(node);

    }

    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key) {
        ListNode cur = this.head;
        while (cur != null) {
            if (cur.getVal() == key) {
                return true;
            }
            cur = cur.getNext();
        }
        return false;
    }

    public ListNode findNode(int key) {
        ListNode cur = this.head;
        while (cur != null) {
            if (cur.getVal() == key) {
                return cur;
            }
            cur = cur.getNext();
        }
        return null;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key) {
        ListNode cur = this.findNode(key);
        if (cur == null) {
            return;
        }
        if (cur == this.head) {
            this.head = this.head.getNext();
            //this.head.prev = null;
            this.head.setPrev(null);
            return;
        }
        if (cur == this.last) {
            cur.getPrev().setPrev(null);
            this.last = this.last.getPrev();
            return;
        }
        //cur.prev.next = cur.next;
        cur.getPrev().setNext(cur.getNext());
        //cur.next.prev = cur.prev;
        cur.getNext().setPrev(cur.getPrev());
    }

    public void remove2(int key) {
        ListNode cur = this.head;
        while (cur != null) {
            if (cur.getVal() == key) {
                if (cur == this.head) {
                    //删除头结点
                    this.head = this.head.getNext();
                    this.head.setPrev(null);
                } else {
                    cur.getPrev().setNext(cur.getNext());
                    if (cur.getNext() == null) {
                        cur.getNext().setPrev(cur.getPrev());
                    } else {
                        this.last = this.last.getPrev();
                    }
                }
                return;
            }
            cur = cur.getNext();
        }
    }

    //删除所有值为key的节点
    public void removeAllKey(int key) {
        ListNode cur = this.head;
        while (cur != null) {
            if (cur.getVal() == key) {
                if (cur == this.head) {
                    //删除头结点
                    this.head = this.head.getNext();
                    this.head.setPrev(null);
                } else {
                    cur.getPrev().setNext(cur.getNext());
                    if (cur.getNext() == null) {
                        cur.getNext().setPrev(cur.getPrev());
                    } else {
                        this.last = this.last.getPrev();
                    }
                }
            }
            cur = cur.getNext();
        }
    }

    //得到链表的长度
    public int size() {
        ListNode cur = this.head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.getNext();
        }
        return count;
    }

    public void clear() {
        this.head = null;
        this.last = null;
    }

    public void clear2(){
        ListNode cur = this.head;
        while (cur !=null){
            ListNode curNext = cur.getNext();
            cur.setNext(null);
            cur.setPrev(null);
            cur = curNext;
        }
        this.head = null;
        this.last = null;
    }
}
