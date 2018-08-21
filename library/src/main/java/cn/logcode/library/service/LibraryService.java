package cn.logcode.library.service;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.Nullable;


import java.util.concurrent.LinkedBlockingQueue;

import cn.logcode.library.ApplicationLibrary;
import cn.logcode.library.R;
import cn.logcode.library.utils.CheckUtils;

/**
 * Created by CaostGrace on 2018/8/5 22:01
 *
 * @author caost
 * @project_name: Android
 * @package_name: com.cdwh.chatapp.service
 * @class_name: BaoxinService
 * @github: https://github.com/CaostGrace
 * @简书: http://www.jianshu.com/u/b252a19d88f3
 * @content:
 */
public class LibraryService extends Service {


    public static LibraryService INSTANCE;

    public static LibraryService getInstance() {

        if (INSTANCE == null) {
            init(ApplicationLibrary.getContext());
        }
        return INSTANCE;
    }

    private ServiceThread mServiceThread;

    public static void init(Context context) {
        Intent service = new Intent(context, LibraryService.class);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            context.startForegroundService(service);
        } else {
            context.startService(service);
        }
    }


    /**
     * 绑定服务时才会调用
     * 必须要实现的方法
     *
     * @param intent
     * @return
     */
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    /**
     * 首次创建服务时，系统将调用此方法来执行一次性设置程序（在调用 onStartCommand() 或 onBind() 之前）。
     * 如果服务已在运行，则不会调用此方法。该方法只被调用一次
     */
    @Override
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            Notification.Builder builder = new Notification.Builder(getApplicationContext(), "baoxinService")
                    .setContentTitle("app")
                    .setContentText("app正在运行中")
                    .setSmallIcon(R.drawable.abc_btn_checkbox_checked_mtrl)
                    .setAutoCancel(true);

            startForeground(9874555, builder.getNotification());

        }

        mServiceThread = new ServiceThread();
        mServiceThread.start();
    }


    public void execute(Runnable serviceRunnable) {
        if (mServiceThread == null) {
            throw new NullPointerException("mServiceThread can`t null");
        }
        mServiceThread.execute(serviceRunnable);
    }

    /**
     * 每次通过startService()方法启动Service时都会被回调。
     * 需要在服务工作完成后，通过调用 stopSelf() 或 stopService() 来停止服务。
     *
     * @param intent
     * @param flags
     * @param startId
     * @return
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        INSTANCE = this;
        return START_STICKY;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        try {

            LibraryService.init(ApplicationLibrary.getContext());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }


    static class ServiceThread extends Thread {

        private Runnable mServiceRunnable;

        private boolean exit = false;

        private LinkedBlockingQueue<Runnable> mBlockingQueue;


        public void shutDown() {
            exit = true;
        }

        public void execute(Runnable serviceRunnable) {
            if (serviceRunnable == null) {
                throw new NullPointerException("serviceRunnable can`t null");
            }

            mServiceRunnable = serviceRunnable;

            if (mBlockingQueue == null) {
                throw new NullPointerException("mPriorityQueue can`t null");
            }

            try {
                mBlockingQueue.put(serviceRunnable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


        public ServiceThread(String name) {
            super(name);
            mBlockingQueue = new LinkedBlockingQueue<>();
        }

        public ServiceThread() {
            this(LibraryService.ServiceThread.class.getSimpleName());
        }


        @Override
        public void run() {

            while (!exit) {
                try {
                    mServiceRunnable = mBlockingQueue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (mServiceRunnable == null) {
                    throw new NullPointerException("serviceRunnable is null");
                }

                mServiceRunnable.run();

            }

            //关闭服务
            if (CheckUtils.checkNotNull(INSTANCE)) {

                INSTANCE.stopSelf();
            }

        }
    }

}
