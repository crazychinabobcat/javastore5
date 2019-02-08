package cn.itcase.lynx.servlet;

import cn.itcase.lynx.base.BaseServlet;
import cn.itcase.lynx.daomain.Product;
import cn.itcase.lynx.service.ProductService;
import cn.itcase.lynx.serviceimpl.ProductServiceImpl;
import cn.itcase.lynx.utils.PageModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName:Lynx
 * Description:
 *
 * @Date:2019/1/24 21:27
 * @Author:chinabobcat2008@gmail.com
 */
@WebServlet(name = "ProductServlet",urlPatterns = "/ProductServlet")
public class ProductServlet extends BaseServlet {

    //根据商品分类ID查找相关商品
    public String findProductByPid(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        String  pid = req.getParameter("pid");
        ProductService  productService = new ProductServiceImpl();
        Product product = productService.findProductService(pid);
        req.setAttribute("product",product);
        return "jsp/product_info.jsp";
    }


    public String findProductsByCidwithPage(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        String cid = req.getParameter("cid");
        int curNem = Integer.parseInt(req.getParameter("num"));
        ProductService productService = new  ProductServiceImpl();
        PageModel pm = productService.findProductsByCidWithPage(cid,curNem);
        req.setAttribute("page",pm);
        return "/jsp/product_list.jsp";
    }
}
