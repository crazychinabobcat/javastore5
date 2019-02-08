package cn.itcase.lynx.serviceimpl;

import cn.itcase.lynx.dao.ProductDao;
import cn.itcase.lynx.daoimpl.ProductDaoImpl;
import cn.itcase.lynx.daomain.Product;
import cn.itcase.lynx.service.ProductService;
import cn.itcase.lynx.utils.PageModel;

import java.util.List;

/**
 * ClassName:Lynx
 * Description:
 *
 * @Date:2019/1/22 23:46
 * @Author:chinabobcat2008@gmail.com
 */
public class ProductServiceImpl implements ProductService {

    private ProductDao productDao = new ProductDaoImpl();

    //查找最新商品
    @Override
    public List<Product> findNews() throws Exception {
        return productDao.findNews();
    }

    //查找最热商品
    @Override
    public List<Product> findHots() throws Exception {
        return productDao.findHots();
    }

    @Override
    public Product findProductService(String pid) throws Exception {
        return productDao.findProductService(pid);
    }


    //分页
    @Override
    public PageModel findProductsByCidWithPage(String cid, int curNem) throws Exception {
        int totalRecords = productDao.findTotalRecords(cid);
        PageModel pm = new PageModel(curNem,totalRecords,12);
        List list = productDao.findProductsByCidWithPage(cid,pm.getStartIndex(),pm.getPageSize());
        pm.setList(list);
        pm.setUrl("ProductServlet?method=findProductsByCidwithPage&cid="+cid);
        return pm;
    }

    @Override
    public Product findProductByPid(String pid) throws Exception {

        return productDao.findProductByPid(pid);

    }

    @Override
    public PageModel findAllProductWithPage(int curNum) throws Exception {
        int totalRecords = productDao.findTotalRecords();
        PageModel pm = new PageModel(curNum,totalRecords,5);
        List list = productDao.findAllProductWithPage(pm.getStartIndex(),pm.getPageSize());
        pm.setList(list);
        pm.setUrl("AdminProductServlet?method=findAllProductWithPage");
        return pm;
    }

    @Override
    public PageModel findProductisflagWithPage(int curNum) throws Exception {
        int totalRecords = productDao.findTotalisflag();
        PageModel pm = new PageModel(curNum,totalRecords,5);
        List list = productDao.findProductisflagWithPage(pm.getStartIndex(),pm.getPageSize());
        pm.setList(list);
        pm.setUrl("AdminProductServlet?method=findAllProductXiaJia");
        return pm;
    }

    @Override
    public void saveProduct(Product product) throws Exception {
        productDao.saveProduct(product);
    }
}
