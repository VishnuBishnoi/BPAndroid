package com.bhoomiputra.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bhoomiputra.Model.NavDrawerItem;
import com.bhoomiputra.Model.Seller;
import com.bhoomiputra.R;

import java.util.ArrayList;

/**
 * Created by H149056 on 6/28/2016.
 */
public class SellersListAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Seller> list;

        public SellersListAdapter(Context context, ArrayList<Seller> list){
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
                convertView = mInflater.inflate(R.layout.listview_row_for_tool_provider, null);
            }

            ImageView imgIcon = (ImageView) convertView.findViewById(R.id.imageView1);
            TextView usernameTV = (TextView) convertView.findViewById(R.id.usernameTV);
            TextView mobileTV = (TextView) convertView.findViewById(R.id.mobileTV);
            TextView addressTV = (TextView) convertView.findViewById(R.id.addressTV);

            TextView chargeTV = (TextView) convertView.findViewById(R.id.chargeTV);
            RatingBar ratingBar = (RatingBar) convertView.findViewById(R.id.listitemrating);
            //TextView txtCount = (TextView) convertView.findViewById(R.id.counter);

            imgIcon.setImageResource(R.drawable.farming4);
            usernameTV.setText(list.get(position).user_name);
            mobileTV.setText(list.get(position).mobile_no);
            addressTV.setText(list.get(position).address);
            chargeTV.setText(list.get(position).charge);
            ratingBar.setRating(2.0f);

            return convertView;
        }

}
