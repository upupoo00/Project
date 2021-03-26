package com.shopping.service;


import com.shopping.model.User;

import java.util.List;

public interface UserService {
    public int addUser(User user);
    public int updateUser(User user);
    public int deleteUser(int uid);
    public User getUser(int uid);
    public List<User> getUserAll();
    public User login(String username, String password);
    public User getUserByName(String username);
    //查询共有多少条数据
    public int getUsercount();
    //分页 查询5条数据
    public List<User> getUserFy(int pagenow);
}
