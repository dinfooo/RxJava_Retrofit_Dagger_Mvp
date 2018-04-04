package afor.myapp.com.rxretrofitdaggerapp;

import android.app.Application;

import afor.myapp.com.rxretrofitdaggerapp.Compenent.DaggerNetComponent;
import afor.myapp.com.rxretrofitdaggerapp.Compenent.NetComponent;
import afor.myapp.com.rxretrofitdaggerapp.Module.AppModule;
import afor.myapp.com.rxretrofitdaggerapp.Module.NetModule;

/**
 * Created by Mahdi Dammak on 23/03/2018.
 */

public class MyApp extends Application {
    private NetComponent mNetComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        mNetComponent=DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("http://services.groupkt.com/country/get/"))
                .build();
    }

    public NetComponent getComponent()
    {
        return mNetComponent;
    }
}
