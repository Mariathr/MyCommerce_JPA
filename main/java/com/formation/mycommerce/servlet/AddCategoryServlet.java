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

@WebServlet(urlPatterns = "/auth/addCategory")
public class AddCategoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/addCategory.jsp");
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryDao categoryDao = DaoFactory.getCategoryDao();
        Category category = new Category();
        category.setName(req.getParameter("name"));

        Long idCategory = categoryDao.createCategory(category);
        if (idCategory != 0){
            resp.sendRedirect( req.getContextPath() + "/auth/showCategory?id="+ idCategory);
        }else{
            resp.sendRedirect( req.getContextPath() + "/auth/addCategory");
        }
    }
}
