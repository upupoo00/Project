package Java17_1206;

public class Findnumber {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 4, 3, 2, 1};
        find(array);

    }
    public static void find(int[]array){
        for (int i = 0; i <array.length; i++) {
            int count = 0;
            int j=0;
            for (j=0; j <array.length ; j++) {
                if(array[i]==array[j]){
                    count++;
                }
                if(count==2){
                    break;
                }
            }
            if(j==array.length){
                System.out.println(array[i] + ", 下标是: " + i);
            }
        }
    }
}
