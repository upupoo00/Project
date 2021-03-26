package com.shopping.service.impl;


import com.shopping.dao.CartDao;
import com.shopping.dao.impl.CartDaoImpl;
import com.shopping.model.Cart;
import com.shopping.service.CartService;

import java.util.List;

public class CartServiceImpl implements CartService {
    CartDao cd=new CartDaoImpl();
    @Override
    public int addcart(Cart cart) {
        return cd.addcart(cart);
    }

    @Override
    public int updatecart(Cart cart) {
        return cd.updatecart(cart);
    }

    @Override
    public int deletecart(int cid) {
        return cd.deletecart(cid);
    }

    @Override
    public Cart getcart(int cid) {
        return cd.getcart(cid);
    }

    @Override
    public List<Cart> getAllcart() {
        return cd.getAllcart();
    }

    @Override
    public List getcartbyuid(int uid) {
        return cd.getcartbyuid(uid);
    }

    @Override
    public int getcartcount(int uid, int sid) {
        return cd.getcartcount(uid,sid);
    }

    @Override
    public int getcartbyid(int uid, int sid) {
        return cd.getcartbyid(uid,sid);
    }
}
