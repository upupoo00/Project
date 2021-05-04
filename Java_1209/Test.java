package Java_1209;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Scanner;

/***
 *                *
 *               ***
 *              *****
 *             *******
 *              *****
 *               ***
 *                *
 */

public class Test {
    public static void main(String[] args) {
//        int ret=Number(1);
//        int ret2=Number2(1);
//        System.out.println(ret);
//        System.out.println(ret2);
//      int ret3=  addint(2,5);
//        System.out.println(ret);
//        int arry[]={1,2,3,4,5,6,7,8,9,10};
//        for (int i =0; i <arry.length ; i++) {
//            for (int j = i+1; j <arry.length ; j++) {
//                if(arry[j]%2!=0){
//                    int tmp=arry[j];
//                    arry[j] = arry[i];
//                    arry[i] = tmp;
//                }
//            }
//            System.out.print(arry[i]+" ");
//
//        }
//        Scanner sc = new Scanner(System.in);
//        int arry2[] = sc.
//        System.out.println(arry2[]);
    }


    public static int max(int a,int b) {
        return a>b?a:b;
    }
    public static double max(double i,double j) {
        return i>j?i:j;
    }
    public static double max (double i,double j,int k) {
        return max(max(i,j),k);
    }//求最大值问题
    public static int max2(int a,int b) {
        return a>b?a:b;
    }
    public static int max3(int a,int b,int c) {
        return max2(max(a,b),c);
    }
    public static int addint(int a1,int b1) {
        return a1+b1;
    }
    public static double adddouble(double x1,double y1,double z1) {
        return x1+y1+z1;
    }
    public static int Number(int n){
        if(n<10){
          return n;
        }
        return n%10+Number(n/10);
    }
    public static int Number2(int n){
        if(n==0){
            return 0;
        }
        return n%10+Number2(n/10);
    }
    public static int Sum(int n){
        if(n<=1){
            return 1;
        }
        return Sum(n-1)+n;
    }
    public static int Func(int n){
      if(n>9){
          Func(n/10);
      }
        System.out.print(n%10+" ");
      return n;
    }
    public static  int Fab2(int n){
        if(n==0){
            return 0;
        }
        if(n<=2){
            return 1;
        }
        return Fab2(n-1)+Fab2(n-2);
    }
    public static int Fab(int n){
        int a=1;
        int b=1;
        int sum = a+b;
        if(n==0){
            return 0;
        }
        else if(n==1||n==2){
            return 1;
        }else{
            for (int i = 3; i <n ; i++) {
                a=b;
                b=sum;
                sum=a+b;
            }
            return sum;
        }

    }

    public static int jiecheng(int num){

        if(num==1){
            return 1;
        }
        return jiecheng(num-1)*num;//
    }

    public static void main4(String[] args) {
        System.out.println("请输入一个数字");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        for (int i =n; i >0 ; i--) {
            sum += jiecheng(i);
        }
        System.out.println("该数阶乘和为"+sum);
        //求的是阶乘和，输入3=1！+2！+3！


    }



    public static void main3(String[] args) {

        for (int i= 1;i<=3;i++){//前三行 啊
            for (int j = 1;j <=4-i; j++) {
                //**个数忘求了还有空格给我搞混了都这个之前学的
              //  昨天写js想了一下，想出事了
                System.out.print(" ");
            }
            for (int a=1;a<=2*i-1;a++){
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i =4; i>=1; i--) {//那不是跟这个重叠了?????
            for (int j = 1;j<=4-i;j++) {
                System.out.print(" ");
            }
            for (int a=1;a<=2*i-1;a++){
                System.out.print("*");//空格连带着不是改了？？
            }
            System.out.println();//
        }

    }
    public static void main2(String[] args) {
        for (int i = 1; i < 5; i++) {//行数
//            for (int j = 1; j <=4-i; j++) {//i=1->j=3 i=2->j=2
//                System.out.print(" ");
//            }
            for(int a=1;a<=2*i-1;a++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void main1(String[] args) {

        for (int i = 1; i <=5 ; i++) {//行数
            for (int a = 1; a <i; a++) {//a=i  1
                System.out.print(" ");
            }
            for (int j =1; j <=6-i; j++) {//每行的**个数
                System.out.print("*");
            }
            System.out.println();
        }//是 再加个循环？//
    }
}
