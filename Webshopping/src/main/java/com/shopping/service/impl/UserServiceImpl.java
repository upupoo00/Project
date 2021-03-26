package com.shopping.service.impl;


import com.shopping.dao.UserDao;
import com.shopping.dao.impl.UserDaoImpl;
import com.shopping.model.User;
import com.shopping.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
  private UserDao ud=new UserDaoImpl();
    @Override
    public int addUser(User user) {
        return ud.addUser(user);
    }

    @Override
    public int updateUser(User user) {
        return ud.updateUser(user);
    }

    @Override
    public int deleteUser(int uid) {
        return ud.deleteUser(uid);
    }

    @Override
    public User getUser(int uid) {
        return ud.getUser(uid);
    }

    @Override
    public List<User> getUserAll() {
        return ud.getUserAll();
    }

    @Override
    public User login(String username, String password) {
        return ud.login(username,password);
    }

    @Override
    public User getUserByName(String username) {
        return ud.getUserByName(username);
    }

    @Override
    public int getUsercount() {
        return ud.getUsercount();
    }

    @Override
    public List<User> getUserFy(int pagenow) {
        return ud.getUserFy(pagenow);
    }
}
