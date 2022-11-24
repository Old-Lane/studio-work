package com.oldlane.servlet.dao;

import com.oldlane.servlet.entity.User;

/**
 * @author: oldlane
 * @date: 2022/11/24 17:32
 */
public interface UserDAO {
    User login(String username, String password);

    boolean edit(String username, String password, String nickname);
}
