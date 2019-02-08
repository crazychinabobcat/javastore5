package cn.itcase.lynx.service;

import cn.itcase.lynx.daomain.Order;
import cn.itcase.lynx.daomain.User;
import cn.itcase.lynx.utils.PageModel;

import java.util.List;

/**
 * ClassName:Lynx
 * Description:
 *
 * @Date:2019/1/28 22:05
 * @Author:chinabobcat2008@gmail.com
 */
public interface OrderService {
    void saveOrder(Order order) throws  Exception;

    Order findOrderByOid(String oid)throws  Exception;

    void updateOrder(Order order)throws  Exception;

    PageModel findMyOrderWithPage(User user, int curNum)throws  Exception;

    List<Order> findAllOrders()throws  Exception;

    List<Order> findAllOrders(String state)throws  Exception;
}
