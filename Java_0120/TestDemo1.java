package Java_0120;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GaoBo
 * Date: 2021-01-21
 * Time: 8:24
 */
public class TestDemo1 {


    public static void main(String[] args) {

    }




    public static boolean isAdmin(String userId){
        return userId.toLowerCase()=="admin";
    }
    public static void main1(String[] args){
        String s1="abc"+"def";//1
        String s2=new String(s1);//2
        //   ==  比较的就是值一样不一样
        int a = 10;
        int b = 20;
        if(a == b) {

        }
        if(s1 == s2)//5
            System.out.println("==succeeded");//6
        if(s1.equals(s2)) {

        }
    }
}
