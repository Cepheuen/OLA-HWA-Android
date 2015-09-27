package com.cepheuen.olahwa.fragments;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.cepheuen.olahwa.R;
import com.cepheuen.olahwa.adapters.CabListAdapter;
import com.cepheuen.olahwa.api.OlaAPI;
import com.cepheuen.olahwa.models.BaseModel;
import com.cepheuen.olahwa.utils.ConnectionDetector;


public class BookingFragment extends Fragment implements LocationListener {

    private View view;
    private ListView listView;
    private CabListAdapter cabListAdapter;
    private View noCRN;
    private TextView exclm;
    private ProgressBar progressBar;
    private ConnectionDetector connectionDetector;
    private Location location;
    private LocationManager mLocationManager;

    public static BookingFragment newInstance() {
        return new BookingFragment();
    }

    public BookingFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        connectionDetector = new ConnectionDetector(getActivity());
        mLocationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_list, null);
        listView = (ListView) view.findViewById(R.id.list_container);
        exclm = (TextView) view.findViewById(R.id.exMsg);
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        noCRN = view.findViewById(R.id.noCRN);

        if (connectionDetector.isConnectionAvailable()) {
            noCRN.setVisibility(View.VISIBLE);
            exclm.setText("No Internet Connection!");
        } else {
            noCRN.setVisibility(View.INVISIBLE);
            try {
                mLocationManager.requestSingleUpdate(LocationManager.NETWORK_PROVIDER, this, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return view;
    }

    @Override
    public void onLocationChanged(Location location) {
        this.location = location;
        new FetchCabList().execute();
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

    private class FetchCabList extends AsyncTask<Void, Void, BaseModel> {

        @Override
        protected void onPreExecute() {
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected BaseModel doInBackground(Void... voids) {
            return OlaAPI.getPublicApiService().checkAvailability(String.valueOf(location.getLatitude()), String.valueOf(location.getLongitude()), "sedan");
        }

        @Override
        protected void onPostExecute(BaseModel baseModel) {
            progressBar.setVisibility(View.INVISIBLE);
            if (baseModel != null) {
                cabListAdapter = new CabListAdapter(getActivity(), baseModel.getCategories());
                listView.setAdapter(cabListAdapter);
                listView.setHeaderDividersEnabled(false);
            }
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
