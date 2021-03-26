import com.shopping.dao.CartDao;
import com.shopping.dao.impl.CartDaoImpl;
import com.shopping.model.Cart;

public class CardDaoImplTest {
    public static void main(String[] args) {
        CartDao cd=new CartDaoImpl();
        Cart card=new Cart();
        card.setSid(5);
        card.setUid(1);
        card.setCount(2);
        //cd.addcard(card);
        //cd.updatecard(card);
        //cd.deletecard(2);
//        System.out.println(cd.getAllcart());
//        System.out.println(cd.getcartbyid(1,3));
//        System.out.println(cd.addcart(card));
//        System.out.println(cd.getcartcount(1,1));
//        System.out.println(cd.updatecart(card));
    }
}
