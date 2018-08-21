package cn.logcode.androidarchitecturecomponents;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import cn.logcode.androidarchitecturecomponents.bean.BannerBean;
import cn.logcode.androidarchitecturecomponents.http.Api;
import cn.logcode.androidarchitecturecomponents.lifecycle.MyLifecycle;
import cn.logcode.androidarchitecturecomponents.repository.UserRepository;
import cn.logcode.androidarchitecturecomponents.viewmodel.UserProfileViewModel;
import cn.logcode.library.http.HttpManager;
import cn.logcode.library.widget.ToastUtil;

public class MainActivity extends AppCompatActivity {


    UserProfileViewModel mUserProfileViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView text = findViewById(R.id.text);

        getLifecycle().addObserver(new MyLifecycle());
        mUserProfileViewModel = ViewModelProviders.of(this).get(UserProfileViewModel.class);


        mUserProfileViewModel.init("用户名", new UserRepository((Api) HttpManager.getInstance().apiService(Api.class)));

        mUserProfileViewModel.mBeanLiveData.observe(this, bannerBean -> {
            ToastUtil.init(this)
                    .makeText(bannerBean.data.toString(), Toast.LENGTH_SHORT)
                    .show();
            //更新UI
            text.setText(bannerBean.data.toString());
        });

    }
}
