package Java_0122;

public class Test {
    public static int x = 100;

    public static boolean isAdmin(String userId) {
        return userId.toLowerCase() == "admin";

    }

    public static void main(String[] args) {
        System.out.println(isAdmin("Admin"));
    }
}
