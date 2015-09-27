package com.cepheuen.olahwa.api;

import com.cepheuen.olahwa.models.BaseModel;
import com.cepheuen.olahwa.models.BookingResponseModel;
import com.cepheuen.olahwa.models.MusicListModel;
import com.cepheuen.olahwa.models.TrackCommonModel;

import retrofit.RestAdapter;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.POST;
import retrofit.http.Query;

/**
 * Created by Muthuramakrishan on 12-07-2015.
 */
public class OlaExtAPI {
    private static String endpointURL = "http://188.166.246.236:5000";
    private static OlaPublicAPI publicAPIService = null;


    public static OlaPublicAPI getPublicApiService() {
        if (publicAPIService == null) {
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .setEndpoint(endpointURL)
                    .build();

            publicAPIService = restAdapter.create(OlaPublicAPI.class);
        }
        return publicAPIService;
    }

    public interface OlaPublicAPI {

        @GET("/fetchMusic")
        MusicListModel fetchMusic();

        @FormUrlEncoded
        @POST("/createPlaylist")
        void createPlaylist();

    }
}
