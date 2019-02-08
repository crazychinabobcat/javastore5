package cn.itcase.lynx.servlet;

import cn.itcase.lynx.base.BaseServlet;
import cn.itcase.lynx.daomain.Category;
import cn.itcase.lynx.service.CategoryService;
import cn.itcase.lynx.serviceimpl.CategoryServiceImpl;
import cn.itcase.lynx.utils.JedisUtils;
import net.sf.json.JSONArray;
import redis.clients.jedis.Jedis;

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
 * @Date:2019/1/22 22:52
 * @Author:chinabobcat2008@gmail.com
 */
@WebServlet(name = "CategoryServlet",urlPatterns = "/CategoryServlet")
public class CategoryServlet extends BaseServlet {
    //首页查询全部分类
    public String findAllacts(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        Jedis jedis = JedisUtils.getJedis();
        String jsonStr = jedis.get("allCats");
        if (jsonStr == null  || jsonStr.equals("")){
            CategoryService categoryService = new CategoryServiceImpl();
            List<Category> list = categoryService.getAllacts();
            jsonStr = JSONArray.fromObject(list).toString();
            jedis.set("allCats",jsonStr);
            resp.setContentType("appliction/json;charset=utf-8");
            resp.getWriter().print(jsonStr);
        }else {
            resp.setContentType("appliction/json;charset=utf-8");
            resp.getWriter().print(jsonStr);
        }
        JedisUtils.closeJedis(jedis);
        return null;
    }

}
