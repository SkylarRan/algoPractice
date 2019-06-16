package queue;

/**
 * 顺序队列
 */
public class ArrayQueue {

    private String[] items; //队列数组元素
    private int n;          //队列的大小
    private int head;       //队头
    private int tail;       //队尾

    public ArrayQueue(int capacity) {
        items = new String[capacity];
        this.n = capacity;
        this.head = 0;
        this.tail = 0;
    }

    /**
     * 入队tail+1
     * @param item
     * @return
     */
    public boolean enqueue(String item){
        //队列已满
        if(tail == n){
            if(0 == head) return false;

            //数据向前搬移head个单位
            for(int i = head; i < tail; i++){
                items[i-head] = items[i];
            }

            tail -= head;
            head = 0;
        }

        items[tail] = item;
        tail++;
        return true;
    }

    /**
     * 出队 head+1
     * @return
     */
    public String dequeue(){
        //队列已空
        if(head == tail) return null;

        String tmp = items[head];
        head ++ ;
        return tmp;
    }

    public void print(){
        System.out.println("head="+head + "\t" + "tail="+tail);
        for (int i = head; i < tail; i++) {
            System.out.print(items[i] + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(5);
        arrayQueue.enqueue("a");
        arrayQueue.enqueue("b");
        arrayQueue.enqueue("c");
        arrayQueue.enqueue("d");
        arrayQueue.enqueue("e");


        arrayQueue.dequeue();
        arrayQueue.dequeue();
        arrayQueue.dequeue();
        arrayQueue.enqueue("a");
        arrayQueue.enqueue("b");

        arrayQueue.print();

    }
}
