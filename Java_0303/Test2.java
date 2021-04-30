package Java_0303;

import java.util.Scanner;
public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int j = 1;
        int max = 0;
        int min = 0;
        while (true) {
            max = create(j);
            if (n > max) {
                j++;
            } else {
                break;
            }
        }
        min = create(j - 1);
        if (n - min > max - n) {
            System.out.println(max - n);
        }
        if (n - min < max - n) {
            System.out.println(n - min);
        }
    }

    private static int create(int m) {
        if (m == 1) {
            return 0;
        }
        if (m == 2) {
            return 1;
        }
        return create(m - 1) + create(m - 2);
    }
}
