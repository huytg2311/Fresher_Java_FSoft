package com.example.pa101.controller;

import com.example.pa101.model.Member;
import com.example.pa101.service.IMemberService;
import com.example.pa101.service.impl.MemberService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MemeberServlet", value = "/member")
public class MemeberServlet extends HttpServlet {

    IMemberService iMemberService = new MemberService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }

        switch (action) {
            case "showEditForm":
                showEditForm(request, response);
                break;
            case "createFormMember":
                createFormMember(request, response);
                break;
        }


    }

    private void createFormMember(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("views/register/register.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        Member member = iMemberService.getMemberByUsername(username);

        request.setAttribute("firstname", member.getFirstName());
        request.setAttribute("lastname", member.getLastName());
        request.setAttribute("email", member.getEmail());
        request.setAttribute("phone", member.getPhone());
        request.setAttribute("description", member.getDescription());
        request.setAttribute("usernameForm", member.getUsername());
        request.getRequestDispatcher("views/member/edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }

        switch (action) {
            case "update":
                updateMember(request, response);
                break;
            case "create":
                createMember(request, response);
                break;
            default:
                break;
        }

    }

    private void createMember(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Member member = new Member(username, email, password);
        iMemberService.addMember(member);
        request.setAttribute("message", "Register Successfully !");
        request.getRequestDispatcher("views/register/register.jsp").forward(request, response);
    }

    private void updateMember(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String description = request.getParameter("description");
        String username = request.getParameter("usernameForm");

        Member member = new Member(firstname, lastname, email, phone, description, username);
        iMemberService.updateMember(member);
        request.setAttribute("message", "Update Successfully !");
        request.getRequestDispatcher("/views/member/edit.jsp").forward(request, response);
    }


}
