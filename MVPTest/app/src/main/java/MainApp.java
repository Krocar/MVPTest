import android.annotation.SuppressLint;
import android.app.Application;

import utils.RetrofitUtils;

@SuppressLint("Registered")
public class MainApp extends Application{
    @Override
    public void onCreate(){
        super.onCreate();;
        //初始化retrofitUtils
        RetrofitUtils.getInstance().initOkHttp(this);
    }
}
