package cn.itcase.lynx.utils;

import java.util.UUID;

/**
 * ClassName:Lynx
 * Description:
 *
 * @Date:2019/1/17 22:32
 * @Author:chinabobcat2008@gmail.com
 */
public class UUIDUtils {

    /**
     * 随机生成id
     * @return
     */
    public static String getId(){
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }


    public static String getUUID64(){
        return getId()+getId();
    }

    /**
     * 生成随机码
     * @return
     */
    public static String getCode(){
        return getId();
    }

    public static void main(String[] args) {
        System.out.println(getId());
    }
}
