package cn.itcase.lynx.dao;

import cn.itcase.lynx.daomain.Order;
import cn.itcase.lynx.daomain.OrderItem;
import cn.itcase.lynx.daomain.User;

import java.sql.Connection;
import java.util.List;

/**
 * ClassName:Lynx
 * Description:
 *
 * @Date:2019/1/28 22:06
 * @Author:chinabobcat2008@gmail.com
 */
public interface OrderDao {
    void saveOrder(Connection conn, Order order) throws Exception;

    void saveOderItem(Connection conn, OrderItem item)throws Exception;

    Order findOrderByOid(String oid)throws Exception;

    void updateOrder(Order order)throws Exception;

    int getTotalRecords(User user)throws Exception;

    List findMyOrdersWithPage(User user, int startIndex, int pageSize)throws Exception;

    List<Order> findAllOrders()throws Exception;

    List<Order> findAllOrders(String state)throws Exception;
}
