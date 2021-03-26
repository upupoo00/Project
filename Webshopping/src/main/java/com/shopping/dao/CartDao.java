package com.shopping.dao;

import com.shopping.model.Cart;

import java.util.List;

public interface CartDao {
    public int addcart(Cart cart);
    public int updatecart(Cart cart);
    public int deletecart(int cid);
    public Cart getcart(int cid);
    public List<Cart> getAllcart();
    //购物车
    public List getcartbyuid(int uid);
    //按照用户id与商品id查找用户购买商品数量(cart.jap)
    public int getcartcount(int uid,int sid);
    //按照用户id与商品id查找购物车信息
    public int getcartbyid(int uid,int sid);
}
