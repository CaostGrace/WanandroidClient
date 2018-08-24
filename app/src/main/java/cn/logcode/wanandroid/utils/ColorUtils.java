package cn.logcode.wanandroid.utils;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cn.logcode.library.Log.LogUtils;
import cn.logcode.library.utils.CheckUtils;

/**
 * Created by CaostGrace on 2018/8/23 15:34
 *
 * @author caost
 * @project_name: wanandroid
 * @package_name: cn.logcode.wanandroid.utils
 * @class_name: ColorUtils
 * @github: https://github.com/CaostGrace
 * @简书: http://www.jianshu.com/u/b252a19d88f3
 * @content:
 */
public class ColorUtils {

    private static String[] colorValue = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
            "a", "b", "c", "d", "e", "f"};


    public static List<Integer> getColor(int size) {

        List<Integer> colors = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            colors.add(Color.parseColor(generateColor()));
        }
        return colors;

    }


    public static Integer getColor() {
        return Color.parseColor(generateColor());

    }

    public static String generateColor() {
        StringBuilder sb = new StringBuilder("#");

        Random rand = new Random();

        for (int j = 0; j < 6; j++) {
            sb.append(colorValue[rand.nextInt(16)]);
        }
        LogUtils.d(sb);

        return sb.toString();
    }

}
