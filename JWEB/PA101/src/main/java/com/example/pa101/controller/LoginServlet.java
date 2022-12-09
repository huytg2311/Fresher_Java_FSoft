package com.example.pa101.controller;

import com.example.pa101.service.ILoginService;
import com.example.pa101.service.impl.LoginService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    ILoginService iLoginService = new LoginService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("views/login/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (iLoginService.loginAction(username, password)) {
            HttpSession session = request.getSession();
            session.setAttribute("usernameSS", username);
            response.sendRedirect("/content?action=list");
        } else {
            request.setAttribute("message","Username or password wrong !");
            request.getRequestDispatcher("views/login/login.jsp").forward(request, response);
        }
    }
}
