package array;

/**
 * 一维数组
 */
public class Array {

    private int[] data;
    // 定义数组长度
    private int n;
    // 定义实际保存的数组元素个数
    private int count;

    public Array(int capacity){
        this.data = new int[capacity];
        this.n = capacity;
        this.count = 0;
    }

    /**
     * 在指定位置插入元素
     * @param index
     * @param e
     * @return
     */
    public boolean insert(int index, int e){
        //数组已满
        if(count == n){
            System.out.println("数组已满，没有可插入的位置");
            return false;
        }

        //位置不合法
        if(index < 0 || index > count){
            System.out.println("插入位置不合法");
            return false;
        }

        for(int i = count-1; i >= index; i -- ){
            data[i+1] = data[i];
        }

        data[index] = e;
        count ++;

        return true;
    }

    /**
     * 删除指定位置的元素
     * @param index
     * @return
     */
    public int delete(int index){

        if(count == 0){
            System.out.println("数组为空");
            return -1;
        }

        if(index < 0 || index >= count){
            System.out.println("索引不合法");
            return -1;
        }

        int e = data[index];
        for(int i = index; i < count-1; i++){
            data[i] = data[i+1];
        }
        count-- ;

        return e;
    }

    public void print(){
        for(int i = 0; i < count; i++){
            System.out.print(data[i] + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Array array = new Array(5);
        array.insert(0, 0);
        array.insert(1, 1);
        array.insert(2, 2);
        array.insert(3, 7);
        array.insert(3, 5);

        array.delete(2);
        array.delete(0);
        array.delete(0);
        array.delete(0);
        array.delete(0);
        array.delete(0);

        array.print();

    }


}
