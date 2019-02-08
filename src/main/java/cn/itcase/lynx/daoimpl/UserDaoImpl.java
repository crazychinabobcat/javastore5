package cn.itcase.lynx.daoimpl;

import cn.itcase.lynx.dao.UserDao;
import cn.itcase.lynx.daomain.User;
import cn.itcase.lynx.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 * ClassName:Lynx
 * Description:
 *
 * @Date:2019/1/21 13:57
 * @Author:chinabobcat2008@gmail.com
 */
public class UserDaoImpl implements UserDao {

    //用户注册
    @Override
    public boolean regUser(User user) throws Exception {
        String sql= "insert into user values(?,?,?,?,?,?,?,?,?,?)";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        Object[] parms = {user.getUid(),user.getUsername(),user.getPassword(),user.getName(),user.getEmail(),user.getTelephone(),user.getBirthday(),user.getSex(),user.getState(),user.getCode()};
        queryRunner.update(sql,parms);
        return true;
    }

    //查找是否有此code
    @Override
    public User findBuCode(String userCode) throws Exception {
        String sql ="select * from user where code =?";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        User user = queryRunner.query(sql, new BeanHandler<User>(User.class),userCode);
        return user;
    }

    //更新用户状态

    @Override
    public void updateUserstuts(String userCode) throws Exception {
        String  sql = "update user set state = 1 where code = ?";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        queryRunner.update(sql,userCode);
    }

    //用户登录

    @Override
    public User login(String username, String password) throws Exception {
        String sql = "select * from user where username=? and password=? ";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        User uu = queryRunner.query(sql ,new BeanHandler<User>(User.class),username,password);
        return uu;
    }


}
