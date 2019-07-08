package search;

public class BinarySearch {

    // 循环实现二分查找
    public static int binarySearch(int[] a, int value) {
        int low = 0, high = a.length - 1;

        while (low <= high) {
            // 考虑low + high可能会溢出，位移比除法运算要快
            int mid = low + ((high - low) >> 1);
            if (a[mid] == value) {
                return mid;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    //递归实现二分查找
    public static int bSearch(int[] a, int value) {
        return bSearchInternally(a, 0, a.length - 1, value);
    }

    public static int  bSearchInternally(int[] a, int low, int high, int value){
        if(low > high){
            return -1;
        }
        int mid = low + ((high - low) >> 1 );
        if(a[mid] == value){
            return mid;
        }else if(a[mid] < value){
            return bSearchInternally(a, mid+1, high, value);
        }else {
            return bSearchInternally(a, low, mid-1, value);
        }
    }

    public static void main(String args[]){
        int[] a = {1,3,5,7,9,11};
//        int result = binarySearch(a, 11);
        int result = bSearch(a, 10);
        System.out.println(result);
    }
}
