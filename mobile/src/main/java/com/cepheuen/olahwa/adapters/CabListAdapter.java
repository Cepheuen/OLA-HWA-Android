package com.cepheuen.olahwa.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cepheuen.olahwa.R;
import com.cepheuen.olahwa.models.Category;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
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
            viewHolder.carExtra = (TextView) convertView.findViewById(R.id.carExtra);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        String att = "";
        if (categories.get(position).getEta() > 1) {
            att = categories.get(position).getEta() + " " + categories.get(position).getTimeUnits() + "s";
        } else if (categories.get(position).getEta() == 1) {
            att = categories.get(position).getEta() + " " + categories.get(position).getTimeUnits();
        } else {
            att = "No cabs available";
        }

        Picasso.with(context).load(categories.get(position).getImage()).into(viewHolder.carImg);
        viewHolder.carTime.setText(att);
        viewHolder.carType.setText(categories.get(position).getDisplayName());
        if (categories.get(position).getFareBreakup() != null) {
            viewHolder.carExtra.setText("Base Fare : ₹" + categories.get(position).getFareBreakup().get(0).getBaseFare());
            if (categories.get(position).getFareBreakup().get(0).getSurcharge() != null) {
                viewHolder.carExtra.setText(viewHolder.carExtra.getText() + " | Surcharge : " + categories.get(position).getFareBreakup().get(0).getSurcharge().get(0).getValue() + "x");
            }
        } else {
            viewHolder.carExtra.setText("N/A");
        }

        return convertView;
    }

    private class ViewHolder {
        public ImageView carImg;
        public TextView carType, carTime, carExtra;
    }
}