package com.shopping.dao.impl;

import com.shopping.dao.UserDao;
import com.shopping.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends DBUtil implements UserDao {
    private Connection con;
    private PreparedStatement psmt;
    private ResultSet rs;
    @Override
    public int addUser(User user) {
        String sql="insert into user(username,phone,realname,sno,dormitory,sex,password) values (?,?,?,?,?,?,?)";
        Object obj[]={
                user.getUsername(),
                user.getPhone(),
                user.getRealname(),
                user.getSno(),
                user.getDormitory(),
                user.getSex(),
                user.getPassword()
        };
        return this.executeSql(sql,obj);
    }

    @Override
    public int updateUser(User user) {
        String sql="update user set username=?,phone=?,realname=?,sno=?,dormitory=?,sex=?,password=?,type=? where uid=?";
        Object obj[]={
                user.getUsername(),
                user.getPhone(),
                user.getRealname(),
                user.getSno(),
                user.getDormitory(),
                user.getSex(),
                user.getPassword(),
                user.getType(),
                user.getUid()

        };
        return this.executeSql(sql,obj);
    }

    @Override
    public int deleteUser(int uid) {
        String sql="delete from user where uid=?";
        Object obj[]={
                uid
        };
        return this.executeSql(sql,obj);
    }

    @Override
    public User getUser(int uid) {
        User user=new User();
        con=this.getCon();
        try {
            String sql = "select * from user where uid=?";
            psmt=con.prepareStatement(sql);
            psmt.setInt(1,uid);
            rs=psmt.executeQuery();
            if(rs.next()){
                user.setUid(rs.getInt("uid"));
                user.setUsername(rs.getString("username"));
                user.setPhone(rs.getString("phone"));
                user.setRealname(rs.getString("realname"));
                user.setSno(rs.getInt("sno"));
                user.setDormitory(rs.getString("dormitory"));
                user.setSex(rs.getString("sex"));
                user.setPassword(rs.getString("password"));
                user.setType(rs.getInt("type"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> getUserAll() {
        List<User> list=new ArrayList<User>();
        con=this.getCon();
        try {
            String sql = "select * from user";
            psmt=con.prepareStatement(sql);
            rs=psmt.executeQuery();
            while(rs.next()){
                User user= new User();
                user.setUid(rs.getInt("uid"));
                user.setUsername(rs.getString("username"));
                user.setPhone(rs.getString("phone"));
                user.setRealname(rs.getString("realname"));
                user.setSno(rs.getInt("sno"));
                user.setDormitory(rs.getString("dormitory"));
                user.setSex(rs.getString("sex"));
                user.setPassword(rs.getString("password"));
                user.setType(rs.getInt("type"));
                list.add(user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.closeAll();
        }
        return list;
    }

    @Override
    public User login(String username, String password) {
        User user=null;
        try {
            con=this.getCon();
            String sql = "select * from user where username=? and password=?";
            psmt=con.prepareStatement(sql);
            psmt.setString(1,username);
            psmt.setString(2,password);
            rs=psmt.executeQuery();
            if(rs.next()){
                user=new User();
                user.setUid(rs.getInt("uid"));
                user.setUsername(rs.getString("username"));
                user.setPhone(rs.getString("phone"));
                user.setRealname(rs.getString("realname"));
                user.setSno(rs.getInt("sno"));
                user.setDormitory(rs.getString("dormitory"));
                user.setSex(rs.getString("sex"));
                user.setPassword(rs.getString("password"));
                user.setType(rs.getInt("type"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.closeAll();
        }
        return user;
    }

    @Override
    public User getUserByName(String username) {
        User user=new User();
        con=this.getCon();
        try {
            String sql = "select * from user where username=?";
            psmt=con.prepareStatement(sql);
            psmt.setString(1,username);
            rs=psmt.executeQuery();
            if(rs.next()){
                user.setUid(rs.getInt("uid"));
                user.setUsername(rs.getString("username"));
                user.setPhone(rs.getString("phone"));
                user.setRealname(rs.getString("realname"));
                user.setSno(rs.getInt("sno"));
                user.setDormitory(rs.getString("dormitory"));
                user.setSex(rs.getString("sex"));
                user.setPassword(rs.getString("password"));
                user.setType(rs.getInt("type"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.closeAll();
        }
        return user;
    }

    @Override
    public int getUsercount() {
        int linecount=0;
        con=this.getCon();
        try {
            String sql = "select count(*) from user";
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
    public List<User> getUserFy(int pagenow) {
        List<User> list=new ArrayList<User>();
        con=this.getCon();
        try{
             String sql="select * from user limit ?,?";
             psmt=con.prepareStatement(sql);
             psmt.setInt(1,pagenow*5-5);
             psmt.setInt(2,5);
             rs=psmt.executeQuery();
             while(rs.next()){
                 User user= new User();
                 user.setUid(rs.getInt("uid"));
                 user.setUsername(rs.getString("username"));
                 user.setPhone(rs.getString("phone"));
                 user.setRealname(rs.getString("realname"));
                 user.setSno(rs.getInt("sno"));
                 user.setDormitory(rs.getString("dormitory"));
                 user.setSex(rs.getString("sex"));
                 user.setPassword(rs.getString("password"));
                 user.setType(rs.getInt("type"));
                 list.add(user);
             }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.closeAll();
        }
        return list;
    }
}
