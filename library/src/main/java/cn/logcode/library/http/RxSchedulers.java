package cn.logcode.library.http;

import cn.logcode.library.config.HttpConfig;
import cn.logcode.library.utils.CheckUtils;
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


    public static <R> ObservableTransformer<BaseEntity<R>, R> compose(final NetworkLoadProcess networkLoadProcess) {
        return new ObservableTransformer<BaseEntity<R>, R>() {
            @Override
            public ObservableSource<R> apply(Observable<BaseEntity<R>> upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(new Consumer<Disposable>() {
                            @Override
                            public void accept(Disposable disposable) throws Exception {
                                if (!CheckUtils.checkIsNull(networkLoadProcess)) {
                                    networkLoadProcess.networkRequestStart("加载中...");
                                }
                            }
                        })
                        .map(new Function<BaseEntity<R>, R>() {
                            @Override
                            public R apply(BaseEntity<R> entity) throws Exception {
                                if (entity.status == HttpConfig.REQUEST_SUCCESS) {
                                    return entity.data;
                                }
                                throw new ApiException(entity.status, entity.msg);
                            }
                        })
                        .doOnError(new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                throwable.printStackTrace();
                                if (!CheckUtils.checkIsNull(networkLoadProcess)) {
                                    networkLoadProcess.networkRequestEnd();

                                    if (throwable instanceof ApiException) {
                                        ApiException apiException = (ApiException) throwable;
                                        networkLoadProcess.networkRequestError(apiException.code, apiException.msg);
                                    } else {
                                        networkLoadProcess.networkRequestError(404, "服务器错误");
                                    }

                                }
                            }
                        })
                        .doOnNext(new Consumer<R>() {
                            @Override
                            public void accept(R r) throws Exception {
                                if (!CheckUtils.checkIsNull(networkLoadProcess)) {
                                    networkLoadProcess.networkRequestEnd();
                                }
                            }
                        })
                        ;
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


}
