package cn.itcase.lynx.serviceimpl;

import cn.itcase.lynx.dao.CategoryDao;
import cn.itcase.lynx.daoimpl.CategoryDaoImpl;
import cn.itcase.lynx.daomain.Category;
import cn.itcase.lynx.service.CategoryService;
import cn.itcase.lynx.utils.JedisUtils;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * ClassName:Lynx
 * Description:
 *
 * @Date:2019/1/22 23:09
 * @Author:chinabobcat2008@gmail.com
 */
public class CategoryServiceImpl implements CategoryService {

    private CategoryDao categoryDao = new CategoryDaoImpl();
    //获取全部分类
    @Override
    public List<Category> getAllacts() throws Exception {

        return categoryDao.getAllacts();
    }

    @Override
    public List<Category> findAllCats() throws Exception {

        return categoryDao.findAllCats();
    }

    @Override
    public void saveProductGory(Category category) throws Exception {
        categoryDao.saveProductGory(category);
        Jedis jedis = JedisUtils.getJedis();
        jedis.del("allCats");
        JedisUtils.closeJedis(jedis);
    }

    @Override
    public void updateProductGory(Category category) throws Exception {
        categoryDao.updateProductGory(category);
        Jedis jedis = JedisUtils.getJedis();
        jedis.del("allCats");
        JedisUtils.closeJedis(jedis);
    }

    @Override
    public void deleteProductGory(Category category) throws Exception {
        categoryDao.deleteProductGory(category);
        Jedis jedis = JedisUtils.getJedis();
        jedis.del("allCats");
        JedisUtils.closeJedis(jedis);
    }
}
