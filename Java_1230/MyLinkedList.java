package Java_1230;

class Node{
    public int val;
    public Node next;
    public Node(){

    }
    public Node(int val){
        this.val = val;
    }

}
public class MyLinkedList {
    public Node head; //表时当前链表的头

    public Node createLinked(){
        this.head = new Node(12);
        Node node2 = new Node(22);
        Node node3 = new Node(32);
        Node node4 = new Node(42);
        Node node5 = new Node(42);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        return node2;
    }
    public void display(){
        Node cur = this.head;
        while(cur!=null){
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    /**
     * 从指定位置开始进行打印
     * @return
     */
    public void display(Node newHead){
        Node cur = newHead;
        while(cur!=null){
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
        System.out.println();
    }
    //找到尾节点
    public Node findLastNode(){
        Node cur = this.head;
        while(cur.next!=null){
            cur = cur.next;
        }
        return cur;
    }
    public int Size(){
        Node cur = this.head;
        int count=0;
        while(cur!=null){
            count++;
            cur = cur.next;
        }
        return count;
    }
    public boolean contains(int key){
        Node cur = this.head;
        while(cur!=null){
            if(cur.val ==key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    //头插法
    public void addFirst(int data){
        //0.首先你得有一个节点
        Node node = new Node(data);
        //1.判断链表是不是空
        if(this.head==null){
            this.head = node;
        }else {

            /**
             * 在任何情况下，插入的时候，先绑定后面
             */
            //2.插入
            node.next = this.head;
            this.head = node;
//            优化版
//            Node node = new Node(data);
//            node.next = this.head;
//            this.head = node;
        }

    }
    public void addLast(int data){
        Node  node= new Node(data);
        //判空
        if(this.head==null){
            this.head=node;
        }else {
//            Node cur = this.head;
//            while(cur.next!=null){
//                cur = cur.next;
//            }
//            cur.next = node;
            findLastNode().next = node;
        }
    }
    public void addIndex(int index,int data){
        if(index<0||index>Size()){
            System.out.println("index不合法");
        }
        if(index==0){
            addFirst(data);
            return;
        }
        if(index==Size()-1){
            addLast(data);
            return;
        }
        Node cur= moveIndex(index);
        //cur保存的是index-1位置的节点
        Node node = new Node(data);
        node.next= cur.next;
        cur.next = node;
    }
    /**
     * 该函数是找到index-1位置的节点的引用
     * @param index
     * @return
     */
    public Node moveIndex(int index){
        Node cur = this.head;
        int count =0;
        while(count != index-1){
            cur = cur.next;
            count++;
        }
        return cur;
    }

    /**
     * 找到关键字key的前驱，如果有返回前驱节点的引用
     * 如果没有返回null
     * @param key
     * @return
     */
    public Node searchPrev(int key){
        Node cur = this.head;
        while(cur.next!=null){
            if(cur.next.val ==key){
                return cur;
            }
            cur = cur.next;
        }
        return null;//代表没有要删除的节点的前驱
    }
    public void remove(int key){
        //判空
        if(this.head==null){
            return;
        }
        //删除头结点
        if(this.head.val==key){
            this.head = this.head.next;
            return;
        }
        //正常删除
        Node cur = searchPrev(key);
        if(cur ==null){
            System.out.println("删除失败，没有Key的前驱");
        }else {
            Node del = cur.next;
            cur.next = del.next;
        }
    }
    public void removeAllKey(int key){
        if(this.head==null){
            return;
        }
        //正常删除
        Node prev = this.head;
        Node cur = prev.next;
        while (cur!=null){
            if(cur.val==key){
                prev.next = cur.next;
            }else {
                prev =cur;
            }
            cur = cur.next;
        }
        //如果头结点 = key，删除头结点
        if(this.head.val==key){
            this.head = this.head.next;
        }
    }
    public void clear(){
        this.head = null;
    }
    //反转链表
    public Node reverseList(){
        Node cur = this.head;
        Node prev = null;
        Node newHead = null;
        while(cur!=null){
            Node curNext = cur.next;
            if(curNext==null){
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return newHead;
    }
    //头插法反转链表
    public Node reverseList1(){
        Node cur = this.head;
        Node prev = null;
        while(cur!=null){
            Node curNext = cur.next;
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return prev;
    }
    public Node middleNode(){
        int len = Size()/2;
        Node cur =this.head;
        int count = 0;
        while(count!=len){
            cur =cur.next;
            count++;
        }
        return cur;
    }
    public Node middleNodeplus(){
        Node slow = this.head;
        Node fast = this.head;
        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    //寻找倒数第k个元素
    public Node FindKthToTail(Node head,int k){
        if(head==null||k<=0){
            return null;
        }
        Node fast = this.head;
        Node slow = this.head;
        while (k-1!=0){
            if(fast.next!=null){
                fast = fast.next;
                k--;
            }else {
                return null;//代表k值过大
            }
        }
        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 需要放在TestDemo类中调用，因为是两个链表的行为
     * @param headA
     * @param headB
     * @return
     */
    //合并两个有序递增链表
    public Node mergeTwoLists(Node headA,Node headB){
        Node newHead = new Node(-1);
        Node tmp = newHead;
        while (headA != null && headB != null){
            if(headA.val<headB.val){
                tmp.next =headA ;
                headA = headA.next;
            }else {
                tmp.next=headB;
                headB = headB.next;
            }
            tmp = tmp.next;
        }
        //代码走到这里。肯定是一个为空，一个不为空
        if (headA!=null){
            tmp.next = headA;
        }
        if (headB!=null){
            tmp.next = headB;
        }
        return newHead.next;
    }

    /**
     * 给定X，编写一段代码将所有小于x的结点排在其余结点之前，
     * 且不能改变原来的数据顺序，返回重新排列后的链表的头指针。
     * 牛客网：https://www.nowcoder.com/practice/0e27e0b064de4eacac178676ef9c9d70?
     * @param pHead
     * @param x
     * @return
     */
    public Node partition(Node pHead,int x){
        if(pHead==null){
            return null;
        }
        Node bs = null;
        Node be = null;
        Node as = null;
        Node ae = null;
        Node cur =pHead;
        while(cur!=null){
            if(cur.val<x){
                if(bs ==null){
                    //说明一个节点还没有的情况下
                    bs = cur;
                    be = cur;
                 }else {
                    //说明已经有了节点
                    be.next = cur;
                    be = be.next;
                }
            }else {
                if(as==null){
                    as = cur;
                    ae =cur;
                }else {
                    ae.next = cur;
                    ae = ae.next;
                }
            }
            cur = cur.next;
        }
        if(bs ==null){
            //说明第一个段里面没有数据
            return as;
        }
        be.next = as;
        if(as!=null){
            //说明最后一段肯定有数据
            ae.next = null;
        }
        return bs;
    }
    //删除链表的重复节点，重复节点不保留
    public Node deleteDuplication(Node pHead){
        if(pHead ==null){
            return null;
        }
        Node newHead = new Node(-1);
        Node tmp = newHead;
        Node cur = pHead;
        while (cur!=null){
            if(cur.next!=null&&cur.val ==cur.next.val){
                while (cur.next!=null&&cur.val==cur.next.val){
                    cur =cur.next;
                }
            }else {
                tmp.next = cur;
                tmp = tmp.next;
            }
            cur = cur.next;
        }
        tmp.next = null;
        return newHead.next;
    }
    //判断链表的回文结构
    public boolean chkPalindrome(){
        if(this.head == null){
            return false;
        }

        Node slow = this.head;
        Node fast = this.head;
        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        Node cur = slow.next;
        Node curNext = cur.next;
        while (cur!=null){
            cur.next = slow;
            slow = cur;
            cur = curNext;
        }
        while (head!=slow){
            if(head.val !=slow.val){
                return false;
            }
            if(head.next == slow){
                //判断偶数的情况
                return true;
            }
                this.head = head.next;
                slow = slow.next;
        }
        return true;
    }

    public  Node getIntersectionNode(Node headA , Node headB){
        if(headA == null || headB ==null){
            return null;
        }
        int lenA = 0;
        int lenB = 0;
        Node pl = headA;  //永远指向最长的链表
        Node ps = headB;  //永远指向最短的链表
        while (pl!=null){
            pl = pl.next;
            lenA++;
        }
        while (ps !=null){
            ps = ps.next;
            lenB++;
        }
        int len = lenA - lenB;
        if(len<0){
            pl = headB;
            ps = headA;
            len = lenB-lenA;
        }
        pl = headA;
        ps = headB; //没有这步会报空指针异常
        while (len != 0){
            pl = pl.next;
            len--;
        }
        while (pl != ps){
            pl = pl.next;
            ps = ps.next;
        }
        return pl;
    }
    //判断一个链表是否有环
    public boolean hasCycle(){
        if(this.head == null){
            return false;
        }
        Node fast = this.head;
        Node slow = this.head;
        while(fast !=null &&fast.next !=null){
            fast =fast.next.next;
            slow = slow.next;
            if(fast == slow){
                break;
            }
        }
        if(fast ==null || fast.next ==null){
            return false;

        }
        return true;
    }
    public Node detectCycle(){
        if(this.head == null){
            return null;
        }
        Node fast = this.head;
        Node slow = this.head;
        while(fast !=null &&fast.next !=null){
            fast =fast.next.next;
            slow = slow.next;
            if(fast == slow){
                break;
            }
        }
        if(fast ==null || fast.next ==null){
            return null;
        }
        slow = this.head;
        while (fast!=slow){
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
    //替换法删除节点，不包括头结点和尾节点
    public void deleteNode(Node node){
        if(node == null){
            return;
        }
        node.val = node.next.val;
        node.next = node.next.next;
    }
    //旋转链表
    public Node rotatoRight(int k){
        if(head == null ||k<0 ){
            return null;
        }
        if(head.next == null){
            return head;
        }
        Node fast = head;
        Node slow = head;

        while (k != 0){
            if(fast.next != null){
                fast = fast.next;
                k--;
            }else {
                fast = head;
                k--;
            }
        }
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        if(fast == slow){
            return head;
        }
        Node tmp = slow.next;
        slow.next = null;
        fast.next = head;
        head = tmp;
        return head;
    }
}
