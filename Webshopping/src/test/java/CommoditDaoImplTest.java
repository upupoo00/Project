import com.shopping.dao.CommoditDao;
import com.shopping.dao.impl.CommoditDaoImpl;
import com.shopping.model.Commodit;

public class CommoditDaoImplTest {
    public static void main(String[] args) {
        CommoditDao cd=new CommoditDaoImpl();
        Commodit commodit=new Commodit();
        commodit.setName("Apple iphone 12");
        commodit.setLevel("八成");
        commodit.setRemark("卖家:XX（联系:11111111）");
        commodit.setPrice(288.0);
        commodit.setSort("女装:(上装)");
        commodit.setCount(2);
        commodit.setUid(1);
        commodit.setImage("主页女装.jpg");
        commodit.setSid(2);
       // cd.addCommodit(commodit);
        //cd.updateCommodit(commodit);
//        cd.deleteCommodit(2);
        //System.out.println(cd.getCommoditAll());
//        System.out.println(cd.getCommoditByUid(2));
//        System.out.println(cd.getcommoditindex());
//        System.out.println(cd.getCommoditFy(1));
        System.out.println(cd.getCommoditByName("女包"));
    }


}
