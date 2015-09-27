package com.cepheuen.olahwa.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.cepheuen.olahwa.R;
import com.cepheuen.olahwa.models.BaseModel;
import com.cepheuen.olahwa.models.Category;
import com.cepheuen.olahwa.models.MusicListModel;
import com.cepheuen.olahwa.models.MusicRequestModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Thank bunny app
 * Created by Muthuramakrishnan on 9/27/2015.
 */
public class CabListAdapter extends BaseAdapter {
    private Context context;
    private List<Category> categories;
    private ViewHolder viewHolder;

    public CabListAdapter(Context context, List<Category> categories) {
        this.context = context;
        this.categories = categories;
    }

    @Override
    public int getCount() {
        return categories.size();
    }

    @Override
    public Category getItem(int position) {
        return categories.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.cab_item, null);
            viewHolder.carImg = (ImageView) convertView.findViewById(R.id.carImg);
            viewHolder.carType = (TextView) convertView.findViewById(R.id.carType);
            viewHolder.carTime = (TextView) convertView.findViewById(R.id.carTime);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        String att = "";
        if(categories.get(position).getEta() > 1)
        {
            att = "s";
        }
        Picasso.with(context).load(categories.get(position).getImage()).into(viewHolder.carImg);
        viewHolder.carTime.setText(categories.get(position).getEta() + " "  + categories.get(position).getTimeUnits() + att);
        viewHolder.carType.setText(categories.get(position).getDisplayName());
        return convertView;
    }

    private class ViewHolder {
        public ImageView carImg;
        public TextView carType, carTime;
    }
}