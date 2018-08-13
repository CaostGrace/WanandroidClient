package cn.logcode.wanandroid.bean;

import java.util.List;

/**
 * Created by CaostGrace on 2018/8/13 14:29
 *
 * @author caost
 * @project_name: wanandroid
 * @package_name: cn.logcode.wanandroid.bean
 * @class_name: LoginBean
 * @github: https://github.com/CaostGrace
 * @简书: http://www.jianshu.com/u/b252a19d88f3
 * @content:  登录bean对象
 */
public class LoginBean {


    /**
     * collectIds : [2864]
     * email :
     * icon :
     * id : 7595
     * password : liaobing520
     * type : 0
     * username : caostgrace
     */

    public String email;                                       
    public String icon;
    public int id;
    public String password;
    public int type;
    public String username;
    public List<Integer> collectIds;

    @Override
    public String toString() {
        return "LoginBean{" +
                "email='" + email + '\'' +
                ", icon='" + icon + '\'' +
                ", id=" + id +
                ", password='" + password + '\'' +
                ", type=" + type +
                ", username='" + username + '\'' +
                ", collectIds=" + collectIds +
                '}';
    }
}
