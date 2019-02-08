package cn.itcase.lynx.service;

import cn.itcase.lynx.daomain.Category;

import java.util.List;

/**
 * ClassName:Lynx
 * Description:
 *
 * @Date:2019/1/22 23:08
 * @Author:chinabobcat2008@gmail.com
 */
public interface CategoryService {
    List<Category> getAllacts() throws  Exception;

    List<Category> findAllCats()throws  Exception;

    void saveProductGory(Category category)throws  Exception;

    void updateProductGory(Category category)throws  Exception;

    void deleteProductGory(Category category)throws  Exception;
}
