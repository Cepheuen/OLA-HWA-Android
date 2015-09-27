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
import com.cepheuen.olahwa.models.DashboardModel;
import com.cepheuen.olahwa.models.MusicListModel;
import com.cepheuen.olahwa.models.MusicRequestModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Muthuramakrishnan on 9/27/2015.
 */
public class DashboardAdapter extends BaseAdapter {
    private Context context;
    private DashboardModel[] dashboardModels;
    private ViewHolder viewHolder;

    public DashboardAdapter(Context context, DashboardModel[] dashboardModels) {
        this.context = context;
        this.dashboardModels = dashboardModels;
    }

    @Override
    public int getCount() {
        return dashboardModels.length;
    }

    @Override
    public DashboardModel getItem(int position) {
        return dashboardModels[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.leader_item, null);
            viewHolder.name = (TextView) convertView.findViewById(R.id.name);
            viewHolder.points = (TextView) convertView.findViewById(R.id.points);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if (!dashboardModels[position].getFullname().equals("Bruce Wayne")) {
            viewHolder.name.setText(dashboardModels[position].getFullname());
        } else {
            viewHolder.name.setText("You");
        }
        viewHolder.points.setText(dashboardModels[position].getPoints() + " points");

        return convertView;
    }

    private class ViewHolder {
        public TextView name, points;
    }
}