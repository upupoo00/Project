package com.shopping.service;


import com.shopping.model.Commodit;

import java.util.List;

public interface CommoditService {
    public int addCommodit(Commodit commodit);
    public int updateCommodit(Commodit commodit);
    public int deleteCommodit(int sid);
    public Commodit getCommodit(int sid);
    public List<Commodit> getCommoditAll();
    //查询5条数据
    public List<Commodit> getcommoditindex();
    //按类别查找商品
    public List<Commodit> getCommoditBySort(String sort);
    //分页
    public List<Commodit> getCommoditFy(int pagenow);
    //模糊查询
    public List<Commodit> getCommoditByName(String findname);
    //查询有多少条数据
    public int getCommoditcount();
    //分页 查询5条数据
    public List<Commodit> findCommoditFy(int pagenow);
}
