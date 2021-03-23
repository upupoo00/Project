package Java_0118图书小程序.user;

import Java_0118图书小程序.operation.*;

import java.util.Scanner;

public class AdminUser extends User{

    public AdminUser(String name) {
        super(name);
        this.operations = new IOperation[]{
                new ExitOperation(),
                new FindOperation(),
                new AddOperation(),
                new DelOperation(),
                new DisplayOperation()
        };
    }

    /**
     * 返回你要执行的操作
     * @return
     */
    @Override
    public int menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("======================");
        System.out.println("hello" + this.name+"欢迎登录图书系统");
        System.out.println("1.查找图书");
        System.out.println("2.新增图书");
        System.out.println("3.删除图书");
        System.out.println("4.显示图书");
        System.out.println("0.退出系统");
        System.out.println("======================");
        int choice = scanner.nextInt();
        return choice;
    }
}
