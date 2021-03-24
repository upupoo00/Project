package Bubble;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[]a = {9,3,1,4,6,8,7,5,2};
        sort(a);
        print(a);
        System.out.println("冒泡排序时间复杂为O(n²)");
    }
    public static void sort(int[]arr){
        for (int j = arr.length-1; j >0; j--) {
            findMax(arr, j);
        }
    }
    public static void findMax(int[] arr,int n){
        for (int i = 0; i <n ; i++) {
            if(arr[i]>arr[i+1]) swap(arr,i,i+1);
        }
    }
    public static void swap(int[] arr, int i , int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static void print(int[] arr){
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
