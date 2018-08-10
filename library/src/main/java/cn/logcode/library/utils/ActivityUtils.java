package cn.logcode.library.utils;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CaostGrace on 2018/8/9 11:20
 *
 * @author caost
 * @project_name: ComponentBased
 * @package_name: cn.logcode.commandcore.utils
 * @class_name: ActivityUtils
 * @github: https://github.com/CaostGrace
 * @简书: http://www.jianshu.com/u/b252a19d88f3
 * @content:
 */
public class ActivityUtils {
    private static List<Activity> activityList = new ArrayList<>();

    public static Activity add(Activity activity) {
        if (activityList != null && activity != null) {
            activityList.add(activity);
        }

        return activity;
    }

    public static void remove(Activity activity) {
        if (activityList != null && activity != null) {
            if (activityList.contains(activity)) {
                activityList.remove(activity);
                activity.finish();
            }
        }
    }


    public static void exit() {
        if (activityList != null) {
            for (Activity activity : activityList) {
                activity.finish();
            }
        }
    }


    public static Activity getTopActivity() {
        if (activityList != null && activityList.size() != 0) {
            return activityList.get(activityList.size() - 1);
        }
        return null;
    }

}
