package Selection;

/**
 * 选择排序
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {5, 3, 6, 8, 1, 7, 9, 4, 2};

        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
//                if(arr[j]<arr[minPos]){
//                    minPos = j;
//                }
                minPos = arr[j] < arr[minPos] ? j : minPos;
            }
//            System.out.println("minPos=" + minPos);
            swap(arr,i,minPos);
            System.out.println("经过第" + (i+1) + "次循环后，数组的内容");
            print(arr);
        }
        System.out.println("==============================");
        System.out.println("经过计算，选择排序，时间复杂度为O(n²)");
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
