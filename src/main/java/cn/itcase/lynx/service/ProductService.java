package cn.itcase.lynx.service;

import cn.itcase.lynx.daomain.Product;
import cn.itcase.lynx.utils.PageModel;

import java.util.List;

/**
 * ClassName:Lynx
 * Description:
 *
 * @Date:2019/1/22 23:46
 * @Author:chinabobcat2008@gmail.com
 */
public interface ProductService {
    List<Product> findNews() throws Exception;

    List<Product> findHots() throws Exception;

    Product findProductService(String pid)throws Exception;

    PageModel findProductsByCidWithPage(String cid, int curNem)throws Exception;


    Product findProductByPid(String pid) throws Exception;

    PageModel findAllProductWithPage(int curNum)throws Exception;

    PageModel findProductisflagWithPage(int curNum)throws Exception;

    void saveProduct(Product product)throws Exception;
}
