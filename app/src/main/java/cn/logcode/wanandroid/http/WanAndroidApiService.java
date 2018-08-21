package cn.logcode.wanandroid.http;

import java.util.List;

import cn.logcode.library.http.BaseEntity;
import cn.logcode.wanandroid.bean.AddWebSiteCollectBean;
import cn.logcode.wanandroid.bean.Banner;
import cn.logcode.wanandroid.bean.CollectSiteListBean;
import cn.logcode.wanandroid.bean.CollectionArticleListBean;
import cn.logcode.wanandroid.bean.CommonWebsiteBean;
import cn.logcode.wanandroid.bean.ArticlePageList;
import cn.logcode.wanandroid.bean.HotKeyBean;
import cn.logcode.wanandroid.bean.IncompleteListBean;
import cn.logcode.wanandroid.bean.LoginBean;
import cn.logcode.wanandroid.bean.NavBean;
import cn.logcode.wanandroid.bean.NullBean;
import cn.logcode.wanandroid.bean.ProjectBean;
import cn.logcode.wanandroid.bean.ProjectListDataBean;
import cn.logcode.wanandroid.bean.RegisterBean;
import cn.logcode.wanandroid.bean.Todo;
import cn.logcode.wanandroid.bean.TodoBean;
import cn.logcode.wanandroid.bean.TreeArticleBean;
import cn.logcode.wanandroid.bean.TreeDataBean;
import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by CaostGrace on 2018/8/10 14:06
 *
 * @author caost
 * @project_name: wanandroid
 * @package_name: cn.logcode.wanandroid.http
 * @class_name: WanAndroidApiService
 * @github: https://github.com/CaostGrace
 * @简书: http://www.jianshu.com/u/b252a19d88f3
 * @content:
 */
public interface WanAndroidApiService {

    /**
     * 1.1 首页文章列表
     *
     * @param page 页码
     * @return
     */
    @GET(HttpConstants.ARTICLE)
    Observable<BaseEntity<ArticlePageList>> homePageList(@Path(HttpConstants.PAGE) int page);

    /**
     * 1.2 首页banner
     *
     * @return
     */
    @GET(HttpConstants.BANNER)
    Observable<BaseEntity<List<Banner>>> banner();

    /**
     * 1.3 常用网站
     *
     * @return
     */
    @GET(HttpConstants.FRIEND)
    Observable<BaseEntity<List<CommonWebsiteBean>>> commonWebsites();


    /**
     * 1.4 搜索热词
     *
     * @return
     */
    @GET(HttpConstants.HOTKEY)
    Observable<BaseEntity<List<HotKeyBean>>> hotkey();


    /**
     * 2.1 体系数据
     *
     * @return
     */
    @GET(HttpConstants.TREE)
    Observable<BaseEntity<List<TreeDataBean>>> tree();

    /**
     * 2.2 知识体系下的文章
     *
     * @param page 页码
     * @param cid   文章id
     * @return
     */
    @GET(HttpConstants.TREE_ARTICLE)
    Observable<BaseEntity<TreeArticleBean>> treeArticle(@Path(HttpConstants.PAGE) int page, @Query("cid") int cid);


    /**
     * 3.1 导航数据
     *
     * @return
     */
    @GET(HttpConstants.NAVI)
    Observable<BaseEntity<List<NavBean>>> navi();


    /**
     * 4.1 项目分类
     *
     * @return
     */
    @GET(HttpConstants.PROJECT)
    Observable<BaseEntity<List<ProjectBean>>> project();

    /**
     * 4.2 项目列表数据
     *
     * @param page 页码
     * @param id   id
     * @return
     */
    @GET(HttpConstants.PROJECT_LIST_DATA)
    Observable<BaseEntity<ProjectListDataBean>> projectListData(@Path(HttpConstants.PAGE) int page, @Query("cid") int id);


    /**
     * 5.1 登录
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @FormUrlEncoded
    @POST(HttpConstants.LOGIN)
    Observable<BaseEntity<LoginBean>> login(@Field("username") String username, @Field("password") String password);


    /**
     * 5.2 注册
     *
     * @param username   用户名
     * @param password   密码
     * @param repassword 重复密码
     * @return
     */
    @FormUrlEncoded
    @POST(HttpConstants.REGISTER)
    Observable<BaseEntity<RegisterBean>> register(@Field("username") String username, @Field("password") String password,
                                                  @Field("repassword") String repassword);


    /**
     * 6.1 收藏文章列表      ,需要添加登录成功的cookie
     *
     * @param page 页码
     * @return
     */
    @GET(HttpConstants.COLLECT_ARTICLE_LIST)
    Observable<BaseEntity<CollectionArticleListBean>> collectList(@Path(HttpConstants.PAGE) int page);


    /**
     * 6.2 收藏站内文章
     *
     * @param id 文章id
     * @return
     */
    @POST(HttpConstants.COLLECT_IN_STATION)
    Observable<BaseEntity<NullBean>> collectInStation(@Path(HttpConstants.ID) int id);


    /**
     * 6.3 收藏站外文章
     *
     * @param title  文章标题
     * @param author 作者
     * @param link   链接
     * @return
     */
    @FormUrlEncoded
    @POST(HttpConstants.COLLECT_OUT_STATION)
    Observable<BaseEntity<NullBean>> collectOutStation(@Field("title") String title, @Field("author") String author,
                                                       @Field("link") String link);


