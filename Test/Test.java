package 秦轲;
public class Test {
    public static void main(String[] args) {
        /*数据类型 （4类8种）
        整数类型：byte(字节类型) short(短整型) long(长整型) int(整形)
        浮点类型： float(单精度浮点型（1.1,2.1）) double(双精度浮点型（11.11,12.22）)
        布尔类型: boolean
        字符类型： char    现在给你把每个类型都定义一遍
         */
         //byte a=1;
        // short a=1;
        //long a=1;
       // int a= 1.1;   //定义这4个只能写整数
        //float a=1.1f;  //注意  这里要加f
        //double a=1.1d;   //这里不用加d！可以 但没必要  没有加e的  只有这两个会加 其余不会
        // boolean flag=false; //布尔类型只能定义为true 或者 false
        //当用if  或者 while 判断时
//        if(1==1){  // 括号里会判断是 true 或者 false   而且只有这两种结果  这里1==1 的结果是 true
//
//        }

//         在UTF-8中 英文占1字节 中文占3字节
//         在JBK中  各占两个字节
//        char a='秦'; // char 类型定义的时候用单引！  而且只能有一个字符
//        char b='克';
//
//        字符串
//        String c="sdadasfds当年发表你dafa2651561";// 可以添加任何类型
//
//         4类八种就这些
//       注释键 ctrl+斜杠 这个会不？ 两种注释方式 单行 在行前直接加 //  还有一种

        /*
            就像计数器的内容到最大值时会自动归零一样。而在整数中最小值为
            -2147483648，所以当整数 x 的值最大时，加上 1 就会变成最小值-2147483648，也就
            是产生了溢出。
         */

//        int a=Integer.MIN_VALUE;
//        System.out.println(a);
//          //double a=1/2;//等于?  这里 1 2 都为int  结果应该为0.5会舍弃小数部分
//         char a='A';
//         int b=(int)a;
//         System.out.println(b);  // A 为65 a为65+32  查询assic值
        //字符串拼接会不
//        String a="秦";
//        String b="轲";
//        String c="是";
//        String d="nt";
//        System.out.println(a+b+c+d);
//        //或者
//        System.out.println("秦轲是"+d);//会了没  给你看个例子  sql语句会不 insert into stu
//        int x;
//        {
//            x=1;
//            System.out.println(x);
//        }
//        System.out.println(x);  //和刚才的原理一样  x只存在上面的代码块中

        //你现在养成习惯  比如要定义学生学号:Stu_id  学生姓名:Stu_name
        //final int x=1;// 被final修饰的变量不能被修改  不一样   现在给你说这个有些早 先不管他 final也是 太早
        //类型转换
//        int a=1;
//        double b=1.1;
//        b=a; //大小 double>float>int  大转小不用加（） 小转大 得加
//        a=(int)b;//等于1 会丢失精度
//        System.out.println(a);

        // int 与 String 转换  有时候会用 得知道这个方法
//         int a=100;
//         String b="99";
//        // b=String.valueOf(a);
//        int c=Integer.parseInt(b);
//        System.out.println(c);//这里a不能转换为其assic值
        //大转小会发生数据丢失


        System.out.println("hello");

        //毫不相干的两种类型, 不能相互赋值. 例：boolean和int
        //养成习惯 每敲完一行 保存 ctrl+s

    }
    //先不看语句错误  这里的x只存在于 main中 在方法外不能调用  不能说不是全局变量 只能说是局部变量
}
