package com.oldlane.servlet.dao.impl;

import com.oldlane.servlet.dao.BaseDAO;
import com.oldlane.servlet.dao.UserDAO;
import com.oldlane.servlet.entity.User;

import java.util.List;

/**
 * @author: oldlane
 * @date: 2022/11/24 17:34
 */
public class UserDAOImpl extends BaseDAO<User> implements UserDAO {

    @Override
    public User login(String username, String password) {
        List<User> users = super.executeQuery("select * from t_user where username = ? and password = ?", username, password);
        return users.get(0);
    }

    @Override
    public boolean edit(String username, String password, String nickname) {
        int i = super.executeUpdate("update t_user set password = ?,nickname = ? where username = ?", password, nickname, username);
        return i > 0;
    }
}
