import com.shopping.dao.UserDao;
import com.shopping.dao.impl.UserDaoImpl;
import com.shopping.model.User;

public class UserDaoImplTest {
    public static void main(String[] args) {
        UserDao ud=new UserDaoImpl();
        User user=new User();
        user.setUid(1);
        user.setUsername("a123456");
        user.setPhone("13571351111");
        user.setRealname("张三");
        user.setSno(1816612);
        user.setDormitory("12b-114");
        user.setSex("女");
        user.setPassword("111111");
     // ud.addUser(user);
//        System.out.println(ud.updateUser(user));
//        System.out.println(ud.login("a123456","111111"));
//        ud.deleteUser(1);
        //System.out.println(ud.login("a123456","111111"));
//        System.out.println(ud.getUsercount());
        System.out.println(ud.getUserFy(1));
    }

}
