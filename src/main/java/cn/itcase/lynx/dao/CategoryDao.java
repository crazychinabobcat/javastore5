package cn.itcase.lynx.dao;

import cn.itcase.lynx.daomain.Category;

import java.util.List;

/**
 * ClassName:Lynx
 * Description:
 *
 * @Date:2019/1/22 23:15
 * @Author:chinabobcat2008@gmail.com
 */
public interface CategoryDao {
    List<Category> getAllacts() throws Exception;

    List<Category> findAllCats()throws Exception;

    void saveProductGory(Category category)throws Exception;

    void updateProductGory(Category category)throws Exception;

    void deleteProductGory(Category category)throws Exception;
}
