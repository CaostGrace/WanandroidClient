package cn.logcode.commandcore.utils;

/**
 * Created by CaostGrace on 2018/8/9 14:23
 *
 * @author caost
 * @project_name: ComponentBased
 * @package_name: cn.logcode.commandcore.utils
 * @class_name: Checkutils
 * @github: https://github.com/CaostGrace
 * @简书: http://www.jianshu.com/u/b252a19d88f3
 * @content:
 */
public class CheckUtils {

    /**
     * 检测string 是否为空或者为空字符串
     * @param str
     * @return
     */
    public static boolean checkNullString(String str) {
        if (str == null || str.equals("")) {
            return false;
        }
        return true;
    }

    /**
     * 检测 str 与  equalsStr 是否相等
     * @param str
     * @param equalsStr
     * @return
     */
    public static boolean checkEqualsString(String str, String equalsStr) {
        if (str == null || equalsStr == null) {
            return false;
        }
        if (str.equals(equalsStr)) {
            return true;
        }
        return false;
    }

    /**
     * 检测不为空
     * @param obj
     * @return
     */
    public static boolean checkIsNull(Object obj){
        if(obj == null){
            return true;
        }
        return false;
    }

}
