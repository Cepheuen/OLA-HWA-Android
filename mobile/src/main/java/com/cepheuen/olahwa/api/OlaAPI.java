package com.cepheuen.olahwa.api;

import com.cepheuen.olahwa.models.BaseModel;
import com.cepheuen.olahwa.models.BookingResponseModel;
import com.cepheuen.olahwa.models.TrackCommonModel;

import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.Query;

/**
 * Created by Muthuramakrishan on 12-07-2015.
 */
public class OlaAPI {
    private static String endpointURL = "http://sandbox-t.olacabs.com/v1";
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

        @GET("/products")
        @Headers("X-APP-TOKEN: 2c623e867c1a4cf39c43a4757a207f08")
        BaseModel checkAvailability(@Query("pickup_lat") String pickup_lat, @Query("pickup_lng") String pickup_lng, @Query("/category") String category);

        @GET("/products")
        @Headers("X-APP-TOKEN: 2c623e867c1a4cf39c43a4757a207f08")
        BaseModel rideEstimate(@Query("pickup_lat") String pickup_lat, @Query("pickup_lng") String pickup_lng, @Query("drop_lat") String drop_lat, @Query("drop_lng") String drop_lng, @Query("/category") String category);

        @GET("/bookings/create")
        @Headers({"X-APP-TOKEN: 2c623e867c1a4cf39c43a4757a207f08", "Authorization: Bearer 631404119bfc4097b6aac95ce160933c"})
        BookingResponseModel bookRide(@Query("pickup_lat") String pickup_lat, @Query("pickup_lng") String pickup_lng, @Query("pickup_mode") String pickup_mode ,@Query("category") String category);

        @GET("/bookings/track_ride")
        @Headers({"X-APP-TOKEN: 2c623e867c1a4cf39c43a4757a207f08", "Authorization: Bearer 631404119bfc4097b6aac95ce160933c"})
        TrackCommonModel trackRide();

        @GET("/bookings/cancel")
        @Headers({"X-APP-TOKEN: 2c623e867c1a4cf39c43a4757a207f08", "Authorization: Bearer 631404119bfc4097b6aac95ce160933c"})
        TrackCommonModel cancelRide(@Query("crn") String crn);
    }
}
