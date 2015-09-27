package com.cepheuen.olahwa;

import android.content.Context;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.Wearable;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class LoadingActivity extends WearableActivity {

    private static final long CONNECTION_TIME_OUT_MS = 100;
    private TextView status;
    private ProgressBar progressBar;
    private GoogleApiClient client;
    private String nodeId;
    private String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.loading_layout);
        initApi();
        status = (TextView) findViewById(R.id.statusText);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        data = getIntent().getStringExtra("data");

        /*new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(LoadingActivity.this, BookActivity.class));
                finish();
            }
        }, 1800);*/
    }

    /**
     * Initializes the GoogleApiClient and gets the Node ID of the connected device.
     */
    private void initApi() {
        client = getGoogleApiClient(this);
        retrieveDeviceNode();
    }

    /**
     * Sets up the button for handling click events.
     */
    private void setupWidgets() {

    }

    /**
     * Returns a GoogleApiClient that can access the Wear API.
     *
     * @param context
     * @return A GoogleApiClient that can make calls to the Wear API
     */
    private GoogleApiClient getGoogleApiClient(Context context) {
        return new GoogleApiClient.Builder(context)
                .addApi(Wearable.API)
                .build();
    }

    /**
     * Connects to the GoogleApiClient and retrieves the connected device's Node ID. If there are
     * multiple connected devices, the first Node ID is returned.
     */
    private void retrieveDeviceNode() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                client.blockingConnect(CONNECTION_TIME_OUT_MS, TimeUnit.MILLISECONDS);
                NodeApi.GetConnectedNodesResult result =
                        Wearable.NodeApi.getConnectedNodes(client).await();
                List<Node> nodes = result.getNodes();
                if (nodes.size() > 0) {
                    nodeId = nodes.get(0).getId();
                    if (data != null) {
                        if (!data.equals("")) {
                            progressBar.setVisibility(View.GONE);
                            status.setText(data);
                        }
                    }
                    else{
                        bookCab();
                    }
                }
                client.disconnect();
            }
        }).start();
    }

    private void bookCab() {
        if (nodeId != null) {
            Log.d("TEST","SSDSD1");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Log.d("TEST","SSDSD");
                    client.blockingConnect(CONNECTION_TIME_OUT_MS, TimeUnit.MILLISECONDS);
                    Wearable.MessageApi.sendMessage(client, nodeId, "book", null);
                    client.disconnect();
                }
            }).start();
        }
        else
        {
            Log.d("TEST","SSDSD3");
        }
    }
}
