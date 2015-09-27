package com.cepheuen.olahwa.api;

import com.cepheuen.olahwa.models.DashboardModel;
import com.cepheuen.olahwa.models.MusicListModel;

import retrofit.RestAdapter;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;

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
        MusicListModel[] fetchMusic();

        @GET("/leaderboard")
        DashboardModel[] fetchLeaderboard();

        @FormUrlEncoded
        @POST("/createPlaylist")
        void createPlaylist();

    }
}
