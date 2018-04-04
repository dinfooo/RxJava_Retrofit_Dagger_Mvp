package afor.myapp.com.rxretrofitdaggerapp.data.retrofitEntity;

/**
 * Created by Mahdi Dammak on 27/02/2018.
 */

public class RetourJson {
    RestResponse RestResponse;

    public RetourJson(RestResponse restResponse) {
        RestResponse = restResponse;
    }

    public RetourJson() {
    }

    public RestResponse getRestResponse() {
        return RestResponse;
    }

    public void setRestResponse(RestResponse restResponse) {
        RestResponse = restResponse;
    }

    @Override
    public String toString() {
        return "RetourJson{" +
                "RestResponse=" + RestResponse +
                '}';
    }
}
