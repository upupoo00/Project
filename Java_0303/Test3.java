package Java_0303;

import java.util.HashSet;
import java.util.Scanner;


public class Test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<String> set = new HashSet<>();
        while(scanner.hasNext()){
            String str = scanner.nextLine();
            String[] arr = str.split(" ");
            for (int i = 0; i <arr.length ; i++) {
                set.add(arr[i]);
            }
        }
        System.out.println(set.size());
    }
}
