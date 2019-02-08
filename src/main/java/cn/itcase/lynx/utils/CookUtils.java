package cn.itcase.lynx.utils;

import javax.servlet.http.Cookie;

/**
 * ClassName:Lynx
 * Description:
 *
 * @Date:2019/1/17 22:26
 * @Author:chinabobcat2008@gmail.com
 */
public class CookUtils {
    /**
     * 通过名称在cookie数组获取指定的cookie
     * @param name cookie名称
     * @param cookies  cookie数组
     * @return
     */
    public static Cookie getCookieByName(String name, Cookie[] cookies) {
        if(cookies!=null){
            for (Cookie c : cookies) {
                //通过名称获取
                if(name.equals(c.getName())){
                    //返回
                    return c;
                }
            }
        }
        return null;
    }
}
