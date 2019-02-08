package cn.itcase.lynx.dao;

import cn.itcase.lynx.daomain.Product;

import java.util.List;

/**
 * ClassName:Lynx
 * Description:
 *
 * @Date:2019/1/22 23:55
 * @Author:chinabobcat2008@gmail.com
 */
public interface ProductDao {
    List<Product> findNews() throws  Exception;

    List<Product> findHots()throws  Exception;

    Product findProductService(String pid)throws  Exception;

    int findTotalRecords(String cid)throws  Exception;

    List findProductsByCidWithPage(String cid, int startIndex, int pageSize)throws  Exception;

    Product findProductByPid(String pid)throws  Exception;

    List<Product> findAllProductWithPage(int startIndex, int pageSize)throws  Exception;

    int findTotalRecords()throws  Exception;

    int findTotalisflag()throws  Exception;

    List findProductisflagWithPage(int startIndex, int pageSize)throws  Exception;

    void saveProduct(Product product)throws  Exception;
}
