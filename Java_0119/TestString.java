package Java_0119;

public class TestString {

    public static String reverse(String string){
        //字符串转为数组，进行逆至
        char[] chars = string.toCharArray();
        int i = 0;
        int j = chars.length-1;
        while (i<j){
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
            i++;
            j--;
        }
        //数组转化为字符串
//        return new String(chars);
//        return  String.copyValueOf(chars);
        return String.valueOf(chars);
    }
    public static void main(String[] args) {
        String str = "hello";
        String str2 = new String("hello");
        char[] value = {'h','e','l','l','o'};
        String str3 = new String(value);
        System.out.println(str == str2); //false
        System.out.println(str == str3); //false
        System.out.println(str2 == str3); // false2w3huy0-'

    }
}
