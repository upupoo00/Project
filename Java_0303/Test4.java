package Java_0303;

import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int in = sc.nextInt();
        int n = 0;
        int flag = 0;
        while (true){
            flag = func(n);
            if(in>=flag){
                n++;
            }else {
                break;
            }
        }
        int flag1 = func(n-1);
        if(Math.abs(in-flag)>Math.abs(in-flag1)){
            System.out.println(in-Math.abs(in-flag1));
        }else {
            System.out.println(flag-in);
        }
    }
    public static int func(int x){
        if(x==1||x==0){
            return 0;
        }
        if(x==2){
            return 1;
        }
        return func(x-1)+func(x-2);
    }
}

