package com.oldlane.servlet;

import com.oldlane.servlet.dao.UserDAO;
import com.oldlane.servlet.dao.impl.UserDAOImpl;
import com.oldlane.servlet.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author: oldlane
 * @date: 2022/11/24 19:15
 */
@WebServlet("/edit")
public class Edit extends ViewBaseServlet{

    private UserDAO userDAO = new UserDAOImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        HttpSession session = req.getSession();

        String username = req.getParameter("username");
        System.out.println("username = " + username);
        String password = req.getParameter("password");
        System.out.println("password = " + password);
        String nickname = req.getParameter("nickname");
        System.out.println("nickname = " + nickname);


        boolean isSuccess = userDAO.edit(username, password, nickname);

        if (isSuccess) {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setNickname(nickname);
            session.setAttribute("user", user);
            super.processTemplate("personal", req, resp);
        }
    }
}
