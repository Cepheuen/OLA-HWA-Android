package com.cepheuen.olahwa.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.cepheuen.olahwa.R;
import com.cepheuen.olahwa.adapters.DashboardAdapter;
import com.cepheuen.olahwa.adapters.MusicListAdapter;
import com.cepheuen.olahwa.api.OlaExtAPI;
import com.cepheuen.olahwa.models.DashboardModel;
import com.cepheuen.olahwa.models.MusicListModel;
import com.cepheuen.olahwa.models.MusicRequestModel;
import com.cepheuen.olahwa.utils.ConnectionDetector;
import com.cepheuen.olahwa.utils.Prefs;

public class DashFragment extends Fragment {

    private View view;
    private ListView listView;
    private DashboardAdapter dashboardAdapter;
    private View noCRN;
    private TextView exclm;
    private ProgressBar progressBar;
    private ConnectionDetector connectionDetector;

    public static DashFragment newInstance() {
        return new DashFragment();
    }

    public DashFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        connectionDetector = new ConnectionDetector(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = LayoutInflater.from(getActivity()).inflate(R.layout.leaderboard_layout, null);
        listView = (ListView) view.findViewById(R.id.list);
        noCRN = view.findViewById(R.id.noCRN);
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        exclm = (TextView) view.findViewById(R.id.exMsg);

        if (!connectionDetector.isConnectionAvailable()) {
            noCRN.setVisibility(View.VISIBLE);
            exclm.setText("No Internet Connection!");
            setHasOptionsMenu(false);
        } else {
            new FetchLeaderboardList().execute();
            setHasOptionsMenu(true);
        }

        return view;
    }

    private class FetchLeaderboardList extends AsyncTask<Void, Void, DashboardModel[]> {

        @Override
        protected void onPreExecute() {
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected DashboardModel[] doInBackground(Void... voids) {
            return OlaExtAPI.getPublicApiService().fetchLeaderboard();
        }

        @Override
        protected void onPostExecute(DashboardModel[] dashboardModels) {
            progressBar.setVisibility(View.INVISIBLE);
            if (dashboardModels != null) {
                dashboardAdapter = new DashboardAdapter(getActivity(), dashboardModels);
                listView.setAdapter(dashboardAdapter);
                listView.setHeaderDividersEnabled(false);
            }
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
