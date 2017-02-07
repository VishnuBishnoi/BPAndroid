package com.bhoomiputra.Adapters;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bhoomiputra.Activities.Edit_or_Add_address;
import com.bhoomiputra.Model.Address;
import com.bhoomiputra.Model.Seller;
import com.bhoomiputra.R;

import java.util.ArrayList;

/**
 * Created by h149056 on 7/15/2016.
 */
public class AddressesListAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Address> list;
    RelativeLayout adControls;
    static int selectedPosition =0;
    Animation slidedown;

    public AddressesListAdapter(Context context, ArrayList<Address> list){
        this.context = context;
        this.list = list;
        slidedown = AnimationUtils.loadAnimation(context, R.anim.slide_down);
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.addresses_listview_layout, null);
        }


        ImageView remove = (ImageView) convertView.findViewById(R.id.remove);
        ImageView edit = (ImageView) convertView.findViewById(R.id.edit);
        ImageView makedefault = (ImageView) convertView.findViewById(R.id.makedefalut);
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("Do you really want to remove ?").setPositiveButton("Yes", dialogClickListener)
                        .setNegativeButton("No", dialogClickListener).show();
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, Edit_or_Add_address.class);
                context.startActivity(intent);
            }
        });

        makedefault.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("---->>","make default at:"+position);
            }
        });

        TextView usernameTV = (TextView) convertView.findViewById(R.id.textView5);
        TextView mobileTV = (TextView) convertView.findViewById(R.id.textView6);
        TextView addressTV = (TextView) convertView.findViewById(R.id.addressTV);

        usernameTV.setText(list.get(position).user_name);
        mobileTV.setText(list.get(position).mobile_no);
        addressTV.setText(list.get(position).address);


         adControls=(RelativeLayout)convertView.findViewById(R.id.adControls);
         adControls.setVisibility(View.GONE);
        if(position == selectedPosition){
            adControls.setVisibility(View.VISIBLE);
            adControls.startAnimation(slidedown);
            adControls.setTag(position);
        }


        RadioButton radioBtn = (RadioButton) convertView.findViewById(R.id.radioButton);
        radioBtn.setChecked(position == selectedPosition);
        radioBtn.setTag(position);
        radioBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // adControls.setTag(position);
                selectedPosition = (Integer) view.getTag();
                notifyDataSetChanged();
            }
        });

        return convertView;
    }

    DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which){
                case DialogInterface.BUTTON_POSITIVE:
                    Log.e("-------","-->>yes clicked");
                    break;

                case DialogInterface.BUTTON_NEGATIVE:
                    Log.e("-------","-->>no clicked");
                    break;
            }
        }
    };

}
