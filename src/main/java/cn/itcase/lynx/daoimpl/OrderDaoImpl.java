package cn.itcase.lynx.daoimpl;

import cn.itcase.lynx.dao.OrderDao;
import cn.itcase.lynx.daomain.Order;
import cn.itcase.lynx.daomain.OrderItem;
import cn.itcase.lynx.daomain.Product;
import cn.itcase.lynx.daomain.User;
import cn.itcase.lynx.utils.JDBCUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

/**
 * ClassName:Lynx
 * Description:
 *
 * @Date:2019/1/28 22:07
 * @Author:chinabobcat2008@gmail.com
 */
public class OrderDaoImpl implements OrderDao {

    private QueryRunner queryRunner =new QueryRunner(JDBCUtils.getDataSource());

    @Override
    public void saveOrder(Connection conn, Order order) throws Exception {
        String sql = "insert into orders values(?,?,?,?,?,?,?,?)";
        Object[] parms = {order.getOid(),order.getOrdertime(),order.getTotal(),order.getState(),order.getAddress(),order.getName(),order.getTelephone(),order.getUser().getUid()};
        queryRunner.update(conn,sql,parms);
    }

    @Override
    public void saveOderItem(Connection conn, OrderItem item) throws Exception {
        String  sql = "insert into orderitem values(?,?,?,?,?)";
        Object[] parms = {item.getItemid(),item.getQuantity(),item.getTotal(),item.getProduct().getPid(),item.getOrder().getOid()};
        queryRunner.update(conn,sql,parms);
    }

    @Override
    public Order findOrderByOid(String oid) throws Exception {
        String  sql = "select * from orders where oid =?";
        Order order = queryRunner.query(sql,new BeanHandler<Order>(Order.class),oid);
        sql = "select * from orderitem o , product p where o.pid=p.pid and o.oid = ?";
        List<Map<String,Object>> list02 = queryRunner.query(sql, new MapListHandler(),oid);
        for (Map<String,Object> map:list02){
            OrderItem orderItem = new OrderItem();
            Product product = new Product();
            DateConverter dt = new DateConverter();
            dt.setPattern("yyyy-MM-dd");
            ConvertUtils.register(dt,java.util.Date.class);

            BeanUtils.populate(orderItem,map);
            BeanUtils.populate(product,map);
            orderItem.setProduct(product);
            order.getList().add(orderItem);
        }
        return order;
    }

    @Override
    public void updateOrder(Order order) throws Exception {
        String sql = "update orders set ordertime=?,total=?,state=?,address=?,name=?,telephone=? where oid = ?";
        Object[] params = {order.getOrdertime(),order.getTotal(),order.getState(),order.getAddress(),order.getName(),order.getTelephone(),order.getOid()};
        queryRunner.update(sql,params);

    }

    @Override
    public int getTotalRecords(User user) throws Exception {
        String sql = "select count(*) from orders where uid= ?";
        Long num = (Long) queryRunner.query(sql,new ScalarHandler(),user.getUid());
        return num.intValue();
    }

    @Override
    public List findMyOrdersWithPage(User user, int startIndex, int pageSize) throws Exception {
        String sql = "select * from orders where uid = ? limit ?,?";
        List<Order> list = queryRunner.query(sql, new BeanListHandler<Order>(Order.class),user.getUid(),startIndex,pageSize);
        for (Order order:list){
            String oid = order.getOid();
            sql = "select * from orderitem o ,product p  where o.pid = p.pid and oid = ?";
            List<Map<String,Object>> list02 = queryRunner.query(sql, new MapListHandler(),oid);

            for (Map<String,Object> map:list02){
                OrderItem orderItem = new OrderItem();
                Product product = new Product();
                DateConverter dateConverter = new DateConverter();
                dateConverter.setPattern("yyy-MM-dd");
                ConvertUtils.register(dateConverter,java.util.Date.class);
                BeanUtils.populate(orderItem,map);
                BeanUtils.populate(product,map);
                orderItem.setProduct(product);
                order.getList().add(orderItem);
            }
        }
        return list;
    }

    @Override
    public List<Order> findAllOrders()throws Exception {
        String sql = "select * from orders";
        return queryRunner.query(sql, new BeanListHandler<Order>(Order.class));
    }

    @Override
    public List<Order> findAllOrders(String state)throws Exception {
        String sql = "select * from orders where state = ?";
        return queryRunner.query(sql, new BeanListHandler<Order>(Order.class),state);
    }
}
