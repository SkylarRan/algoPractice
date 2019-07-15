//package stack;
//
//import linkedList.SinglyLinkedList;
//
///**
// * 基于链表实现栈： 链式栈
// */
//public class LinkStack {
//
//    private SinglyLinkedList list;  //栈中的单链表元素
//
//    public LinkStack() {
//        this.list = new SinglyLinkedList();
//    }
//
//    public void push(int ele){
//        list.append(ele);
//    }
//
//    public int pop(){
//        return list.deleteTail();
//    }
//
//    public void print(){
//        list.print();
//    }
//
//    public static void main(String[] args) {
//        LinkStack linkStack = new LinkStack();
//        linkStack.push(1);
//        linkStack.push(2);
//        linkStack.push(3);
//
//        linkStack.print();
//
//        linkStack.pop();
//        linkStack.print();
//
//        linkStack.pop();
//        linkStack.print();
//
//        linkStack.pop();
//        linkStack.print();
//
//        linkStack.pop();
//        linkStack.print();
//    }
//}
