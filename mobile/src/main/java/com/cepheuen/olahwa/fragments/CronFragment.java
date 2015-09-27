package com.cepheuen.olahwa.fragments;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.cepheuen.olahwa.R;
import com.cepheuen.olahwa.adapters.CronAdapter;
import com.cepheuen.olahwa.models.CronModel;
import com.cepheuen.olahwa.utils.ConnectionDetector;
import com.cepheuen.olahwa.utils.Prefs;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;


public class CronFragment extends Fragment implements LocationListener {

    private View view;
    private ListView listView;
    private CronAdapter cronAdapter;
    private TextView exclm;
    private ProgressBar progressBar;
    private ConnectionDetector connectionDetector;
    private Location location;
    private LocationManager mLocationManager;
    private Gson gson;

    public static CronFragment newInstance() {
        return new CronFragment();
    }

    public CronFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        setHasOptionsMenu(true);
        gson = new Gson();
        connectionDetector = new ConnectionDetector(getActivity());
        mLocationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = LayoutInflater.from(getActivity()).inflate(R.layout.cron_layout, null);
        listView = (ListView) view.findViewById(R.id.list_container);
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        exclm = (TextView) view.findViewById(R.id.no_cron);
        new FetchCronList().execute();
        return view;
    }

    @Override
    public void onLocationChanged(Location location) {
        this.location = location;
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

    private class FetchCronList extends AsyncTask<Void, Void, List<CronModel>> {

        @Override
        protected void onPreExecute() {
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected List<CronModel> doInBackground(Void... voids) {
            List<CronModel> cronModels = new ArrayList<>();
            int total = Prefs.with(getActivity()).getInt("cron_cnt", 0);
            for (int i = 0; i < total; i++) {
                String data = Prefs.with(getActivity()).getString("cron" + i, null);
                if (data != null) {
                    CronModel cronModel = gson.fromJson(data, CronModel.class);
                    cronModels.add(cronModel);
                }
            }
            return cronModels;
        }

        @Override
        protected void onPostExecute(List<CronModel> cronModels) {
            progressBar.setVisibility(View.INVISIBLE);
            if (cronModels != null) {
                if (cronModels.size() > 0)
                    exclm.setVisibility(View.INVISIBLE);
                cronAdapter = new CronAdapter(getActivity(), cronModels);
                listView.setAdapter(cronAdapter);
                listView.setHeaderDividersEnabled(false);
                listView.setDivider(null);
                listView.setDividerHeight(20);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    }
                });
            }
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_cron, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_done:
                for (int i = 0; i < listView.getAdapter().getCount(); i++) {
                    View view = listView.getChildAt(i);
                    CronModel model = new CronModel();
                    String daysStr = "";
                    int ctr = 0;
                    model.setTime(((TextView) view.findViewById(R.id.time)).getText().toString());
                    model.setEnabled(((Switch) view.findViewById(R.id.toggle)).isChecked());
                    model.setSourceText(((EditText) view.findViewById(R.id.from)).getText().toString());
                    model.setDestText(((EditText) view.findViewById(R.id.to)).getText().toString());
                    LinearLayout layout = (LinearLayout) view.findViewById(R.id.days);
                    for (int j = 0; j < layout.getChildCount(); j++) {
                        View v = layout.getChildAt(j);
                        if (((TextView) v).getCurrentTextColor() == Color.parseColor("#448AFF")) {
                            Log.d("SDSD", v.getTag().toString());
                            if (ctr == 0) {
                                daysStr = v.getTag().toString();
                                ctr++;
                            } else
                                daysStr = daysStr + "," + v.getTag().toString();
                        }
                        else {
                            Log.d("SDSD","not selected");
                        }

                    }
                    Log.d("SDADFE", daysStr);
                    model.setDays(daysStr);
                    Prefs.with(getActivity()).save("cron" + i, gson.toJson(model));
                }
                Prefs.with(getActivity()).save("cron_cnt", listView.getAdapter().getCount());
                Toast.makeText(getActivity(),"Saved!", Toast.LENGTH_LONG).show();
                break;

            case R.id.action_add:
                int curr = Prefs.with(getActivity()).getInt("cron_cnt", 0);
                CronModel model = new CronModel();
                model.setTime("22:10");
                model.setDays("mo,tu,we");
                model.setEnabled(true);
                model.setDestText("Guindy");
                model.setSourceText("TNagar");
                Prefs.with(getActivity()).save("cron" + curr, gson.toJson(model));
                Prefs.with(getActivity()).save("cron_cnt", curr + 1);
                new FetchCronList().execute();
                break;
        }
        return true;
    }
}
