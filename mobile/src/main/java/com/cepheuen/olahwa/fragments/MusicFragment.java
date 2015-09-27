package com.cepheuen.olahwa.fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.cepheuen.olahwa.R;
import com.cepheuen.olahwa.adapters.MusicListAdapter;
import com.cepheuen.olahwa.api.OlaExtAPI;
import com.cepheuen.olahwa.models.MusicListModel;

public class MusicFragment extends Fragment {

    private View view;
    private ListView listView;
    private MusicListAdapter musicListAdapter;

    public static MusicFragment newInstance(String param1, String param2) {
        return new MusicFragment();
    }

    public MusicFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_music, null);
        listView = (ListView) view.findViewById(R.id.songs_container);

        return view;
    }

    private class FetchMusicList extends AsyncTask<Void, Void, MusicListModel[]> {

        @Override
        protected MusicListModel[] doInBackground(Void... voids) {
            return OlaExtAPI.getPublicApiService().fetchMusic();
        }

        @Override
        protected void onPostExecute(MusicListModel[] musicListModels) {
            if (musicListModels != null) {
                musicListAdapter = new MusicListAdapter(getActivity(), musicListModels);
                listView.setAdapter(musicListAdapter);
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
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_done:
                System.exit(1);
                break;
        }
        return true;
    }
}
