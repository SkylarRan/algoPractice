package search;
/*
常见的二分查找变形问题
前提：数组按从小到大排序，且有重复元素
 */
public class BinarySearchComplex {
    //1.查找第一个值等于给定值的元素
    //重复元素较少时，a[mid] == value 后可mid-- 依次查找第一个给定元素
    //重复元素较多时，a[mid] == value 后仍使用二分查找，执行效率更高（更常用）
    //注：位移操作符 优先级 小于 加减法
    public static int bSearch1(int[] a, int value){
        int low = 0, high = a.length - 1 ;
        while(low <= high){
            int mid = low + ((high - low) >>1 );
            if(a[mid] == value && (0 == mid || a[mid-1] != value)){
                return mid;
            } else if(a[mid] < value){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
    //2.查找最后一个值等于给定值的元素
    public static int bSearch2(int[] a, int value){
        int low = 0, high = a.length - 1 ;
        while(low <= high){
            int mid = low + ((high - low) >>1 );
            if(a[mid] == value && (a.length == mid || a[mid+1] != value)){
                return mid;
            } else if(a[mid] > value){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
    //3.查找第一个大于等于给定值的元素
    public static int bSearch3(int[] a, int value) {
        int low = 0, high = a.length - 1;
        while (low <= high) {
            int mid = low + (high - low)>>1;
        }
        return -1;
    }
    //4.查找最后一个大于等于给定值的元素

    public static void main(String[] args){
        int[] a = {1,1,1,2,3,3,3,4,5};
//        int index = bSearch1(a,1);
        int index = bSearch2(a,3);
        System.out.println("index:" + index);
    }
}
