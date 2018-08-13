package cn.logcode.wanandroid.bean;

import org.litepal.crud.LitePalSupport;

/**
 * Created by CaostGrace on 2018/8/13 15:34
 *
 * @author caost
 * @project_name: wanandroid
 * @package_name: cn.logcode.wanandroid.bean
 * @class_name: CookieBean
 * @github: https://github.com/CaostGrace
 * @简书: http://www.jianshu.com/u/b252a19d88f3
 * @content:
 */
public class CookieBean extends LitePalSupport {
    public int id;
    public String name;
    public String value;
    public long expiresAt;
    public String domain;
    public String path;
    public boolean secure;
    public boolean httpOnly;

    public boolean persistent;
    public boolean hostOnly;

    @Override
    public String toString() {
        return "CookieBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", expiresAt=" + expiresAt +
                ", domain='" + domain + '\'' +
                ", path='" + path + '\'' +
                ", secure=" + secure +
                ", httpOnly=" + httpOnly +
                ", persistent=" + persistent +
                ", hostOnly=" + hostOnly +
                '}';
    }
}
