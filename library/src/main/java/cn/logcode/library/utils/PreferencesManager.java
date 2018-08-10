package cn.logcode.library.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by CaostGrace on 2018/8/9 18:08
 *
 * @author caost
 * @project_name: ComponentBased
 * @package_name: cn.logcode.basemodule.persistent.preferences
 * @class_name: PreferencesManager
 * @github: https://github.com/CaostGrace
 * @简书: http://www.jianshu.com/u/b252a19d88f3
 * @content:
 */
public class PreferencesManager {

    private static SharedPreferences mPreferences;

    private static PreferencesManager preferenceManager;

    public static PreferencesManager get(Context context, String spName) {
        mPreferences = context.getSharedPreferences(spName, Context.MODE_PRIVATE);

        if (preferenceManager == null) {
            preferenceManager = new PreferencesManager();
        }
        return preferenceManager;
    }


    public void putString(String key, String value) {
        mPreferences.edit().putString(key, value).apply();
    }

    public void putBoolean(String key, boolean value) {
        mPreferences.edit().putBoolean(key, value).apply();
    }

    public void putInteger(String key, Integer integer) {
        mPreferences.edit().putInt(key, integer).apply();
    }


    public String getString(String key) {
        return mPreferences.getString(key, "");
    }


    public int getInt(String key) {
        return mPreferences.getInt(key, 0);
    }


    public boolean getBoolean(String key) {
        return mPreferences.getBoolean(key, false);
    }

}
