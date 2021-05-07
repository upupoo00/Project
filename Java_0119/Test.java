package Java_0119;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: upupoo0
 * Date: 2021-01-19
 * Time: 15:41
 */
class UserException extends Exception {
    public UserException(String message) {
        super(message);
    }
}
class PasswordException extends Exception {
    public PasswordException(String message) {
        super(message);
    }
}

public class Test {

    public static String userName = "admin";
    public static String password = "admin";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = scanner.next();
        System.out.println("请输入密码：");
        String password = scanner.next();
        try {
            login(username,password);
        } catch (UserException e) {
            e.printStackTrace();
        } catch (PasswordException e) {
            e.printStackTrace();
        }
    }
    public static void login(String userName,String password) throws UserException,PasswordException{
        if (!Test.userName.equals(userName)) {
            throw new UserException("用户名错误");
        }
        if (!Test.password.equals(password)) {
            throw new PasswordException("密码错误");
        }
        System.out.println("登陆成功");
    }

}
