package com.formation.mycommerce.servlet;

import com.formation.mycommerce.dao.DaoFactory;
import com.formation.mycommerce.dao.interfaz.CategoryDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/auth/showCategory")
public class ShowCategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // get parameter
        String pId = req.getParameter("id");
        Long lId = 0l;
        try{
            lId = Long.parseLong(pId);
        }catch (Exception e){}

        //appeler jPA
        CategoryDao category = DaoFactory.getCategoryDao();
        req.setAttribute("category",category.findCategoryById(lId));

        //envoi HTML, JSP
        RequestDispatcher rs = req.getRequestDispatcher("/WEB-INF/showCategory.jsp");
        rs.forward(req,resp);
    }
}
