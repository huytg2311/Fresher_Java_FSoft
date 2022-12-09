package com.example.pa101.controller;

import com.example.pa101.model.Content;
import com.example.pa101.service.IContentService;
import com.example.pa101.service.impl.ContentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "ContentServlet", value = "/content")
public class ContentServlet extends HttpServlet {
    IContentService iContentService = new ContentService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }

        switch (action) {
            case "list":
                showListContent(request, response);
                break;
            case "create":
                createContentForm(request, response);
                break;
            case "search":
                searchById(request, response);
                break;
            default:
                break;
        }
    }

    private void searchById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchValue = request.getParameter("searchValue");

        Content content = iContentService.searchByTitle(searchValue);
        request.setAttribute("listContent", content);
        request.getRequestDispatcher("views/content/list-table.jsp").forward(request, response);
    }

    private void createContentForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("views/content/add.jsp").forward(request, response);
    }

    private void showListContent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Content> list = iContentService.getAllContent();


        request.setAttribute("listContent", list);
        request.getRequestDispatcher("views/content/list.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                createContent(request, response);
                break;
            default:
                break;
        }


    }

    private void createContent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String brief = request.getParameter("brief");
        String content = request.getParameter("content");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Content c = new Content(title, brief, content, timestamp);

        iContentService.createContent(c);
        response.sendRedirect("/content?action=list");
    }

}
