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

import com.bhoomiputra.Model.Seller;
import com.bhoomiputra.R;

import java.util.ArrayList;

/**
 * Created by H149056 on 7/10/2016.
 */
public class SellerToolsAdapter extends BaseAdapter {
    private Context context;
   // private ArrayList<Seller> list;

    public SellerToolsAdapter(Context context){
        this.context = context;
      //  this.list = list;
    }

    @Override
    public int getCount() {
        return 8;
    }

    @Override
    public Object getItem(int position) {
        return 1;
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
            convertView = mInflater.inflate(R.layout.seller_tools_listview_layout, null);
        }

       // ImageView imgIcon = (ImageView) convertView.findViewById(R.id.imageView1);
        TextView toolname = (TextView) convertView.findViewById(R.id.textView29);
        TextView category = (TextView) convertView.findViewById(R.id.textView30);
        TextView charge = (TextView) convertView.findViewById(R.id.textView31);

       // imgIcon.setImageResource(R.drawable.farming4);
      /*  toolname.setText(list.get(position).user_name);
        category.setText(list.get(position).mobile_no);
        charge.setText(list.get(position).address);*/

        return convertView;
    }

}
