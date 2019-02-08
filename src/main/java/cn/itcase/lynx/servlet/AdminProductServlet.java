package cn.itcase.lynx.servlet;

import cn.itcase.lynx.base.BaseServlet;
import cn.itcase.lynx.daomain.Category;
import cn.itcase.lynx.daomain.Product;
import cn.itcase.lynx.service.CategoryService;
import cn.itcase.lynx.service.ProductService;
import cn.itcase.lynx.serviceimpl.CategoryServiceImpl;
import cn.itcase.lynx.serviceimpl.ProductServiceImpl;
import cn.itcase.lynx.utils.PageModel;
import cn.itcase.lynx.utils.UUIDUtils;
import cn.itcase.lynx.utils.UploadUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "AdminProductServlet",urlPatterns = "/AdminProductServlet")
public class AdminProductServlet extends BaseServlet {

    //查找全部后台商品
    public String findAllProductWithPage(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        int curNum = Integer.parseInt(req.getParameter("num"));
        ProductService productService = new ProductServiceImpl();
        PageModel pageModel = productService.findAllProductWithPage(curNum);
        req.setAttribute("page",pageModel);
       // req.getRequestDispatcher().forward(req,resp);
        return "admin/product/list.jsp";
    }

    public String findProuct(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        String pid = req.getParameter("pid");
        ProductService productService = new ProductServiceImpl();
        Product product = productService.findProductByPid(pid);
        req.setAttribute("pud",product);
        return "admin/product/edit.jsp";
    }

    //跳转到上传页面
    public String addProductUI(HttpServletRequest req, HttpServletResponse resp) throws Exception{

        CategoryService categoryService = new CategoryServiceImpl();
        List<Category> list = categoryService.findAllCats();
        req.setAttribute("allCats",list);
        return "/admin/product/add.jsp";

    }

    public String adminAddProduct(HttpServletRequest req, HttpServletResponse resp) throws Exception{

        Map<String,String> map = new HashMap<String, String>();
        Product product = new Product();
        try {


        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(diskFileItemFactory);
        List<FileItem> list = upload.parseRequest(req);
        for (FileItem fileItem: list){
            if (fileItem.isFormField()){
                map.put(fileItem.getFieldName(),fileItem.getString("utf-8"));
            }else {
                String  oldFileName = fileItem.getName();
                String newFileName = UploadUtils.getUUIDName(oldFileName);

                InputStream is = fileItem.getInputStream();
                String realPath = getServletContext().getRealPath("/products/3/");
                String dir = UploadUtils.getDir(newFileName);
                String path = realPath+dir;
                File newDir = new File(path);
                if (!newDir.exists()){
                    newDir.mkdirs();
                }
                File finalFile = new File(newDir,newFileName);
                if (!finalFile.exists()){
                    finalFile.createNewFile();
                }
                OutputStream os = new FileOutputStream(finalFile);
                IOUtils.copy(is,os);
                IOUtils.closeQuietly(is);
                IOUtils.closeQuietly(os);

                map.put("pimage","/products/3/"+dir+"/"+newFileName);
            }

        }
        BeanUtils.populate(product,map);
        product.setPid(UUIDUtils.getId());
        product.setPadte(new Date());
        product.setPflag(0);

        ProductService productService = new ProductServiceImpl();
        productService.saveProduct(product);
        resp.sendRedirect(req.getContextPath()+"/AdminProductServlet?method=findAllProductWithPage&num=1");

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }




    //已经下架的商品
    public String findAllProductXiaJia(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        int curNum = Integer.parseInt(req.getParameter("num"));
        ProductService productService = new ProductServiceImpl();
        PageModel pageModel = productService.findProductisflagWithPage(curNum);
        req.setAttribute("page",pageModel);
        return "admin/product/pushDown_list.jsp";
    }



}