    /**
     * 6.4.1 文章列表 取消收藏
     *
     * @return
     */
    @POST(HttpConstants.ARTICLES_LIST_UNCOLLECT)
    Observable<BaseEntity<NullBean>> articlesListUncollect();


    /**
     * 6.4.2 我的收藏页面（该页面包含自己录入的内容） 取消收藏
     *
     * @param id
     * @param originId originId 代表的是你收藏之前的那篇文章本身的id； 但是收藏支持主动添加，这种情况下，没有originId则为-1
     * @return
     */
    @FormUrlEncoded
    @POST(HttpConstants.COLLECTION_LIST_UNCOLLECT)
    Observable<BaseEntity<NullBean>> articlesListUncollect(@Path(HttpConstants.ID) int id, @Field("originId") String originId);


    /**
     * 6.5 收藏网站列表
     *
     * @return
     */
    @GET(HttpConstants.COLLECTION_SITE_LIST)
    Observable<BaseEntity<List<CollectSiteListBean>>> collectionSiteList();


    /**
     * 6.6 收藏网址
     *
     * @param name
     * @param link
     * @return
     */
    @FormUrlEncoded
    @POST(HttpConstants.COLLECTION_WEB_SITES)
    Observable<BaseEntity<AddWebSiteCollectBean>> collectionWebSites(@Field("name") String name,
                                                                     @Field("link") String link);


    /**
     * 6.7 编辑收藏网站
     *
     * @param id
     * @param name
     * @param link
     * @return
     */
    @FormUrlEncoded
    @POST(HttpConstants.EDIT_COLLECTION_WEBSITE)
    Observable<BaseEntity<CollectSiteListBean>> editCollectionWebsite(@Field("id") String id,
                                                                      @Field("name") String name,
                                                                      @Field("link") String link);


    /**
     * 6.8 删除收藏网站
     *
     * @param id
     * @return
     */
    @FormUrlEncoded
    @POST(HttpConstants.DELETE_COLLECTION_WEBSITE)
    Observable<BaseEntity<NullBean>> deleteCollectionWebsite(@Field("id") String id);


    /**
     * 7.1 搜索
     *
     * @param page 页码
     * @param key  搜索关键字
     * @return
     */
    @FormUrlEncoded
    @POST(HttpConstants.QUERY)
    Observable<BaseEntity<ArticlePageList>> query(@Path(HttpConstants.PAGE) int page,
                                                  @Field("k") String key);


    /**
     * 8.1 获取TODO列表
     *
     * @param type type取值为0，1，2，3。  分别为 只用这一个、工作、学习、生活
     * @return
     */
    @GET(HttpConstants.TYPE)
    Observable<BaseEntity<TodoBean>> todoList(@Path(HttpConstants.TYPE) int type);


    /**
     * 8.2 新增一条Todo
     *
     * @param title   标题
     * @param content 内容
     * @param date    时间 2018-08-01
     * @param type    类型 type取值为0，1，2，3。  分别为 只用这一个、工作、学习、生活
     * @return
     */
    @FormUrlEncoded
    @POST(HttpConstants.ADD_TODO)
    Observable<BaseEntity<Todo>> addTodo(@Field("title") String title,
                                         @Field("content") String content,
                                         @Field("date") String date,
                                         @Field("type") int type);


    /**
     * 8.3 更新一条Todo内容
     *
     * @param id      id   拼接在链接上，为唯一标识
     * @param title
     * @param content
     * @param date
     * @param type
     * @param status  0为未完成，1为完成
     * @return
     */
    @FormUrlEncoded
    @POST(HttpConstants.UPDATE_TODO)
    Observable<BaseEntity<Todo>> updateTodo(@Path(HttpConstants.ID) int id,
                                            @Field("title") String title,
                                            @Field("content") String content,
                                            @Field("date") String date,
                                            @Field("type") int type,
                                            @Field("status") String status);


    /**
     * 8.4 删除一条Todo
     *
     * @param id 拼接在链接上，为唯一标识
     * @return
     */
    @POST(HttpConstants.DELATE_TODO)
    Observable<BaseEntity<NullBean>> deleteTodo(@Path(HttpConstants.ID) int id);


    /**
     * 8.5 仅更新完成状态Todo
     *
     * @param id 拼接在链接上，为唯一标识
     * @return
     */
    @POST(HttpConstants.UPDATE_COMPLETE_STATE_TODO)
    Observable<BaseEntity<Todo>> updateCompleteStateTodo(@Path(HttpConstants.ID) int id);


    /**
     * 8.6 未完成 Todo 列表
     *
     * @param type 类型：类型拼接在链接上，目前支持0,1,2,3
     * @param page 拼接在链接上，从1开始；
     * @return
     */
    @POST(HttpConstants.INCOMPLETE_LIST)
    Observable<BaseEntity<IncompleteListBean>> incompleteList(@Path(HttpConstants.TYPE) int type,
                                                              @Path(HttpConstants.PAGE) int page);


    /**
     * 8.7 已完成 Todo 列表
     *
     * @param type 类型：类型拼接在链接上，目前支持0,1,2,3
     * @param page 拼接在链接上，从1开始；
     * @return
     */
    @POST(HttpConstants.COMPLETED_TODO_LIST)
    Observable<BaseEntity<IncompleteListBean>> completedTodoList(@Path(HttpConstants.TYPE) int type,
                                                                 @Path(HttpConstants.PAGE) int page);

}
