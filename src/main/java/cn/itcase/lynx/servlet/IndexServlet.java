package cn.itcase.lynx.servlet;

import cn.itcase.lynx.base.BaseServlet;
import cn.itcase.lynx.daomain.Product;
import cn.itcase.lynx.service.ProductService;
import cn.itcase.lynx.serviceimpl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * ClassName:Lynx
 * Description:
 *
 * @Date:2019/1/17 23:09
 * @Author:chinabobcat2008@gmail.com
 */
@WebServlet(name = "IndexServlet",urlPatterns = "/IndexServlet")
public class IndexServlet extends BaseServlet {

    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception{

        ProductService productService =new ProductServiceImpl();
        List<Product> listNews = productService.findNews();
        List<Product> listHots = productService.findHots();
        req.setAttribute("news",listNews);
        req.setAttribute("hots",listHots);
        return "/jsp/index.jsp";
    }


}
