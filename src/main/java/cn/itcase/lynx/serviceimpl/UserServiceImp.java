package cn.itcase.lynx.serviceimpl;

import cn.itcase.lynx.dao.UserDao;
import cn.itcase.lynx.daoimpl.UserDaoImpl;
import cn.itcase.lynx.daomain.User;
import cn.itcase.lynx.service.UserService;

/**
 * ClassName:Lynx
 * Description:
 *
 * @Date:2019/1/18 23:37
 * @Author:chinabobcat2008@gmail.com
 */
public class UserServiceImp implements UserService {
    private  UserDao userDao = new UserDaoImpl();


    //用户注册
    @Override
    public boolean regUser(User user) throws Exception {
        boolean flag = userDao.regUser(user);
        if (flag) {
            return  true;
        }else {
            return false;
        }

    }


    //查找用户code
    @Override
    public User findBuCode(String userCode) throws Exception {
        User  user = userDao.findBuCode(userCode);
        return user;
    }


    //激活用户
    @Override
    public void updateUserstuts(String userCode) throws Exception {
        userDao.updateUserstuts(userCode);
    }


    //用户登录
    @Override
    public User login(String username, String password) throws Exception {
       User user =  userDao.login(username,password);
        return user;
    }


}

