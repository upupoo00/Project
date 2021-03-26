package com.shopping.dao;

import com.shopping.model.Commodit;
import com.shopping.model.User;

import java.util.List;

public interface CommoditDao {
    public int addCommodit(Commodit commodit);
    public int updateCommodit(Commodit commodit);
    public int deleteCommodit(int sid);
    public Commodit getCommodit(int sid);
    public List<Commodit> getCommoditAll();
    public List<Commodit> getCommoditByUid(int uid);
    //查询5条数据
    public List<Commodit> getcommoditindex();
    //按类型查找物品
    public List<Commodit> getCommoditBySort(String sort);
    //商城分页 查询8条数据
    public List<Commodit> getCommoditFy(int pagenow);
    //模糊查询
    public  List<Commodit> getCommoditByName(String findname);
    //查询有多少条数据
    public int getCommoditcount();
    //管理员界面分页 查询5条数据
    public List<Commodit> findCommoditFy(int pagenow);
}

