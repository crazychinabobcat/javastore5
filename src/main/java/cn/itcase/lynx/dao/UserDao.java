package cn.itcase.lynx.dao;

import cn.itcase.lynx.daomain.User;

/**
 * ClassName:Lynx
 * Description:
 *
 * @Date:2019/1/21 13:57
 * @Author:chinabobcat2008@gmail.com
 */
public interface UserDao {
    boolean regUser(User user) throws  Exception;

    User findBuCode(String userCode)throws  Exception;

    void updateUserstuts(String userCode)throws  Exception;

    User login(String username, String password)throws  Exception;
}
