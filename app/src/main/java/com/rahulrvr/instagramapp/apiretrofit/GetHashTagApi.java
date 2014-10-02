package com.rahulrvr.instagramapp.apiretrofit;

import com.rahulrvr.instagramapp.data.ImageInfo;

import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;


public interface GetHashTagApi {

    @GET("/{hashtag}/media/recent")
    public ImageInfo getHashTagImages(@Path("hashtag") String hashtag,@Query("access_token") String token);

    @GET("/{hashtag}/media/recent")
    public ImageInfo getNextHashTagImages(@Path("hashtag") String hashtag,@Query("access_token") String token,
                                          @Query("max_tag_id") String tag_id);

}
