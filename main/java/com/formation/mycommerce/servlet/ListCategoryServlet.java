package com.formation.mycommerce.servlet;

import com.formation.mycommerce.dao.DaoFactory;
import com.formation.mycommerce.dao.interfaz.CategoryDao;
import com.formation.mycommerce.entity.Category;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/auth/listCategory")
public class ListCategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categoryList = DaoFactory.getCategoryDao().findAllCategory();
        req.setAttribute("listCategory",categoryList);
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/listCategory.jsp");
        rd.forward(req,resp);
    }
}
