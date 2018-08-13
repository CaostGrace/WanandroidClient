package cn.logcode.library.http;

import org.reactivestreams.Publisher;

import cn.logcode.library.R;
import cn.logcode.library.config.HttpConfig;
import cn.logcode.library.utils.CheckUtils;
import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by CaostGrace on 2018/5/28 21:51
 *
 * @author caost
 * @project_name: FrameworkDemo
 * @package_name: cn.logcode.library.http
 * @class_name: RxSchedulers
 * @github: https://github.com/CaostGrace
 * @简书: http://www.jianshu.com/u/b252a19d88f3
 * @content:
 */
public class RxSchedulers {

    public static <R> ObservableTransformer<BaseEntity<R>, R> compose() {
        return new ObservableTransformer<BaseEntity<R>, R>() {
            @Override
            public ObservableSource<R> apply(Observable<BaseEntity<R>> upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .map(new Function<BaseEntity<R>, R>() {
                            @Override
                            public R apply(BaseEntity<R> entity) throws Exception {

                                if (entity.status == HttpConfig.REQUEST_SUCCESS) {
                                    return entity.data;
                                }
                                throw new ApiException(entity.status, entity.msg);
                            }
                        });
            }
        };

    }


    public static <T> ObservableTransformer<T, T> defaultCompose() {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return upstream
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }


    public static <R> FlowableTransformer<BaseEntity<R>, R> flowableCompose() {
        return (Flowable<BaseEntity<R>> upstream) ->
                upstream.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .map((BaseEntity<R> entity) -> {
                            if (entity.status == HttpConfig.REQUEST_SUCCESS) {
                                return entity.data;
                            }
                            throw new ApiException(entity.status, entity.msg);
                        });
    }


    public static <R> FlowableTransformer<R, R> flowabledefaultCompose() {
        return (Flowable<R> upstream) ->
                upstream
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());

    }


}
