package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Password;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UpdateUserServlet", value = "/update")
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }

        User user = (User) request.getSession().getAttribute("user");
        request.setAttribute("userUpdate",user);
        request.getRequestDispatcher("/WEB-INF/UpdateUser.jsp").forward(request, response);


    }




    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
       User currentUser = (User) request.getSession().getAttribute("user");
            long id = currentUser.getId();

            String name = request.getParameter("username");
            String email = request.getParameter("email");
            String password = request.getParameter("password");


            User user = new User(id,name, email, Password.hash(password));
            request.getSession().setAttribute("user",user);

        DaoFactory.getUsersDao().update(user);
        response.sendRedirect("/profile");



    }

}
