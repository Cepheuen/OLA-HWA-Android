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
import android.widget.Toast;

import com.cepheuen.olahwa.R;
import com.cepheuen.olahwa.adapters.MusicListAdapter;
import com.cepheuen.olahwa.api.OlaExtAPI;
import com.cepheuen.olahwa.models.MusicListModel;
import com.cepheuen.olahwa.models.MusicRequestModel;
import com.cepheuen.olahwa.utils.ConnectionDetector;
import com.cepheuen.olahwa.utils.Prefs;

public class MusicFragment extends Fragment {

    private View view;
    private ListView listView;
    private MusicListAdapter musicListAdapter;
    private View noCRN;
    private TextView exclm;
    private ProgressBar progressBar;
    private MusicRequestModel musicRequestModel;
    private ConnectionDetector connectionDetector;

    public static MusicFragment newInstance() {
        return new MusicFragment();
    }

    public MusicFragment() {
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
        view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_list, null);
        listView = (ListView) view.findViewById(R.id.list_container);
        noCRN = view.findViewById(R.id.noCRN);
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        exclm = (TextView) view.findViewById(R.id.exMsg);

        if (!connectionDetector.isConnectionAvailable()) {
            noCRN.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.INVISIBLE);
            exclm.setText("No Internet Connection!");
            setHasOptionsMenu(false);
        } else if (Prefs.with(getActivity()).getString("crn", null) == null) {
            noCRN.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.INVISIBLE);
            setHasOptionsMenu(false);
        } else {
            noCRN.setVisibility(View.INVISIBLE);
            new FetchMusicList().execute();
            setHasOptionsMenu(true);
        }

        return view;
    }

    private class FetchMusicList extends AsyncTask<Void, Void, MusicListModel[]> {

        @Override
        protected void onPreExecute() {
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected MusicListModel[] doInBackground(Void... voids) {
            return OlaExtAPI.getPublicApiService().fetchMusic();
        }

        @Override
        protected void onPostExecute(MusicListModel[] musicListModels) {
            progressBar.setVisibility(View.INVISIBLE);
            if (musicListModels != null) {
                musicListAdapter = new MusicListAdapter(getActivity(), musicListModels);
                listView.setAdapter(musicListAdapter);
                listView.setHeaderDividersEnabled(false);
            }
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_music, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!connectionDetector.isConnectionAvailable()) {
            noCRN.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.INVISIBLE);
            exclm.setText("No Internet Connection!");
            setHasOptionsMenu(false);
        } else if (Prefs.with(getActivity()).getString("crn", null) == null) {
            noCRN.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.INVISIBLE);
            setHasOptionsMenu(false);
        } else {
            noCRN.setVisibility(View.INVISIBLE);
            new FetchMusicList().execute();
            setHasOptionsMenu(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_done:
                musicRequestModel = musicListAdapter.getFinalList();
                Toast.makeText(getActivity(), "Sent!", Toast.LENGTH_LONG).show();
                break;
        }
        return true;
    }
}
