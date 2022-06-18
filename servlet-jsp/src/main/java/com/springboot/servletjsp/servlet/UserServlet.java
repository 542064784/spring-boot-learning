package com.springboot.servletjsp.servlet;

import com.springboot.servletjsp.dto.User;
import com.springboot.servletjsp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Chen qi hui
 * @date 2022/06/18
 */
@WebServlet(name = "UserServlet", urlPatterns = "/user.action")
public class UserServlet extends HttpServlet {

    @Autowired
    private UserService userService;

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        String filter = req.getParameter("filter");
        List<User> users = userService.getUser();
        if (!StringUtils.isEmpty(filter)) {
            String name = req.getParameter("name");
            users = users.stream().filter(user -> user.getName().equals(name)).collect(Collectors.toList());
        }
        req.setAttribute("users", users);
        req.getRequestDispatcher("/WEB-INF/jsp/user.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Integer age = Integer.valueOf(req.getParameter("age"));
        String sex = req.getParameter("sex");
        User user = new User(name, age, sex);
        userService.addUser(user);
        doGet(req, resp);
    }
}
