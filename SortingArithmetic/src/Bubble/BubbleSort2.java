package Bubble;

/**
 * 优化
 */
public class BubbleSort2 {
    public static void main(String[] args) {
        int[] arr = {9,8,5,6,2,1};
        for (int i = arr.length-1; i >0 ; i--) {
            boolean flag = false;
            for (int j = 0; j <i ; j++) {
                if (arr[j]>arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = true;
                }
            }
            if(!flag){
                break;
            }
        }
        print(arr);
    }
    public static void print(int[] arr){
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
