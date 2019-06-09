package com.example.FJU_Store;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface order_API {
    @GET("Order")//User?api_key=dowefijiejfw
    Call<order_ListRes> getOrder(@QueryMap(encoded = true) Map<String, String> queryMap);

    @POST("Order?api_key=keySEVC5l6huQZqzW")
    Call<order_Res> postOrder(@Body order_Req req);
}
