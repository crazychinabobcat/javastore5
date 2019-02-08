package cn.itcase.lynx.daoimpl;

import cn.itcase.lynx.dao.ProductDao;
import cn.itcase.lynx.daomain.Product;
import cn.itcase.lynx.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.util.List;

/**
 * ClassName:Lynx
 * Description:
 *
 * @Date:2019/1/22 23:55
 * @Author:chinabobcat2008@gmail.com
 */
public class ProductDaoImpl implements ProductDao {


    private  QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
    //查找最新商品
    @Override
    public List<Product> findNews() throws Exception {
        String sql = "select * from product where  pflag =0 and is_hot = 1 order by pdate desc limit 0,9";
        return  queryRunner.query(sql, new BeanListHandler<Product>(Product.class));

    }

    //查找最热商品
    @Override
    public List<Product> findHots() throws Exception {
        String sql = "select * from product where pflag = 0 order by pdate desc limit 0,9";
        return queryRunner.query(sql, new BeanListHandler<Product>(Product.class));

    }


    //根据商品id分类查找商品
    @Override
    public Product findProductService(String pid) throws Exception {
        String sql = "select * from product where pid = ?";
        return queryRunner.query(sql, new BeanHandler<Product>(Product.class),pid);
    }

    @Override
    public int findTotalRecords(String cid) throws Exception {
        String sql = "select count(*) from product where cid = ?";
        Long num = (Long) queryRunner.query(sql,new ScalarHandler(),cid);
        return num.intValue();
    }

    @Override
    public List findProductsByCidWithPage(String cid, int startIndex, int pageSize) throws Exception {
        String sql = "select * from product where cid = ?  limit ? ,?";
        return queryRunner.query(sql, new BeanListHandler<Product>(Product.class),cid,startIndex,pageSize);
    }

    @Override
    public Product findProductByPid(String pid) throws Exception {
        String sql = "select * from product where pid = ?";
        return queryRunner.query(sql,new BeanHandler<Product>(Product.class),pid);

    }

    @Override
    public List<Product> findAllProductWithPage(int startIndex, int pageSize) throws Exception {
        String sql = "select * from product order by pdate desc limit ? ,?";
        return queryRunner.query(sql,new BeanListHandler<Product>(Product.class),startIndex,pageSize);
    }

    @Override
    public int findTotalRecords() throws Exception {
        String sql = "select count(*) from product";
        Long num = (Long) queryRunner.query(sql , new ScalarHandler());
        return num.intValue();
    }

    @Override
    public int findTotalisflag() throws Exception {
        String sql = "select count(*) from product";
        Long num = (Long)queryRunner.query(sql,new ScalarHandler());
        return num.intValue();
    }

    @Override
    public List findProductisflagWithPage(int startIndex, int pageSize) throws Exception {
        String sql ="select * from product where pflag =1  limit ? ,?";
        return queryRunner.query(sql,new BeanListHandler<Product>(Product.class),startIndex,pageSize);
    }

    @Override
    public void saveProduct(Product product) throws Exception {
        String sql= "insert into product values(?,?,?,?,?,?,?,?,?,?)";
        Object[] params = {product.getPid(),product.getPname(),product.getMarket_price(),product.getShop_price(),product.getPimage(),product.getPadte(),product.getIs_hot(),product.getPflag(),product.getPdesc(),product.getCid()};
        queryRunner.update(sql,params);
    }
}
