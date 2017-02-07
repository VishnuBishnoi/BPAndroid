package com.bhoomiputra.Adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bhoomiputra.Model.FarmerSettingsAdapterHelper;
import com.bhoomiputra.Model.Seller;
import com.bhoomiputra.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by h149056 on 7/8/2016.
 */
public class SettingsListAdapter  extends BaseAdapter {
    private Context context;
    private ArrayList<FarmerSettingsAdapterHelper> list;

    public SettingsListAdapter(Context context, ArrayList<FarmerSettingsAdapterHelper> list){
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.farmersettings_listview_layout, null);
        }

        ImageView imgIcon = (ImageView) convertView.findViewById(R.id.iconIV);
        TextView name = (TextView) convertView.findViewById(R.id.textView27);


        imgIcon.setImageDrawable(list.get(position).icon);
        name.setText(list.get(position).name);

        return convertView;
    }

}
