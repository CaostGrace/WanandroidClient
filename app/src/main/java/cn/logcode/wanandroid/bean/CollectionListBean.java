package cn.logcode.wanandroid.bean;

import java.util.List;

/**
 * Created by CaostGrace on 2018/8/13 14:54
 *
 * @author caost
 * @project_name: wanandroid
 * @package_name: cn.logcode.wanandroid.bean
 * @class_name: CollectionListBean
 * @github: https://github.com/CaostGrace
 * @简书: http://www.jianshu.com/u/b252a19d88f3
 * @content:   收藏列表bean
 */
public class CollectionListBean {

    /**
     * curPage : 1
     * datas : [{"author":"小编","chapterId":352,"chapterName":"资讯","courseId":13,"desc":"","envelopePic":"","id":20934,"link":"http://www.wanandroid.com/blog/show/2","niceDate":"23分钟前","origin":"","originId":2864,"publishTime":1534141787000,"title":"玩Android API","userId":7595,"visible":0,"zan":0}]
     * offset : 0
     * over : true
     * pageCount : 1
     * size : 20
     * total : 1
     */

    public int curPage;
    public int offset;
    public boolean over;
    public int pageCount;
    public int size;
    public int total;
    public List<DatasBean> datas;

    @Override
    public String toString() {
        return "CollectionListBean{" +
                "curPage=" + curPage +
                ", offset=" + offset +
                ", over=" + over +
                ", pageCount=" + pageCount +
                ", size=" + size +
                ", total=" + total +
                ", datas=" + datas +
                '}';
    }

    public static class DatasBean {
        @Override
        public String toString() {
            return "DatasBean{" +
                    "author='" + author + '\'' +
                    ", chapterId=" + chapterId +
                    ", chapterName='" + chapterName + '\'' +
                    ", courseId=" + courseId +
                    ", desc='" + desc + '\'' +
                    ", envelopePic='" + envelopePic + '\'' +
                    ", id=" + id +
                    ", link='" + link + '\'' +
                    ", niceDate='" + niceDate + '\'' +
                    ", origin='" + origin + '\'' +
                    ", originId=" + originId +
                    ", publishTime=" + publishTime +
                    ", title='" + title + '\'' +
                    ", userId=" + userId +
                    ", visible=" + visible +
                    ", zan=" + zan +
                    '}';
        }

        /**
         * author : 小编
         * chapterId : 352
         * chapterName : 资讯
         * courseId : 13
         * desc :
         * envelopePic :
         * id : 20934
         * link : http://www.wanandroid.com/blog/show/2
         * niceDate : 23分钟前
         * origin :
         * originId : 2864
         * publishTime : 1534141787000
         * title : 玩Android API
         * userId : 7595
         * visible : 0
         * zan : 0
         */




        public String author;
        public int chapterId;
        public String chapterName;
        public int courseId;
        public String desc;
        public String envelopePic;
        public int id;
        public String link;
        public String niceDate;
        public String origin;
        public int originId;
        public long publishTime;
        public String title;
        public int userId;
        public int visible;
        public int zan;
    }
}
