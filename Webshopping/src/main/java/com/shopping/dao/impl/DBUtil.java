package com.shopping.dao.impl;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class DBUtil {
    private Connection con;
    private PreparedStatement psmt;
    private ResultSet rs;
    private static DataSource dataSource;

    static {
        try {
            //读取资源文件
            InputStream inputStream = DBUtil.class.getClassLoader().getResourceAsStream("db.properties");
            Properties properite = new Properties();
            properite.load(inputStream);//将输入流中的数据加载到properties对象当中
            dataSource= DruidDataSourceFactory.createDataSource(properite);//创建数据库连接池
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //使用数据库连接池连接数据库
    public Connection getCon() {
        try {
            con = dataSource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public void closeAll() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (psmt != null) {
                psmt.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            con = null;
            psmt = null;
            rs = null;
        }

    }
    //增删改
    public int executeSql(String sql,Object obj[]){
        int a=0;
        con=this.getCon();
        try{
            psmt=con.prepareStatement(sql);
            for(int i=0;i<obj.length;i++){
                psmt.setObject(i+1,obj[i]);
            }
            a=psmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.closeAll();
        }
        return a;
    }

    public static void main(String[] args) {
        new DBUtil().getCon();
    }
}
