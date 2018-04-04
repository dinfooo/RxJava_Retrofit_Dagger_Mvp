package afor.myapp.com.rxretrofitdaggerapp.Module;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import afor.myapp.com.rxretrofitdaggerapp.UserService;
import afor.myapp.com.rxretrofitdaggerapp.data.source.PaysServiceImp;
import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Mahdi Dammak on 22/03/2018.
 */
@Module
public class NetModule {
    String mBaseUrl;
    public NetModule(String baseUrl)
    {
        this.mBaseUrl=baseUrl;
    }

    // Dagger will only look for methods annotated with @Provides
    @Provides
    @Singleton
    SharedPreferences providesSharedPreferences(Application application)
    {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

    @Provides
    @Singleton
    HttpLoggingInterceptor provideOkHttpHttpLoggingInterceptor()
    {
        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    @Provides
    @Singleton
    Cache provideOkHttpCache(Application application)
    {
        // Enable caching for OkHttp
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        Cache cache = new Cache(application.getCacheDir(), cacheSize);
        return cache;
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(Cache cache,HttpLoggingInterceptor httpLoggingInterceptor)
    {
        return new OkHttpClient()
                .newBuilder()
                .cache(cache)
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }

    @Provides
    @Singleton
    GsonConverterFactory provideGsonConverterFactory()
    {
        // Instantiate Gson
        Gson gson = new GsonBuilder().create();
        GsonConverterFactory converterFactory = GsonConverterFactory.create(gson);
        return converterFactory;
    }

    @Provides
    @Singleton
    RxJava2CallAdapterFactory provideRxJava2CallAdapterFactory()
    {
        return RxJava2CallAdapterFactory.create();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit (GsonConverterFactory converterFactory,OkHttpClient client)
    {
        // Build Retrofit
        return new Retrofit.Builder()
                .baseUrl(mBaseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(converterFactory)
                .client(client)  // custom client
                .build();
    }

    @Provides
    @Singleton
    public UserService provideUserService(Retrofit retrofit) {
        return retrofit.create(UserService.class);
    }

    @Provides
    @Singleton
    public PaysServiceImp providePaysServiceImp(
            UserService userService) {
        return PaysServiceImp.getInstance(userService);
    }

}
