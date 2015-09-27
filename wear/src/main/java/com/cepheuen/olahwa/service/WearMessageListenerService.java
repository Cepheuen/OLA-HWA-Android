package com.cepheuen.olahwa.service;

import android.content.Intent;
import android.util.Log;

import com.cepheuen.olahwa.BookActivity;
import com.cepheuen.olahwa.LoadingActivity;
import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.WearableListenerService;

import java.io.UnsupportedEncodingException;

public class WearMessageListenerService extends WearableListenerService {
    private static final String OPEN_MAP = "/openMap";
    private static final String OPEN_MSG = "/status";

    @Override
    public void onMessageReceived(MessageEvent messageEvent) {
        Intent intent;
        String str = "";
        try {
            str = new String(messageEvent.getData(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Log.d("SDDS","TEST");
        if (messageEvent.getPath().equalsIgnoreCase(OPEN_MAP)) {
            intent = new Intent(this, BookActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("data", str);
            startActivity(intent);
        } else if (messageEvent.getPath().equalsIgnoreCase(OPEN_MSG)) {
            intent = new Intent(this, LoadingActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("data", "Unable to book a cab!");
            startActivity(intent);
        } else {
            super.onMessageReceived(messageEvent);
        }
    }

}