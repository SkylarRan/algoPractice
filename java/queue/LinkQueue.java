package queue;

import linkedList.SinglyLinkedList;

/**
 * 链式队列: 基于单链表
 */
public class LinkQueue {
    private SinglyLinkedList list;

    public LinkQueue(){
        list = new SinglyLinkedList();
    }

    /**
     * 入队：队尾添加新结点
     * @param item
     */
    public void enqueue(int item){
        list.append(item);
    }

    /**
     * 出队：队头删除第一个结点
     * @return
     */
    public int dequeue(){
        return list.deleteHead();
    }

    public static void main(String[] args) {
        LinkQueue linkQueue = new LinkQueue();

        linkQueue.enqueue(1);
        linkQueue.enqueue(2);
        linkQueue.enqueue(3);
        linkQueue.enqueue(4);

        linkQueue.dequeue();
        linkQueue.dequeue();
        linkQueue.dequeue();

        linkQueue.list.print();
    }
}
