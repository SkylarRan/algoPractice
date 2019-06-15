package stack;

/**
 * 基于数组实现栈： 顺序栈
 * 此例：栈固定大小
 */
public class ArrayStack {

    private String[] items; //栈中的数组元素
    private int count;      //栈中的元素个数
    private int n;          //栈的大小

    public ArrayStack(int n){
        this.items = new String[n];
        this.count = 0;
        this.n = n;
    }

    /**
     * 入栈（从数组尾部插入）
     * @param item
     * @return
     */
    public boolean push(String item){

        //栈已满
        if(count == n) return false;

        items[count] = item;
        count++;
        return true;
    }

    /**
     * 出栈（从数组尾部删除）
     * @return
     */
    public String pop(){
        //栈为空
        if(0 == count) return null;

        String tmp = items[count-1];
        count --;
        return tmp;

    }

    public void print(){
        for (int i = 0; i < count; i++) {
            System.out.print(items[i] + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(5);

        arrayStack.push("a");
        arrayStack.push("b");
        arrayStack.push("c");
        arrayStack.push("d");

        arrayStack.print();

        while(arrayStack.count > 0){
            arrayStack.pop();
            arrayStack.print();
        }

    }

}
