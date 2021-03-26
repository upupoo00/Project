package com.shopping.service;


import com.shopping.model.Cart;

import java.util.List;

public interface CartService {

    //增加，修改，删除
    public int addcart(Cart cart);
    public int updatecart(Cart cart);
    public int deletecart(int cid);
    public Cart getcart(int cid);
    public List<Cart> getAllcart();
    public List getcartbyuid(int uid);
    public int getcartcount(int uid,int sid);
    public int getcartbyid(int uid,int sid);
}
