package com.formation.mycommerce.filtre;

import com.formation.mycommerce.servlet.LoginServlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = "/auth/*")
public final class AuthenticateFilter implements javax.servlet.Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {


        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;


        HttpSession session = req.getSession();

        if ( session.getAttribute("username") == null ) {

            res.sendRedirect( req.getContextPath() + "/login");
        } else {
            filterChain.doFilter( req, res );
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
