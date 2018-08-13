package cn.logcode.wanandroid.http;

/**
 * Created by CaostGrace on 2018/8/13 10:53
 *
 * @author caost
 * @project_name: wanandroid
 * @package_name: cn.logcode.wanandroid.http
 * @class_name: HttpConstants
 * @github: https://github.com/CaostGrace
 * @简书: http://www.jianshu.com/u/b252a19d88f3
 * @content:
 */
public class HttpConstants {
    public static final String PAGE = "page";
    public static final String ID = "id";


    //################################ 一、首页相关  #######################################

    /**
     * 1.1 首页文章列表
     * 方法：GET
     * 参数：页码，拼接在连接中，从0开始。
     */
    public static final String ARTICLE = "article/list/{" + PAGE + "}/json";

    /**
     * 1.2 首页banner
     * 方法：GET
     * 参数：无
     */
    public static final String BANNER = "banner/json";


    /**
     * 1.3 常用网站
     * 方法：GET
     * 参数：无
     */
    public static final String FRIEND = "friend/json";

    /**
     * 1.4 搜索热词
     * 方法：GET
     * 参数：无
     */
    public static final String HOTKEY = "hotkey/json";


    //################################ 二、体系  #######################################

    /**
     * 2.1 体系数据
     * 方法：GET
     * 参数：无
     */
    public static final String TREE = "tree/json";


    /**
     * 2.2 知识体系下的文章
     * 方法：GET
     * 参数：
     * cid 分类的id，上述二级目录的id
     * 页码：拼接在链接上，从0开始。
     */
    public static final String TREE_ARTICLE = "article/list/{" + PAGE + "}/json?cid={" + ID + "}";


    //################################ 三、导航  #######################################

    /**
     * 3.1 导航数据
     * 方法：GET
     * 参数：无
     */
    public static final String NAVI = "navi/json";


    //################################ 四、项目  #######################################

    /**
     * 4.1 项目分类
     * 方法：GET
     * 参数：无
     */
    public static final String PROJECT = "project/tree/json";

    /**
     * 4.2 项目列表数据
     * 方法：GET
     * 参数：
     * cid 分类的id，上面项目分类接口
     * 页码：拼接在链接中，从1开始。
     */
    public static final String PROJECT_LIST_DATA = "project/list/{" + PAGE + "}/json?cid={" + ID + "}";


    //################################ 五、登录与注册  #######################################

    /**
     * 5.1 登录
     * 方法：POST
     * 参数：username，password
     */
    public static final String LOGIN = "user/login";


    /**
     * 5.2 注册
     * 方法：POST
     * 参数：username,password,repassword
     */
    public static final String REGISTER = "user/register";

}
