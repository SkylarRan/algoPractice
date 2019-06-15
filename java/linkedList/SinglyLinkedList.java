package linkedList;

class Node{
    public int data;
    public Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}


public class SinglyLinkedList {

    private Node head;

    public SinglyLinkedList(){
        this.head = null;
    }


    /**
     * 从链表尾部加入新结点
     * @param data
     */
    public void append(int data){
        if(null == head){
            head = new Node(data);
            return;
        }

        Node current = head;
        while(current.next != null){
            current = current.next;
        }

        Node node = new Node(data);
        current.next = node;
    }

    /**
     * 从链表头部加入新结点
     * @param data
     */
    public void prepend(int data){
        Node n = new Node(data);

        if(null == head){
            head = n;
        }else{
            n.next = head;
            head = n;
        }
    }

    /**
     * 在链表中的指定元素后插入新结点
     * @param element
     * @param data
     */
    public boolean insert(int element, int data){
        if(null == head){
            System.out.println("链表为空");
            return false;
        }

        //查找指定元素
        Node current = head;
        while(current != null){
            if(current.data == element){
                Node node = new Node(data);
                node.next = current.next;
                current.next = node;
                return true;
            }
            current = current.next;
        }

        System.out.println("未找到指定元素");
        return false;
    }

    /**
     * 删除链表从头结点开始的第一个指定元素
     * @param element
     * @return
     */
    public boolean delete(int element){
        if(null == head){
            System.out.println("链表为空");
            return false;
        }

        // 头结点
        if(element == head.data){

            if(null == head.next){
                head = null;
            }else{
                head = head.next;
            }

            return true;
        }

        //从第二个结点开始查找
        Node current = head;
        while(current.next != null){
            if(element == current.next.data){
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }

        System.out.println("未找到指定元素");
        return false;
    }

    /**
     * 查找指定元素的结点信息,
     * @param value
     * @return
     */
    public Node findByValue(int value){
        Node current = head;

        while(null != current && value != current.data){
            current = current.next;
        }

        return current;
    }

    /**
     * 查找指定位置的结点
     * @param index 从0开始
     * @return
     */
    public Node findByIndex(int index){
        int count = 0;
        Node current = head;
        while (null != current){
            count++;
            if(index == count-1){
                break;
            }
            current = current.next;
        }

        return current;
    }

    public void print(){
        Node current = head;
        int count = 0;
        while(current != null){
            count ++;
            System.out.print(current.data + "\t");
            current = current.next;
        }
        System.out.println("count：" + count);
    }

    /**
     * 比较两个链表是否相同
     * @param one
     * @param two
     * @return
     */
    public boolean equal(Node one, Node two){

        printLinkList(one);
        printLinkList(two);

        Node p = one;
        Node q = two;

        while(null != p && null != q){

            if(p.data != q.data){
                return false;
            }

            p = p.next;
            q = q.next;
        }

        if(null == p && null == q){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 无头结点的链表反转
     * 例：链表结构的回文中，元素个数为奇数，只有一个中点，从头指针到中点开始反转，不包含中点
     * 例: 1 2 3 4 , p=4, return 4 3 2 1
     * @param p
     * @return
     */
    public Node inverseLinkList(Node p){
        Node r = head;
        Node pre = null;
        Node next;
        while(r != p){
            next = r.next; //获取当前结点的next
            r.next = pre;  //设置当前结点的next为pre
            pre = r;       //当前结点为pre
            r = next;      //移动至下一结点
        }

        r.next = pre;

        return r;
    }

    public void printLinkList(Node r){
        Node cur = r;
        while(null != cur){
            System.out.print(cur.data + "\t");
            cur = cur.next;
        }
        System.out.println();
    }

    /**
     * 带头结点的链表反转
     * 例：链表结构的回文中，元素个数为偶数，有两个中点，从头指针到第一个中点开始反转，包含中点
     * @param p
     * @return
     */
    public Node inverseLinkList_head(Node p){

        return p;
    }


    /**
     * 判断是否是回文
     * @return
     */
    public boolean palindrome(){
        if(null == head)
            return false;

        if(null == head.next)
            return true;

        //寻找中间结点
        Node p = head;
        Node q = head;
        while(null !=q.next && null != q.next.next){
            p = p.next;
            q = q.next.next;
        }

        Node left ;
        Node right ;

        if(null == q.next){
            //元素个数为奇数，只有一个中点 即为p
            right = p;
            left = inverseLinkList(p);

            return equal(left, right);

        }else{
            //元素个数为偶数，有两个中点，即 p和p.next
            right = p.next;
            //inverseLinkList函数中，当r==p时，修改r会同时修改掉p，所以先执行right = p.next
            left = inverseLinkList(p);
            return equal(left, right);

        }
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.append(1);
        list.append(2);
        list.append(3);
        list.append(2);
        list.append(2);
        list.append(1);
//        list.prepend(1);
//        list.prepend(2);
//        list.prepend(3);

//        list.append(3);
//        list.insert(2,5);
//        list.insert(1,0);
//        list.delete(3);
//        list.delete(2);


//        list.print();

//        Node n = list.findByValue(2);
//        Node n = list.findByIndex(0);
//        System.out.println(null == n? "null":n.toString());

        boolean flag = list.palindrome();
        System.out.println(flag);

    }

}
