package cn.itcase.lynx.servlet;

import cn.itcase.lynx.base.BaseServlet;
import cn.itcase.lynx.daomain.Order;
import cn.itcase.lynx.service.OrderService;
import cn.itcase.lynx.serviceimpl.OrderServiceImpl;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminOrderServlet",urlPatterns = "/AdminOrderServlet")
public class AdminOrderServlet extends BaseServlet {

    public String findOrders(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        String state = req.getParameter("state");
        OrderService orderService = new OrderServiceImpl();
        List<Order> list_order = null;
        if (state == null || state.equals("")){
            list_order = orderService.findAllOrders();
        }else {
            list_order = orderService.findAllOrders(state);
        }
        req.setAttribute("allOrders",list_order);
        req.getRequestDispatcher("admin/order/list.jsp").forward(req,resp);
        return null;
    }

    public String updateOrderByOid(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        String oid = req.getParameter("oid");
        OrderService orderService = new OrderServiceImpl();
        Order order = new Order();
        Order findOrder = orderService.findOrderByOid(oid);
        if (findOrder != null){
            order.setOid(oid);
            order.setState(3);
            orderService.updateOrder(order);
            req.setAttribute("msg","订单发货成功");
        }else{
            req.setAttribute("msg","没有此订单");
        }

        resp.sendRedirect("/store5/AdminOrderServlet?method=findOrders&state=3");
        return  null;
    }

    public String findOrderByOidWithAjax(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        String oid = req.getParameter("id");
        OrderService orderService = new OrderServiceImpl();
        Order order = orderService.findOrderByOid(oid);
        String jsonStr = JSONArray.fromObject(order.getList()).toString();
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().println(jsonStr);
        return null;
    }


}
