package cn.logcode.wanandroid.ui.fragment.project;

import java.util.List;

import cn.logcode.library.callback.CallBack;
import cn.logcode.library.http.DefaultObserver;
import cn.logcode.library.http.RxSchedulers;
import cn.logcode.wanandroid.base.BaseModel;
import cn.logcode.wanandroid.bean.ProjectBean;
import cn.logcode.wanandroid.utils.HttpUtils;

/**
 * Created by CaostGrace on 2018/8/23 14:42
 *
 * @author caost
 * @project_name: wanandroid
 * @package_name: cn.logcode.wanandroid.ui.fragment.project
 * @class_name: MainProjectModel
 * @github: https://github.com/CaostGrace
 * @简书: http://www.jianshu.com/u/b252a19d88f3
 * @content:
 */
public class MainProjectModel extends BaseModel {

    /**
     * 获取项目的所有类别
     *
     * @param callBack
     */
    public void getProjectCategory(CallBack<List<ProjectBean>> callBack) {
        addDisposable(HttpUtils.get().apiService()
                .project()
                .compose(RxSchedulers.compose())
                .subscribeWith(new DefaultObserver<List<ProjectBean>>() {
                    @Override
                    protected void onHandleSuccess(List<ProjectBean> beans) {
                        callBack.data(beans);
                    }

                    @Override
                    protected void onHandleError(int code, String msg) {
                        super.onHandleError(code, msg);
                        callBack.onError(code, msg);
                    }
                }));
    }


}
