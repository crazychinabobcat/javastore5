package cn.itcase.lynx.serviceimpl;

import cn.itcase.lynx.dao.OrderDao;
import cn.itcase.lynx.daoimpl.OrderDaoImpl;
import cn.itcase.lynx.daomain.Order;
import cn.itcase.lynx.daomain.OrderItem;
import cn.itcase.lynx.daomain.User;
import cn.itcase.lynx.service.OrderService;
import cn.itcase.lynx.utils.JDBCUtils;
import cn.itcase.lynx.utils.PageModel;

import java.sql.Connection;
import java.util.List;

/**
 * ClassName:Lynx
 * Description:
 *
 * @Date:2019/1/28 22:05
 * @Author:chinabobcat2008@gmail.com
 */
public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao = new OrderDaoImpl();

    //开启事务
    @Override
    public void saveOrder(Order order) throws Exception {
        Connection conn = null;
        try {


        conn = JDBCUtils.getConnection();
        conn.setAutoCommit(false);
        orderDao.saveOrder(conn,order);

        for (OrderItem item:order.getList()){
            orderDao.saveOderItem(conn,item);
        }
        conn.commit();
        }catch (Exception e){
            conn.rollback();
        }finally {
            if (conn !=null){
                conn.close();
                conn = null;
            }
        }
    }

    @Override
    public Order findOrderByOid(String oid) throws Exception {
        return orderDao.findOrderByOid(oid);
    }

    @Override
    public void updateOrder(Order order) throws Exception {
        orderDao.updateOrder(order);
    }

    @Override
    public PageModel findMyOrderWithPage(User user, int curNum) throws Exception {
        int totalRecords = orderDao.getTotalRecords(user);
        PageModel pm = new PageModel(curNum,totalRecords,3);
        List list = orderDao.findMyOrdersWithPage(user,pm.getStartIndex(),pm.getPageSize());
        pm.setList(list);
        pm.setUrl("OrderServlet?method=findMyOrdersWithPage");
        return pm;
    }

    @Override
    public List<Order> findAllOrders() throws Exception {
        return orderDao.findAllOrders();
    }

    @Override
    public List<Order> findAllOrders(String state) throws Exception {
        return orderDao.findAllOrders(state);
    }
}
