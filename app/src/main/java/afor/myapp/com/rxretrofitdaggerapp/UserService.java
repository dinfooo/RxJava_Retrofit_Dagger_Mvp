package afor.myapp.com.rxretrofitdaggerapp;

import afor.myapp.com.rxretrofitdaggerapp.data.retrofitEntity.RetourJson;
import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Mahdi Dammak on 22/03/2018.
 */

public interface UserService {
    @GET("all/")
    Observable<RetourJson> getAllPaysCodeRx();

}
