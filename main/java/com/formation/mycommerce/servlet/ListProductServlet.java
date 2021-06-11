package com.formation.mycommerce.servlet;



import com.formation.mycommerce.dao.DaoFactory;
import com.formation.mycommerce.entity.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/auth/listProduct")
public class ListProductServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Product> nlistproduct = new ArrayList();
        nlistproduct =  DaoFactory.getProductDao().findAllProducts();
        req.setAttribute("listproduct",nlistproduct);
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/listProduct.jsp");
        rd.forward(req,resp);

    }
}
