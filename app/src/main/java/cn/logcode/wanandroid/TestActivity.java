package cn.logcode.wanandroid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.List;

import cn.logcode.library.Log.LogUtils;
import cn.logcode.library.http.BaseEntity;
import cn.logcode.library.http.DefaultObserver;
import cn.logcode.library.http.EntityObserver;
import cn.logcode.library.http.HttpManager;
import cn.logcode.library.http.RxSchedulers;
import cn.logcode.wanandroid.bean.Banner;
import cn.logcode.wanandroid.bean.CollectionListBean;
import cn.logcode.wanandroid.bean.HomePageList;
import cn.logcode.wanandroid.bean.LoginBean;
import cn.logcode.wanandroid.http.WanAndroidApiService;
import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.Consumer;

/**
 * Created by CaostGrace on 2018/8/13 11:57
 *
 * @author caost
 * @project_name: wanandroid
 * @package_name: cn.logcode.wanandroid
 * @class_name: TestActivity
 * @github: https://github.com/CaostGrace
 * @简书: http://www.jianshu.com/u/b252a19d88f3
 * @content:
 */
public class TestActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity);
        findViewById(R.id.test1).setOnClickListener((view) -> {
            HttpManager<WanAndroidApiService> httpManager = HttpManager.getInstance();

            httpManager
                    .apiService()
                    .collectList(0)
                    .compose(RxSchedulers.compose())
                    .subscribe(new DefaultObserver<CollectionListBean>() {
                        @Override
                        public void onHandleSuccess(CollectionListBean bean) {
                            LogUtils.d(bean.toString());
                        }
                        @Override
                        protected void onHandleError(int code, String msg) {
                            super.onHandleError(code, msg);
                            LogUtils.d(code + "<=====>" + msg);
                        }
                    });

        });


    }
}
