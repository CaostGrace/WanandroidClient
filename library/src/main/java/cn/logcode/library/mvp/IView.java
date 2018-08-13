package cn.logcode.library.mvp;


/**
 * Created by CaostGrace on 2018/6/5 22:20
 *
 * @project_name: FrameworkDemo
 * @package_name: cn.logcode.frameworkdemo.mvp
 * @class_name: IView
 * @github: https://github.com/CaostGrace
 * @简书: http://www.jianshu.com/u/b252a19d88f3
 * @content:
 */
public interface IView<T extends IDelegate>{

    void onAttach(T t,boolean isFragment);


    void loadStart(String msg);


    void loadEnd();


    void loadError(int code, String errorMSg);


    void deAttach();
}
