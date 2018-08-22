package cn.logcode.wanandroid.utils;

import android.content.Context;
import android.content.Intent;

import cn.logcode.wanandroid.config.Constants;
import cn.logcode.wanandroid.ui.activity.WebActivity;

/**
 * Created by CaostGrace on 2018/8/21 15:41
 *
 * @author caost
 * @project_name: wanandroid
 * @package_name: cn.logcode.wanandroid.utils
 * @class_name: JumpUtils
 * @github: https://github.com/CaostGrace
 * @简书: http://www.jianshu.com/u/b252a19d88f3
 * @content:
 */
public class JumpUtils {
    public static void jumpWebActivity(Context context, String urls) {
        Intent intent = new Intent(context, WebActivity.class);
        intent.putExtra(Constants.WEBVIEW_URL, urls);
        context.startActivity(intent);
    }
}
