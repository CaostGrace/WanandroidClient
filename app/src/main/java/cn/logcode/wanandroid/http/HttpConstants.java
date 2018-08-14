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
    public static final String TYPE = "type";


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


    //################################ 六、收藏  #######################################

    /**
     * 6.1 收藏文章列表
     * 方法：GET
     * 参数： 页码：拼接在链接中，从0开始。
     */
    public static final String COLLECT_ARTICLE_LIST = "lg/collect/list/{" + PAGE + "}/json";


    /**
     * 6.2 收藏站内文章
     * 方法：POST
     * 参数： 文章id，拼接在链接中。
     */
    public static final String COLLECT_IN_STATION = "lg/collect/{" + ID + "}/json";


    /**
     * 6.3 收藏站外文章
     * 方法：POST
     * 参数：title，author，link
     */
    public static final String COLLECT_OUT_STATION = "lg/collect/add/json";


    /**
     * 6.4.1 文章列表 取消收藏
     * 方法：POST
     * 参数：id:拼接在链接上
     */
    public static final String ARTICLES_LIST_UNCOLLECT = "lg/uncollect_originId/{" + ID + "}/json";


    /**
     * 6.4.2 我的收藏页面（该页面包含自己录入的内容） 取消收藏
     * 方法：POST
     * 参数：id:拼接在链接上
     * originId:列表页下发，无则为-1
     */
    public static final String COLLECTION_LIST_UNCOLLECT = "lg/uncollect/{" + ID + "}/json";


    /**
     * 6.5 收藏网站列表
     * 方法：GET
     * 参数：无
     */
    public static final String COLLECTION_SITE_LIST = "lg/collect/usertools/json";


    /**
     * 6.6 收藏网址
     * 方法：POST
     * 参数：name,link
     */
    public static final String COLLECTION_WEB_SITES = "lg/collect/addtool/json";


    /**
     * 6.7 编辑收藏网站
     * 方法：POST
     * 参数：id,name,link
     */
    public static final String EDIT_COLLECTION_WEBSITE = "lg/collect/updatetool/json";


    /**
     * 6.8 删除收藏网站
     * 方法：POST
     * 参数：id
     */
    public static final String DELETE_COLLECTION_WEBSITE = "lg/collect/deletetool/json";


    //################################ 七. 搜索 #######################################

    /**
     * 7.1 搜索
     * 方法：POST
     * 参数：页码：拼接在链接上，从0开始。
     * k ： 搜索关键词
     */
    public static final String QUERY = "article/query/{" + PAGE + "}/json";


    //################################ 八. TODO 工具 #######################################
//    目前Todo分为4类，主要为type区分，type取值为0，1，2，3。  分别为 只用这一个、工作、学习、生活


    /**
     * 8.1 获取TODO列表
     * 方法：POST
     * 参数：type：type取值为0，1，2，3。  分别为 只用这一个、工作、学习、生活
     */
    public static final String TODO_LIST = "lg/todo/list/{" + TYPE + "}/json";


    /**
     * 8.2 新增一条Todo
     * 方法：POST
     * 参数：title: 新增标题
     * content: 新增详情
     * date: 2018-08-01
     * type: 0
     */
    public static final String ADD_TODO = "lg/todo/add/json";


    /**
     * 8.3 更新一条Todo内容
     * 方法：POST
     * 参数：id: 拼接在链接上，为唯一标识
     * <p>
     * title: 更新标题
     * content: 新增详情
     * date: 2018-08-01
     * status: 0 // 0为未完成，1为完成
     * type: 0
     */
    public static final String UPDATE_TODO = "lg/todo/update/{" + ID + "}/json";




    /**
     * 8.4 删除一条Todo
     * 方法：POST
     * 参数：id: 拼接在链接上，为唯一标识
     */
    public static final String DELATE_TODO = "lg/todo/delete/{"+ID+"}/json";



    /**
     * 8.5 仅更新完成状态Todo
     * 方法：POST
     * 参数：id: 拼接在链接上，为唯一标识
     * status: 0或1，传1代表未完成到已完成，反之则反之。
     */
    public static final String UPDATE_COMPLETE_STATE_TODO = "lg/todo/done/{"+ID+"}/json";



    /**
     * 8.6 未完成 Todo 列表
     * 方法：POST
     * 参数：类型：类型拼接在链接上，目前支持0,1,2,3
     * 页码: 拼接在链接上，从1开始；
     */
    public static final String INCOMPLETE_LIST = "lg/todo/listnotdo/{"+TYPE+"}/json/{"+PAGE+"}";



    /**
     * 8.7 已完成 Todo 列表
     * 方法：POST
     * 参数：类型：类型拼接在链接上，目前支持0,1,2,3
     * 页码: 拼接在链接上，从1开始；
     */
    public static final String COMPLETED_TODO_LIST = "lg/todo/listdone/{"+TYPE+"}/json/{"+PAGE+"}";

}
