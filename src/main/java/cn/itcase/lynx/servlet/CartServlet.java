package cn.itcase.lynx.servlet;

import cn.itcase.lynx.base.BaseServlet;
import cn.itcase.lynx.daomain.Cart;
import cn.itcase.lynx.daomain.CartItem;
import cn.itcase.lynx.daomain.Product;
import cn.itcase.lynx.service.ProductService;
import cn.itcase.lynx.serviceimpl.ProductServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ClassName:Lynx
 * Description:
 *
 * @Date:2019/1/24 23:03
 * @Author:chinabobcat2008@gmail.com
 */
@WebServlet(name = "CartServlet",urlPatterns = "/CartServlet")
public class CartServlet extends BaseServlet {

    public String addCartItemToCart(HttpServletRequest req, HttpServletResponse resp) throws Exception{

        Cart cart = (Cart) req.getSession().getAttribute("cart");

        if (cart == null){
            cart = new Cart();
            req.getSession().setAttribute("cart",cart);
        }

        String pid = req.getParameter("pid");
        int num = Integer.parseInt(req.getParameter("quantity"));

        ProductService productService = new ProductServiceImpl();
        Product product = productService.findProductByPid(pid);

        CartItem cartItem = new CartItem();
        cartItem.setNum(num);
        cartItem.setProduct(product);

        cart.addCartItemToCart(cartItem);
        resp.sendRedirect(req.getContextPath()+"/jsp/cart.jsp");
        System.out.println(req.getContextPath());

        return null;
    }


    public String removeCartItem(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        String pid = req.getParameter("id");
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        cart.removeCartItem(pid);
        resp.sendRedirect("/store5/jsp/cart.jsp");
        return null;
    }


    public String clearCar(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        cart.clearCart();
        resp.sendRedirect("/store5/jsp/cart.jsp");
        return null;
    }







}
