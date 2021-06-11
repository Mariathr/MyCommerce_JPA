package com.formation.mycommerce.servlet;

import com.formation.mycommerce.dao.DaoFactory;
import com.formation.mycommerce.dao.interfaz.ProductDao;
import com.formation.mycommerce.entity.Category;
import com.formation.mycommerce.entity.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/auth/addProduct")
public class AddProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categoryList = DaoFactory.getCategoryDao().findAllCategory();
        req.setAttribute("listCategory",categoryList);

        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/auth/addProduct.jsp");
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       Product product = new Product();
       //ini ajouter information a products
        product.setName(req.getParameter("name"));
        product.setContent(req.getParameter("Content"));
        String sCategoryId =  req.getParameter("CategorySelect");
        Long lCategoryId = Long.parseLong(sCategoryId);
        product.setCategory(new Category(lCategoryId));
        //cast string to numeric
        String nprice = req.getParameter("Price");
        Float lprice =0f;
        try{
           lprice = Float.parseFloat(nprice);
        }catch (Exception e){}
        product.setPrice(lprice);
        //fin ajouter information a products

        //envoi information JPA
        ProductDao productDao = DaoFactory.getProductDao();
        Long idProduct = productDao.createProducts(product);

        if (idProduct != 0){
            resp.sendRedirect( req.getContextPath() + "/auth/showProduct?id="+ idProduct);
        }else{
            resp.sendRedirect( req.getContextPath() + "/auth/addProduct");
        }

    }


}
