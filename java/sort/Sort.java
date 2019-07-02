package sort;

public class Sort {

    public static void print(int[] a, int n){
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + "\t");
        }
        System.out.println();
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


    public static void main(String[] args){
//        int[] a = {3,6,2,5,1,4};
        int[] a = {6,5,4,3,2,1};

        quickSort(a, a.length);
    }


}
