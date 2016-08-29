package qainfeng.myshop.application;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * on 2016/8/29.
 * 类的描述:
 */
public class MyApplication extends Application {
    private static RequestQueue mRequestQueue;
    @Override
    public void onCreate() {
        super.onCreate();
        if (mRequestQueue == null) {
            //初始化 请求队列
            mRequestQueue = Volley.newRequestQueue(this);
        }
    }
    public static RequestQueue getRequestQeue(){
        return mRequestQueue;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        mRequestQueue= null;
    }
}
