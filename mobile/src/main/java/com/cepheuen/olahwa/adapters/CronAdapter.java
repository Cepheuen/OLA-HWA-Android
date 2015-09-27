package com.cepheuen.olahwa.adapters;

import android.app.TimePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;

import com.cepheuen.olahwa.R;
import com.cepheuen.olahwa.models.CronModel;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Muthuramakrishnan on 9/27/2015.
 */
public class CronAdapter extends BaseAdapter {
    private Context context;
    private List<CronModel> cronModels;
    private ViewHolder viewHolder;

    public CronAdapter(Context context, List<CronModel> cronModels) {
        this.context = context;
        this.cronModels = cronModels;
    }

    @Override
    public int getCount() {
        return cronModels.size();
    }

    @Override
    public CronModel getItem(int position) {
        return cronModels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.cron_item, null);
            viewHolder.time = (TextView) convertView.findViewById(R.id.time);
            viewHolder.mo = (TextView) convertView.findViewById(R.id.mo);
            viewHolder.tu = (TextView) convertView.findViewById(R.id.tu);
            viewHolder.we = (TextView) convertView.findViewById(R.id.we);
            viewHolder.th = (TextView) convertView.findViewById(R.id.th);
            viewHolder.fr = (TextView) convertView.findViewById(R.id.fr);
            viewHolder.sa = (TextView) convertView.findViewById(R.id.sa);
            viewHolder.su = (TextView) convertView.findViewById(R.id.su);
            viewHolder.mo.setTag("mo");
            viewHolder.tu.setTag("tu");
            viewHolder.we.setTag("we");
            viewHolder.th.setTag("th");
            viewHolder.fr.setTag("fr");
            viewHolder.sa.setTag("sa");
            viewHolder.su.setTag("su");
            viewHolder.toggle = (Switch) convertView.findViewById(R.id.toggle);
            viewHolder.source = (EditText) convertView.findViewById(R.id.from);
            viewHolder.dest = (EditText) convertView.findViewById(R.id.to);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        String regex = "^[\u0400-\u04FFa-zA-Z ]+(,[\u0400-\u04FFa-zA-Z ]+)*$";
        if (cronModels.get(position).getDays() != null && !cronModels.get(position).getDays().contains("[") && cronModels.get(position).getDays().matches(regex)) {
            String[] texts = cronModels.get(position).getDays().replace(" ", "").split(",");
            for (String text : texts) {
                ((TextView) convertView.findViewWithTag(text)).setTextColor(Color.parseColor("#448AFF"));
            }
        }

        viewHolder.time.setText(cronModels.get(position).getTime());

        viewHolder.mo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (((TextView) view).getCurrentTextColor() == Color.parseColor("#448AFF")) {
                    ((TextView) view).setTextColor(Color.parseColor("#515151"));
                } else {
                    ((TextView) view).setTextColor(Color.parseColor("#448AFF"));
                }
            }
        });
        viewHolder.tu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (((TextView) view).getCurrentTextColor() == Color.parseColor("#448AFF")) {
                    ((TextView) view).setTextColor(Color.parseColor("#515151"));
                } else {
                    ((TextView) view).setTextColor(Color.parseColor("#448AFF"));
                }
            }
        });
        viewHolder.we.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (((TextView) view).getCurrentTextColor() == Color.parseColor("#448AFF")) {
                    ((TextView) view).setTextColor(Color.parseColor("#515151"));
                } else {
                    ((TextView) view).setTextColor(Color.parseColor("#448AFF"));
                }
            }
        });
        viewHolder.th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (((TextView) view).getCurrentTextColor() == Color.parseColor("#448AFF")) {
                    ((TextView) view).setTextColor(Color.parseColor("#515151"));
                } else {
                    ((TextView) view).setTextColor(Color.parseColor("#448AFF"));
                }
            }
        });
        viewHolder.fr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (((TextView) view).getCurrentTextColor() == Color.parseColor("#448AFF")) {
                    ((TextView) view).setTextColor(Color.parseColor("#515151"));
                } else {
                    ((TextView) view).setTextColor(Color.parseColor("#448AFF"));
                }
            }
        });
        viewHolder.sa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (((TextView) view).getCurrentTextColor() == Color.parseColor("#448AFF")) {
                    ((TextView) view).setTextColor(Color.parseColor("#515151"));
                } else {
                    ((TextView) view).setTextColor(Color.parseColor("#448AFF"));
                }
            }
        });
        viewHolder.su.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (((TextView) view).getCurrentTextColor() == Color.parseColor("#448AFF")) {
                    ((TextView) view).setTextColor(Color.parseColor("#515151"));
                } else {
                    ((TextView) view).setTextColor(Color.parseColor("#448AFF"));
                }
            }
        });

        viewHolder.toggle.setChecked(cronModels.get(position).isEnabled());

        viewHolder.time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        ((TextView) v).setText(selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();
            }
        });

        viewHolder.source.setText(cronModels.get(position).getSourceText());
        viewHolder.dest.setText(cronModels.get(position).getDestText());
        return convertView;
    }

    private class ViewHolder {
        public TextView time, su, mo, tu, we, th, fr, sa;
        public Switch toggle;
        public EditText source, dest;
    }
}