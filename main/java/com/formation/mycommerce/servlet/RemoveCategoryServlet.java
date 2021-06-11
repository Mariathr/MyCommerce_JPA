package com.formation.mycommerce.servlet;

import com.formation.mycommerce.dao.DaoFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/auth/removeCategory")
public class RemoveCategoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        DaoFactory.getCategoryDao().removeCategory(id);
        RequestDispatcher rs = req.getRequestDispatcher("/auth/listCategory");
        rs.forward(req,resp);
    }
}
