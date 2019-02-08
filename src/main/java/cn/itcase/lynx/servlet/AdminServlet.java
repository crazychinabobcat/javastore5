package cn.itcase.lynx.servlet;

import cn.itcase.lynx.base.BaseServlet;
import cn.itcase.lynx.daomain.Category;
import cn.itcase.lynx.service.CategoryService;
import cn.itcase.lynx.serviceimpl.CategoryServiceImpl;
import cn.itcase.lynx.utils.UUIDUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminServlet",urlPatterns = "/AdminServlet")
public class AdminServlet extends BaseServlet {

    public String loginHome(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        return "/admin/home.jsp";
    }

    public String editHome(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        return "/admin/category/edit.jsp";
    }

    public String addHome(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        return "/admin/category/add.jsp";
    }


    public String updateProduct(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        String cname = req.getParameter("cname");
        String cid = req.getParameter("cid");
        Category category = new Category();
        category.setCname(cname);
        category.setCid(cid);
        CategoryService categoryService = new CategoryServiceImpl();
        categoryService.updateProductGory(category);
        resp.sendRedirect(req.getContextPath()+"/AdminServlet?method=findAllCats");
        return null;
    }


    public String findAllCats(HttpServletRequest req, HttpServletResponse resp) throws Exception{

        CategoryService categoryService = new CategoryServiceImpl();
        List<Category> listgory =  categoryService.findAllCats();
        req.setAttribute("allCats",listgory);
        return "/admin/category/list.jsp";

    }


    public String deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        String cid = req.getParameter("cid");
        Category category = new Category();
        category.setCid(cid);
        CategoryService categoryService = new CategoryServiceImpl();
        categoryService.deleteProductGory(category);
        resp.sendRedirect(req.getContextPath()+"/AdminServlet?method=findAllCats");
        return null;
    }


    public String addProduct(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        String cname = req.getParameter("cname");
        Category category = new Category();
        category.setCid(UUIDUtils.getId());
        category.setCname(cname);
        CategoryService categoryService = new CategoryServiceImpl();
        categoryService.saveProductGory(category);
        resp.sendRedirect(req.getContextPath()+"/AdminServlet?method=findAllCats");
        return null;
    }




}
