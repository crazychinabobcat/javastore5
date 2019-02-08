package cn.itcase.lynx.daoimpl;

import cn.itcase.lynx.dao.CategoryDao;
import cn.itcase.lynx.daomain.Category;
import cn.itcase.lynx.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.util.List;

/**
 * ClassName:Lynx
 * Description:
 *
 * @Date:2019/1/22 23:15
 * @Author:chinabobcat2008@gmail.com
 */
public class CategoryDaoImpl implements CategoryDao {
    private  QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());

    //获取全部分类
    @Override
    public List<Category> getAllacts() throws Exception {
        String sql = "select * from category";

        return queryRunner.query(sql, new BeanListHandler<Category>(Category.class));

    }

    @Override
    public List<Category> findAllCats() throws Exception {
        String sql = "select * from category";
        return queryRunner.query(sql, new BeanListHandler<Category>(Category.class));
    }

    @Override
    public void saveProductGory(Category category) throws Exception {
       String sql = "insert into  category values(?,?)";
       Object [] parm = {category.getCid(),category.getCname()};
       queryRunner.update(sql,parm);

    }

    @Override
    public void updateProductGory(Category category) throws Exception {
        String sql = "UPDATE category SET cname= ? WHERE cid= ?";
        Object[] parm = {category.getCname(),category.getCid()};
        QueryRunner queryRunners = new QueryRunner(JDBCUtils.getDataSource());
         queryRunners.update(sql,parm);
    }

    @Override
    public void deleteProductGory(Category category) throws Exception {
        String sql = "delete from category where cid = ?";
        Object[] parm={category.getCid()};
        queryRunner.update(sql,parm);
    }
}
