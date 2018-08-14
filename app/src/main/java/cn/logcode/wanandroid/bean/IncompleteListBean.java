package cn.logcode.wanandroid.bean;

import java.util.List;

/**
 * Created by CaostGrace on 2018/8/14 11:25
 *
 * @author caost
 * @project_name: wanandroid
 * @package_name: cn.logcode.wanandroid.bean
 * @class_name: IncompleteListBean
 * @github: https://github.com/CaostGrace
 * @简书: http://www.jianshu.com/u/b252a19d88f3
 * @content:  未完成TODO列表
 */
public class IncompleteListBean {

    /**
     * curPage : 1
     * datas : [{"completeDate":null,"completeDateStr":"","content":"2018-8-6   -    2018-8-10","date":1533484800000,"dateStr":"2018-08-06","id":139,"status":0,"title":"单元测试学习","type":0,"userId":7595},{"completeDate":null,"completeDateStr":"","content":"2018-8-6  --  2018-8-10","date":1533484800000,"dateStr":"2018-08-06","id":140,"status":0,"title":"通用App架构搭建","type":0,"userId":7595},{"completeDate":null,"completeDateStr":"","content":"","date":1533484800000,"dateStr":"2018-08-06","id":179,"status":0,"title":"IPC学习","type":0,"userId":7595},{"completeDate":null,"completeDateStr":"","content":"","date":1533484800000,"dateStr":"2018-08-06","id":180,"status":0,"title":"玩安卓客户端","type":0,"userId":7595},{"completeDate":null,"completeDateStr":"","content":"","date":1533484800000,"dateStr":"2018-08-06","id":181,"status":0,"title":"组件化学习","type":0,"userId":7595}]
     * offset : 0
     * over : true
     * pageCount : 1
     * size : 20
     * total : 5
     */

    public int curPage;
    public int offset;
    public boolean over;
    public int pageCount;
    public int size;
    public int total;
    public List<DatasBean> datas;

    public static class DatasBean {
        /**
         * completeDate : null
         * completeDateStr :
         * content : 2018-8-6   -    2018-8-10
         * date : 1533484800000
         * dateStr : 2018-08-06
         * id : 139
         * status : 0
         * title : 单元测试学习
         * type : 0
         * userId : 7595
         */

        public Object completeDate;
        public String completeDateStr;
        public String content;
        public long date;
        public String dateStr;
        public int id;
        public int status;
        public String title;
        public int type;
        public int userId;
    }
}
