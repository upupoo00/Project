import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);
        int n = sca.nextInt();
        int[][] a = new int[n][n];
        int[][] b = new int[n][n];
        int min;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<=i;j++){
                a[i][j] = sca.nextInt();
            }
        }

        b[0][0] = a[0][0];
        for(int i = 1;i<n;i++){
            for(int j = 0;j<=i;j++){
                if(j==0)//左侧，直接相加
                    b[i][j] = b[i-1][j]+a[i][j];
                else if(j==i)//右侧，直接相加
                    b[i][j] = b[i-1][j-1]+a[i][j];
                else//中间，需要用min函数求经过这条路的最短路径
                    b[i][j] = Math.min(b[i-1][j-1],b[i-1][j])+a[i][j];
            }
        }

        min = b[n-1][0];
        for(int i = 1;i<b[n-1].length;i++){
            if(b[n-1][i]<min)
                min = b[n-1][i];
        }
        System.out.println(min);
    }
}
