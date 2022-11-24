package com.oldlane.servlet;

import com.oldlane.servlet.dao.UserDAO;
import com.oldlane.servlet.dao.impl.UserDAOImpl;
import com.oldlane.servlet.entity.User;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author: oldlane
 * @date: 2022/11/24 16:51
 */
@WebServlet("/login")
public class Login extends ViewBaseServlet {

    private UserDAO userDAO = new UserDAOImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        HttpSession session = req.getSession();

        String username = req.getParameter("username");
        System.out.println("username = " + username);
        String password = req.getParameter("password");
        System.out.println("password = " + password);
        User user = userDAO.login(username, password);
        System.out.println("user = " + user);
        if (user != null) {
//            resp.getWriter().write("登录成功");
            session.setAttribute("user", user);
            super.processTemplate("personal", req, resp);
        } else {
            resp.getWriter().write("用户名或密码错误");
        }
    }
}
