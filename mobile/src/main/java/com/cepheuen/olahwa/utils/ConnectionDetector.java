package com.cepheuen.olahwa.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class ConnectionDetector {

    Context activity;
    private ConnectivityManager manager;

    public ConnectionDetector(Context activity) {
        this.activity = activity;
        manager = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    public boolean isConnectionAvailable() {

        boolean connected = false;
        if (manager != null) {
            NetworkInfo info = manager.getActiveNetworkInfo();
            if (info != null && info.isConnectedOrConnecting()) {
                connected = true;
            }
        }
        return connected;

    }

}
