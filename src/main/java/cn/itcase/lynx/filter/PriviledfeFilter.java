package cn.itcase.lynx.filter;

import cn.itcase.lynx.daomain.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * ClassName:Lynx
 * Description:
 *
 * @Date:2019/1/27 16:43
 * @Author:chinabobcat2008@gmail.com
 */
@WebFilter(filterName = "PriviledfeFilter",urlPatterns = {"/CartServlet","/jsp/cart.jsp"})
public class PriviledfeFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest myreq = (HttpServletRequest)req;
        User user = (User) myreq.getSession().getAttribute("loginUser");
        if (user!=null){
            chain.doFilter(req, resp);
        }else {
            myreq.setAttribute("msg","请登录后进行访问");
            myreq.getRequestDispatcher("/jsp/info.jsp").forward(req,resp);
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
