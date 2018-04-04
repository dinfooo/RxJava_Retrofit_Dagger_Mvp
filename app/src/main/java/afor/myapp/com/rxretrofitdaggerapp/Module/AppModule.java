package afor.myapp.com.rxretrofitdaggerapp.Module;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Mahdi Dammak on 22/03/2018.
 */
@Module
public class AppModule {

    Application mApplication;
    public AppModule(Application application)
    {
        mApplication=application;
    }

    @Provides
    @Singleton
    Application providesApplication()
    {
        return mApplication;
    }

}
