package com.shopping.dao.impl;


import com.shopping.dao.CommoditDao;
import com.shopping.model.Cart;
import com.shopping.model.Commodit;
import com.shopping.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CommoditDaoImpl  extends DBUtil implements CommoditDao {
    private Connection con;
    private PreparedStatement psmt;
    private ResultSet rs;
    @Override
    public int addCommodit(Commodit commodit) {
        String sql="insert into commodit(name,level,remark,price,sort,count,uid,image)values(?,?,?,?,?,?,?,?)";
        Object obj[]={
                commodit.getName(),
                commodit.getLevel(),
                commodit.getRemark(),
                commodit.getPrice(),
                commodit.getSort(),
                commodit.getCount(),
                commodit.getUid(),
                commodit.getImage()
        };
        return this.executeSql(sql,obj);
    }

    @Override
    public int updateCommodit(Commodit commodit) {
        String sql="update commodit set name=?,level=?,remark=?,price=?,sort=?,count=?,uid=?,image=? where sid=?";
        Object obj[]={
                commodit.getName(),
                commodit.getLevel(),
                commodit.getRemark(),
                commodit.getPrice(),
                commodit.getSort(),
                commodit.getCount(),
                commodit.getUid(),
                commodit.getImage(),
                commodit.getSid()
        };
        return this.executeSql(sql,obj);
    }

    @Override
    public int deleteCommodit(int sid) {
        String sql="delete from commodit where sid=?";
        Object obj[]={
                sid
        };
        return this.executeSql(sql,obj);
    }

    @Override
    public Commodit getCommodit(int sid) {
        Commodit commodit=new Commodit();
        con=this.getCon();
        try {
            String sql = "select * from commodit where sid=?";
            psmt=con.prepareStatement(sql);
            psmt.setInt(1,sid);
            rs=psmt.executeQuery();
            if(rs.next()){
                commodit.setSid(rs.getInt("sid"));
                commodit.setName(rs.getString("name"));
                commodit.setLevel(rs.getString("level"));
                commodit.setRemark(rs.getString("remark"));
                commodit.setPrice(rs.getDouble("price"));
                commodit.setSort(rs.getString("sort"));
                commodit.setCount(rs.getInt("count"));
                commodit.setUid(rs.getInt("uid"));
                commodit.setImage(rs.getString("image"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return commodit;
    }

    @Override
    public List<Commodit> getCommoditAll() {
        List<Commodit> list=new ArrayList<Commodit>();
        con=this.getCon();
        try {
            String sql = "select * from commodit";
            psmt=con.prepareStatement(sql);
            rs=psmt.executeQuery();
            while(rs.next()){
                Commodit commodit= new Commodit();
                commodit.setSid(rs.getInt("sid"));
                commodit.setName(rs.getString("name"));
                commodit.setLevel(rs.getString("level"));
                commodit.setRemark(rs.getString("remark"));
                commodit.setPrice(rs.getDouble("price"));
                commodit.setSort(rs.getString("sort"));
                commodit.setCount(rs.getInt("count"));
                commodit.setUid(rs.getInt("uid"));
                commodit.setImage(rs.getString("image"));
                list.add(commodit);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.closeAll();
        }
        return list;
    }

    @Override
    public List<Commodit> getCommoditByUid(int uid) {
        List<Commodit> list=new ArrayList<Commodit>();
        con=this.getCon();
        try {
            String sql = "select * from commodit where uid=?";
            psmt=con.prepareStatement(sql);
            psmt.setInt(1,uid);
            rs=psmt.executeQuery();
            while(rs.next()){
                Commodit commodit= new Commodit();
                commodit.setSid(rs.getInt("sid"));
                commodit.setName(rs.getString("name"));
                commodit.setLevel(rs.getString("level"));
                commodit.setRemark(rs.getString("remark"));
                commodit.setPrice(rs.getDouble("price"));
                commodit.setSort(rs.getString("sort"));
                commodit.setCount(rs.getInt("count"));
                commodit.setUid(rs.getInt("uid"));
                commodit.setImage(rs.getString("image"));
                list.add(commodit);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Commodit> getcommoditindex() {
        List<Commodit> list=new ArrayList<Commodit>();
        con=this.getCon();
        try {
            String sql = "select * from commodit limit 0,5";
            psmt=con.prepareStatement(sql);
            rs=psmt.executeQuery();
            while(rs.next()){
                Commodit commodit= new Commodit();
                commodit.setSid(rs.getInt("sid"));
                commodit.setName(rs.getString("name"));
                commodit.setLevel(rs.getString("level"));
                commodit.setRemark(rs.getString("remark"));
                commodit.setPrice(rs.getDouble("price"));
                commodit.setSort(rs.getString("sort"));
                commodit.setCount(rs.getInt("count"));
                commodit.setUid(rs.getInt("uid"));
                commodit.setImage(rs.getString("image"));
                list.add(commodit);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Commodit> getCommoditBySort(String sort) {
        List<Commodit> list=new ArrayList<Commodit>();
        con=this.getCon();
        try {
            String sql = "select * from commodit where sort=?";
            psmt=con.prepareStatement(sql);
            psmt.setString(1,sort);
            rs=psmt.executeQuery();
            while(rs.next()){
                Commodit commodit= new Commodit();
                commodit.setSid(rs.getInt("sid"));
                commodit.setName(rs.getString("name"));
                commodit.setLevel(rs.getString("level"));
                commodit.setRemark(rs.getString("remark"));
                commodit.setPrice(rs.getDouble("price"));
                commodit.setSort(rs.getString("sort"));
                commodit.setCount(rs.getInt("count"));
                commodit.setUid(rs.getInt("uid"));
                commodit.setImage(rs.getString("image"));
                list.add(commodit);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Commodit> getCommoditFy(int pagenow) {
        List<Commodit> list=new ArrayList<Commodit>();
        con=this.getCon();
        try{
            String sql="select * from commodit limit ?,?";
            psmt=con.prepareStatement(sql);
            psmt.setInt(1,pagenow*8-8);
            psmt.setInt(2,8);
            rs=psmt.executeQuery();
            while(rs.next()){
                Commodit commodit= new Commodit();
                commodit.setSid(rs.getInt("sid"));
                commodit.setName(rs.getString("name"));
                commodit.setLevel(rs.getString("level"));
                commodit.setRemark(rs.getString("remark"));
                commodit.setPrice(rs.getDouble("price"));
                commodit.setSort(rs.getString("sort"));
                commodit.setCount(rs.getInt("count"));
                commodit.setUid(rs.getInt("uid"));
                commodit.setImage(rs.getString("image"));
                list.add(commodit);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.closeAll();
        }
        return list;
    }

    @Override
    public List<Commodit> getCommoditByName(String findname) {
        List<Commodit> list=new ArrayList<Commodit>();
        con=this.getCon();
        try {
            String sql = "select * from commodit where name like concat('%',?,'%')";
            psmt=con.prepareStatement(sql);
            psmt.setString(1,findname);
            rs=psmt.executeQuery();
            while(rs.next()){
                Commodit commodit= new Commodit();
                commodit.setSid(rs.getInt("sid"));
                commodit.setName(rs.getString("name"));
                commodit.setLevel(rs.getString("level"));
                commodit.setRemark(rs.getString("remark"));
                commodit.setPrice(rs.getDouble("price"));
                commodit.setSort(rs.getString("sort"));
                commodit.setCount(rs.getInt("count"));
                commodit.setUid(rs.getInt("uid"));
                commodit.setImage(rs.getString("image"));
                list.add(commodit);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;

    }

    @Override
    public int getCommoditcount(){
        int linecount=0;
        con=this.getCon();
        try {
            String sql = "select count(*) from commodit";
            psmt = con.prepareStatement(sql);
            rs = psmt.executeQuery();
            if(rs.next()) {
                linecount = rs.getInt("count(*)");//一共有linecount条数据
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.closeAll();
        }
        return linecount;
    }

    @Override
    public List<Commodit> findCommoditFy(int pagenow) {
        List<Commodit> list = new ArrayList<Commodit>();
        con = this.getCon();
        try {
            String sql = "select * from commodit limit ?,?";
            psmt = con.prepareStatement(sql);
            psmt.setInt(1, pagenow * 5 - 5);
            psmt.setInt(2, 5);
            rs = psmt.executeQuery();
            while (rs.next()) {
                Commodit commodit= new Commodit();
                commodit.setSid(rs.getInt("sid"));
                commodit.setName(rs.getString("name"));
                commodit.setLevel(rs.getString("level"));
                commodit.setRemark(rs.getString("remark"));
                commodit.setPrice(rs.getDouble("price"));
                commodit.setSort(rs.getString("sort"));
                commodit.setCount(rs.getInt("count"));
                commodit.setUid(rs.getInt("uid"));
                commodit.setImage(rs.getString("image"));
                list.add(commodit);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeAll();
        }
        return list;
    }
}
