package com.example.mana.newsfinder.utilities.retrofitUtils;

import java.util.Map;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface InterfaceService {
  @GET("top-headlines")
  Call<ResponseBody> getArticles(@QueryMap Map<String,String> params);
}
