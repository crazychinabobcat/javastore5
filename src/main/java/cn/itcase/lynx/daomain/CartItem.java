package cn.itcase.lynx.daomain;

import cn.itcase.lynx.daomain.Product;

/**
 * ClassName:Lynx
 * Description:
 *
 * @Date:2019/1/26 16:09
 * @Author:chinabobcat2008@gmail.com
 */
public class CartItem {
    private Product product;
    private int num;
    private double subTotal;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getSubTotal() {
        return product.getShop_price()*num;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
}
