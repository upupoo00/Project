package Insertion;

/**
 * 插入排序
 */
public class InsertionSort2 {
    public static void main(String[] args) {
        int[] a = {9, 3, 1, 4, 6, 8, 7, 5, 2};
        sort(a);
        print(a);
    }

    static void sort(int[] a){
        for (int i = 1; i <a.length ; i++) {
            for (int j = i; j >0 &&a[j]<a[j-1] ; j--) {
                swap(a,j,j-1);
            }
        }
    }

    static void swap(int[] a,int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    static void print(int[] arr){
        for (int value : arr) {
            System.out.print(value + " ");
        }
    }
}
