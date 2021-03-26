package com.shopping.dao.impl;
import com.shopping.dao.CartDao;
import com.shopping.model.Cart;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CartDaoImpl extends DBUtil implements CartDao {
    private Connection con;
    private PreparedStatement psmt;
    private ResultSet rs;
    @Override
    public int addcart(Cart cart) {
        String sql="insert into cart(uid,sid,count)values(?,?,?)";
        Object obj[]={
                cart.getUid(),
                cart.getSid(),
                cart.getCount()
        };
        return this.executeSql(sql,obj);
    }

    @Override
    public int updatecart(Cart cart) {
        String sql="update cart set count=? where uid=? and sid=?";
        Object obj[]={
                cart.getCount(),
                cart.getUid(),
                cart.getSid()
        };
        return this.executeSql(sql,obj);
    }

    @Override
    public int deletecart(int cid) {
        String sql="delete from cart where cid=?";
        Object obj[]={
                cid
        };
        return this.executeSql(sql,obj);
    }

    @Override
    public Cart getcart(int cid) {
        Cart cart=new Cart();
        con=this.getCon();
        try {
            String sql = "select * from cart where cid=?";
            psmt=con.prepareStatement(sql);
            psmt.setInt(1,cid);
            rs=psmt.executeQuery();
            if(rs.next()){
                cart.setCid(rs.getInt("cid"));
                cart.setUid(rs.getInt("uid"));
                cart.setSid(rs.getInt("sid"));
                cart.setCount(rs.getInt("count"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return cart;
    }

    @Override
    public List<Cart> getAllcart() {
        List<Cart> list=new ArrayList<Cart>();
        con=this.getCon();
        try {
            String sql = "select * from cart";
            psmt=con.prepareStatement(sql);
            rs=psmt.executeQuery();
            while(rs.next()){
                Cart cart=new Cart();
                cart.setCid(rs.getInt("cid"));
                cart.setUid(rs.getInt("uid"));
                cart.setSid(rs.getInt("sid"));
                cart.setCount(rs.getInt("count"));
                list.add(cart);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.closeAll();
        }
        return list;
    }

    @Override
    public List getcartbyuid(int uid) {
        List list=new ArrayList();
        con=this.getCon();
        try {
            String sql = "select * from cart where uid=?";
            psmt=con.prepareStatement(sql);
            psmt.setInt(1,uid);
            rs=psmt.executeQuery();
            while(rs.next()){
                int sid=(rs.getInt("sid"));
                list.add(sid);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.closeAll();
        }
        return list;
    }

    @Override
    public int getcartcount(int uid,int sid) {
        int count=0;
        con=this.getCon();
        try {
            String sql = "select * from cart where uid=? and sid=?";
            psmt=con.prepareStatement(sql);
            psmt.setInt(1,uid);
            psmt.setInt(2,sid);
            rs=psmt.executeQuery();
            while(rs.next()){
                count=(rs.getInt("count"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.closeAll();
        }
        return count;
    }

    @Override
    public int getcartbyid(int uid, int sid) {
        int cid=0;
        con=this.getCon();
        try {
            String sql = "select * from cart where uid=? and sid=?";
            psmt=con.prepareStatement(sql);
            psmt.setInt(1,uid);
            psmt.setInt(2,sid);
            rs=psmt.executeQuery();
            while(rs.next()){
                cid=(rs.getInt("cid"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.closeAll();
        }
        return cid;
    }


}
