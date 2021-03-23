package Java_1207;

public class Hanoi_Tower {
    public static void move(char pos1 ,char pos2) {
        System.out.print(pos1+"->"+pos2+" ");
    }
    public static void hannota(int n,char pos1,char pos2 ,char pos3){
        if(n==1){
            move(pos1,pos3);
            return;
        }
        else{
            hannota(n-1,pos1,pos2,pos3);
            move(pos1,pos3);
            hannota(n-1,pos2,pos1,pos3);
        }
    }
    public static void main(String[] args) {

        hannota(2, 'A', 'B', 'C');
    }
}
