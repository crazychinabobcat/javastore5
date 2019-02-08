package cn.itcase.lynx.daomain;

/**
 * ClassName:Lynx
 * Description:
 *
 * @Date:2019/1/28 21:49
 * @Author:chinabobcat2008@gmail.com
 */
public class OrderItem {

    private String itemid;
    private int quantity;
    private double total;

    private Product product;
    private Order Order;


    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public cn.itcase.lynx.daomain.Order getOrder() {
        return Order;
    }

    public void setOrder(cn.itcase.lynx.daomain.Order order) {
        Order = order;
    }
}
