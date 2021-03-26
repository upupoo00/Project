package com.shopping.service.impl;
import com.shopping.dao.CommoditDao;
import com.shopping.dao.impl.CommoditDaoImpl;
import com.shopping.model.Commodit;
import com.shopping.service.CommoditService;

import java.util.List;

public class CommoditServiceImpl implements CommoditService {
    CommoditDao cmd=new CommoditDaoImpl();
    @Override
    public int addCommodit(Commodit commodit) {
        return cmd.addCommodit(commodit);
    }

    @Override
    public int updateCommodit(Commodit commodit) {
        return cmd.updateCommodit(commodit);
    }

    @Override
    public int deleteCommodit(int sid) {
        return cmd.deleteCommodit(sid);
    }

    @Override
    public Commodit getCommodit(int sid) {
        return cmd.getCommodit(sid);
    }

    @Override
    public List<Commodit> getCommoditAll() {
        return cmd.getCommoditAll();
    }

    @Override
    public List<Commodit> getcommoditindex() {
        return cmd.getcommoditindex();
    }

    @Override
    public List<Commodit> getCommoditBySort(String sort) {
        return cmd.getCommoditBySort(sort);
    }

    @Override
    public List<Commodit> getCommoditFy(int pagenow) {
        return cmd.getCommoditFy(pagenow);
    }

    @Override
    public List<Commodit> getCommoditByName(String findname) {
        return cmd.getCommoditByName(findname);
    }

    @Override
    public int getCommoditcount() {
        return cmd.getCommoditcount();
    }

    @Override
    public List<Commodit> findCommoditFy(int pagenow) {
        return cmd.findCommoditFy(pagenow);
    }
}