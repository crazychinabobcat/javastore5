package cn.itcase.lynx.servlet;

import cn.itcase.lynx.base.BaseServlet;
import cn.itcase.lynx.daomain.User;
import cn.itcase.lynx.service.UserService;
import cn.itcase.lynx.serviceimpl.UserServiceImp;
import cn.itcase.lynx.utils.MailUtils;
import cn.itcase.lynx.utils.MyBeanUtils;
import cn.itcase.lynx.utils.UUIDUtils;
import sun.nio.cs.US_ASCII;


import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * ClassName:Lynx
 * Description:
 *
 * @Date:2019/1/17 23:12
 * @Author:chinabobcat2008@gmail.com
 */
@WebServlet(name = "UserServlet",urlPatterns = "/UserServlet")
public class UserServlet extends BaseServlet {

    //用户注册注册
    public String regisUI(HttpServletRequest req, HttpServletResponse resp) throws Exception{

        return "/jsp/register.jsp";
    }

    public String loginUI(HttpServletRequest req, HttpServletResponse resp) throws Exception{

        return "/jsp/login.jsp";
    }


    //用户注册
    public String registUsers(HttpServletRequest request, HttpServletResponse response) throws Exception{
        request.setCharacterEncoding("UTf-8");
        Map<String,String[]> map = request.getParameterMap();
        User user = new User();
        MyBeanUtils.populate(user,map);
        user.setUid(UUIDUtils.getId());
        user.setCode(UUIDUtils.getCode());
        user.setState(0);
        UserService userService = new UserServiceImp();
        boolean flag = userService.regUser(user);
        if (flag) {
        //如果是true通知邮箱激活
            String content="<a href ='http://127.0.0.1:8080/store5/UserServlet?method=activeUser&code="+user.getCode() +"'>【山猫旅游网】</a>";
            MailUtils.sendMail(user.getEmail(),content,"账号激活");
            request.setAttribute("msg","用户注册成功，请去邮箱激活账号");
            return "/jsp/info.jsp";
        }else {
            request.setAttribute("msg","用户注册失败，请重新注册");
        }
        return "/jsp/info.jsp";
    }


    //用户激活
    public String activeUser(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String userCode = req.getParameter("code");
        if (userCode != null && userCode != "") {
            UserService userService = new UserServiceImp();
            User user = userService.findBuCode(userCode);
            if (user != null) {
                userService.updateUserstuts(userCode);
                req.setAttribute("msg", "激活成功请登录");
                return "/jsp/info.jsp";
            }

        } else {
            req.setAttribute("msg", "激活异常请联系管理员");
            return "/jsp/info.jsp";
        }

        return null;

    }
    //用户登录
    public String userLogin(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String server_code = (String ) req.getSession().getAttribute("CHECKCODE_SERVER");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String code = req.getParameter("checkcode");
        req.removeAttribute("CHECKCODE_SERVER");
        UserService userService = new UserServiceImp();

        if (code != null && code !=""){
            if (code.equalsIgnoreCase(server_code)){
                //调用用户登录
                User user = userService.login(username,password);
                if (user != null){
                    req.getSession().setAttribute("loginUser",user);
                    resp.sendRedirect("/store5/index.jsp");
                }else{
                    req.setAttribute("msg","用户名密码错误");
                    return "/jsp/login.jsp";
                }
            }else {
                req.setAttribute("msg","验证码错误，请重新输入");
                return "/jsp/login.jsp";
            }


        }else {
            req.setAttribute("msg","验证码错误，请重新输入");
            return "/jsp/login.jsp";
        }

        return null;

    }


    //用户退出
    public String loginOut(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        req.getSession().invalidate();
        resp.sendRedirect("index.jsp");
        return  null;
    }


}
