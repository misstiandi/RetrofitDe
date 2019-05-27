package com.example.st.retrofitdemo.server;

import com.example.st.retrofitdemo.BilibiliData;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ST on 2019/5/10.
 */

public interface BilibiliService {
    @GET("x/show/old?platform=android&device=&build=412001")
    Call<BilibiliData> getBilibili();
}
