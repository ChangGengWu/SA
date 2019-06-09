package com.example.FJU_Store;

import java.util.Map;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.Call;
import retrofit2.http.QueryMap;

public interface API {
    @GET("User")//User?api_key=dowefijiejfw
    Call<ListRes> getUser(@QueryMap(encoded = true) Map<String, String> queryMap);

    @POST("User?api_key=keySEVC5l6huQZqzW")
    Call<user_Res> postUser(@Body user_Req req);
}
