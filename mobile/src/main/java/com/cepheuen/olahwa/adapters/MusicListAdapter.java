package com.cepheuen.olahwa.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.cepheuen.olahwa.R;
import com.cepheuen.olahwa.models.MusicListModel;
import com.cepheuen.olahwa.models.MusicRequestModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Muthuramakrishnan on 9/27/2015.
 */
public class MusicListAdapter extends BaseAdapter {
    private Context context;
    private MusicListModel[] musicListModels;
    private ViewHolder viewHolder;

    public MusicListAdapter(Context context, MusicListModel[] musicListModels) {
        this.context = context;
        this.musicListModels = musicListModels;
    }

    @Override
    public int getCount() {
        return musicListModels.length;
    }

    public MusicRequestModel getFinalList() {
        MusicRequestModel musicRequestModel = new MusicRequestModel();
        List<MusicListModel> finalList = new ArrayList<>();

        for (MusicListModel musicListModel : musicListModels) {
            if (musicListModel.isSelected())
                finalList.add(musicListModel);
        }

        musicRequestModel.setSongs(finalList);
        return musicRequestModel;
    }

    @Override
    public MusicListModel getItem(int position) {
        return musicListModels[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, null);
            viewHolder.songName = (TextView) convertView.findViewById(R.id.song_name);
            viewHolder.checkBox = (CheckBox) convertView.findViewById(R.id.song_check);
            viewHolder.checkBox.setTag(position);
            convertView.setTag(viewHolder);
            viewHolder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton vw, boolean isChecked) {
                    int getPosition = (Integer) vw.getTag();
                    musicListModels[getPosition].setSelected(vw.isChecked());
                }
            });
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.songName.setText(musicListModels[position].getSongName());
        return convertView;
    }

    private class ViewHolder {
        public TextView songName;
        public CheckBox checkBox;
    }
}