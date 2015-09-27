package com.cepheuen.olahwa.service;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.cepheuen.olahwa.api.OlaAPI;
import com.cepheuen.olahwa.models.BookingResponseModel;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.Wearable;
import com.google.android.gms.wearable.WearableListenerService;
import com.google.gson.Gson;

public class ListenerService extends WearableListenerService implements GoogleApiClient.ConnectionCallbacks, LocationListener {

    private GoogleApiClient mApiClient;
    private Gson gson;
    private Location location;
    private LocationManager mLocationManager;

    @Override
    public void onMessageReceived(MessageEvent messageEvent) {
        Log.d("Socket Msg", "Call API");
        showToast(messageEvent.getPath() + " cab now");
        performAction(messageEvent.getPath());
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initGoogleApiClient();
        gson = new Gson();
        mLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
    }

    private void initGoogleApiClient() {
        mApiClient = new GoogleApiClient.Builder(this)
                .addApi(Wearable.API)
                .build();

        mApiClient.connect();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mApiClient.disconnect();
    }

    private void performAction(String message) {
        if (message.equals("book")) {
            //call book endpoint
            try {
                mLocationManager.requestSingleUpdate(LocationManager.NETWORK_PROVIDER, this, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (message.equals("cancel")) {
            //call cancel endpoint
        }
    }

    private void sendMessage(final String path, final String text) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                NodeApi.GetConnectedNodesResult nodes = Wearable.NodeApi.getConnectedNodes(mApiClient).await();
                for (Node node : nodes.getNodes()) {
                    MessageApi.SendMessageResult result = Wearable.MessageApi.sendMessage(
                            mApiClient, node.getId(), path, text.getBytes()).await();
                }
            }
        }).start();
    }

    @Override
    public void onConnected(Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onLocationChanged(Location location) {
        this.location = location;
        new BookCabTask().execute();
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }

    private class BookCabTask extends AsyncTask<Void, Void, BookingResponseModel> {

        @Override
        protected BookingResponseModel doInBackground(Void... voids) {
            try {
                return OlaAPI.getPublicApiService().bookRide(String.valueOf(location.getLatitude()), String.valueOf(location.getLongitude()), "NOW", "sedan");
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(BookingResponseModel model) {
            if (model != null) {
                sendMessage("/openMap", gson.toJson(model));
            } else {
                Toast.makeText(ListenerService.this, "Server Error.", Toast.LENGTH_LONG).show();
                sendMessage("/status", "error");
            }
        }
    }
}