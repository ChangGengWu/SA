package com.example.FJU_Store;

import java.util.Map;//

import retrofit2.Call;
import retrofit2.http.Body;//請求參數:能以post方式傳遞json格式數據
import retrofit2.http.GET;//資料庫GET請求
import retrofit2.http.POST;//資料庫POST請求
import retrofit2.http.QueryMap;//和Query使用類似

public interface product_API {
    @GET("Product")//User?api_key=dowefijiejfw
    Call<product_ListRes> getProduct(@QueryMap(encoded = true) Map<String, String> queryMap);

    @POST("Product?api_key=keySEVC5l6huQZqzW")
    Call<product_Res> postProduct(@Body product_Req req);
//
}
