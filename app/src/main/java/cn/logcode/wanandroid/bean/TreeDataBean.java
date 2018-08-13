package cn.logcode.wanandroid.bean;

import java.util.List;

/**
 * Created by CaostGrace on 2018/8/13 11:31
 *
 * @author caost
 * @project_name: wanandroid
 * @package_name: cn.logcode.wanandroid.bean
 * @class_name: TreeDataBean
 * @github: https://github.com/CaostGrace
 * @简书: http://www.jianshu.com/u/b252a19d88f3
 * @content: 2.1 体系数据 bean  是一个list
 */
public class TreeDataBean {

    /**
     * children : [{"children":[],"courseId":13,"id":60,"name":"Android Studio相关","order":1000,"parentChapterId":150,"visible":1},{"children":[],"courseId":13,"id":169,"name":"gradle","order":1001,"parentChapterId":150,"visible":1},{"children":[],"courseId":13,"id":269,"name":"官方发布","order":1002,"parentChapterId":150,"visible":1}]
     * courseId : 13
     * id : 150
     * name : 开发环境
     * order : 1
     * parentChapterId : 0
     * visible : 1
     */

    public int courseId;
    public int id;
    public String name;
    public int order;
    public int parentChapterId;
    public int visible;
    public List<ChildrenBean> children;

    public static class ChildrenBean {
        /**
         * children : []
         * courseId : 13
         * id : 60
         * name : Android Studio相关
         * order : 1000
         * parentChapterId : 150
         * visible : 1
         */

        public int courseId;
        public int id;
        public String name;
        public int order;
        public int parentChapterId;
        public int visible;
        public List<?> children;
    }
}
