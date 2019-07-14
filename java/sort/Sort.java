package sort;

public class Sort {

    public static void bubbleSort(int[] a, int n){
        if(n <=1 ) return;

        for (int i = 0; i < n-1; i++) {
            //提前退出循环标志：若无数据交换，则已排好序
            boolean flag = false;
            for (int j = 0; j < n-i-1; j++) {
                if(a[j] > a[j+1]){
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                    flag = true;
                }
            }
            print(a, n);

            if(!flag) break;
        }
    }

    public static void insertionSort(int[] a,int n){
        if(n <= 1) return;

        for (int i = 1; i < n; i++) {
            int value = a[i];
            int j = i-1;
            for ( ;j >= 0 ; j--) {
                if(a[j] > value){
                    a[j+1] = a[j];
                }else{
                    break;
                }
            }
            a[j+1] = value;
            print(a, a.length);
        }
    }

    public static void selectionSort(int[] a, int n){
        if(n <= 1) return;

        for (int i = 0; i < n; i++) {

            //选出未排序元素的最小值
            int min = i;
            for (int j = i+1; j < n; j++) {
                if(a[j] < a[min]){
                    min = j;
                }
            }

            int tmp = a[i];
            a[i] = a[min];
            a[min] = tmp;

            print(a, a.length);

        }
    }

    public static void mergeSort(int[] a, int n){
        mergeSortInternally(a, 0, n-1);
    }

    public static void mergeSortInternally(int[] a, int p, int r){
        //递归终止条件
        if(p >= r) return;

        //取p和r的中间值q
        //int q = (p + r) / 2;
        //取p和r的中间值，防止p+r超过int类型最大值
        int q = p + (r-p) / 2;

        //分治递归
        mergeSortInternally(a, p, q);
        mergeSortInternally(a, q+1, r);

        //将a[p,q]和a[q+1,r]合并成a[p,r]
        merge(a,p,q,r);


    }

    public static void merge(int[] a, int p, int q, int r){
        int i = p, j = q+1, k = 0;
        int[] tmp = new int[r-p + 1];

        while(i<=q && j<=r){
            if(a[i] <= a[j]){
//                tmp[k] = a[i];
//                k++;
//                i++;
                tmp[k++] = a[i++];
            } else{
//                tmp[k] = a[j];
//                k++;
//                j++;
                tmp[k++] = a[j++];
            }
        }

        //判断哪个子数组中有剩余的元素
        int start = i, end = q;
        if(j <= r){
            start = j;
            end = r;
        }
        //将剩余数据拷贝到临时数组中
        while (start <= end){
            tmp[k++] = a[start++];
        }

        //将临时数组tmp拷贝至a[p,r]
        for (i = 0; i < r-p+1; i++) {
            a[p+i] = tmp[i];
        }

        print(a, 6);
    }

    public static void quickSort(int[] a, int n){
        quickSortInternally(a, 0, n-1);
    }

    public static void quickSortInternally(int[] a, int p, int r){
        //递归终止条件
        if(p >= r)  return;

        int q = partition(a, p, r);
        quickSortInternally(a, p, q-1);
        quickSortInternally(a, q+1, r);

    }

    public static int partition(int[] a, int p, int r){
        int pivot = a[r];
        int i = p;
        for (int j = p; j < r ; j++) {
            if(a[j] <= pivot){
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                i++;
            }
        }

        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;
        System.out.println("pivot:" + pivot);
        print(a, a.length);
        return i;
    }

    public static void print(int[] a, int n){
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
//        int[] a = {3,5,4,1,2,6};
        int[] a = {6,5,4,3,2,1};
//        selectionSort(a, a.length);
//        insertionSort(a,a.length);
//        bubbleSort(a, a.length);
//        mergeSort(a, 6);

    }
}
