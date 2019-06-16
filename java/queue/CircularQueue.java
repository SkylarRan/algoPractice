package queue;

public class CircularQueue {
    private String[] items;
    private int n;
    private int head;
    private int tail;

    public CircularQueue(int capacity) {
        this.items = new String[capacity];
        this.n = capacity;
        this.head = 0;
        this.tail = 0;
    }

    public boolean enqueue(String item){
        //队满
        if((tail+1)%n == head) return false;

        items[tail] = item;
        tail = (tail+1) % n;
        return true;
    }

    public String dequeue(){
        //队空
        if(head == tail) return null;

        String tmp = items[head];
        head = (head+1) % n;
        return tmp;
    }

    public void print(){
        System.out.println("head="+head + "\t" + "tail="+tail);

        if(tail >= head){
            for (int i = head; i < tail; i++) {
                System.out.print(items[i] + "\t");
            }
        }else {
            for (int i = head; i < n; i++) {
                System.out.print(items[i] + "\t");
            }
            for (int i = 0; i < tail; i++) {
                System.out.print(items[i] + "\t");
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue(6);
        circularQueue.enqueue("a");
        circularQueue.enqueue("b");
        circularQueue.enqueue("c");
        circularQueue.enqueue("d");
        circularQueue.enqueue("e");

        circularQueue.dequeue();
        circularQueue.dequeue();

        circularQueue.print();

        circularQueue.enqueue("f");
        circularQueue.enqueue("g");

        circularQueue.print();

    }
}
