package com.bhoomiputra.Fragments;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.bhoomiputra.Activities.AddressSettings;
import com.bhoomiputra.Activities.ProfileSettings;
import com.bhoomiputra.Adapters.SettingsListAdapter;
import com.bhoomiputra.Model.FarmerSettingsAdapterHelper;
import com.bhoomiputra.R;

import java.util.ArrayList;

public class FarmerSettings extends Fragment implements View.OnClickListener {
    View rootView;
    Button start;
   LinearLayout profileLL;
    ListView listView;

    public FarmerSettings(){}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_farmer_settings, container, false);
        listView = (ListView) rootView.findViewById(R.id.listView2);

        ArrayList<FarmerSettingsAdapterHelper> list = new ArrayList<>();
        Drawable d = ResourcesCompat.getDrawable(getResources(), R.drawable.farming0, null);
        FarmerSettingsAdapterHelper tempobj0=new FarmerSettingsAdapterHelper("Profile",d);
        FarmerSettingsAdapterHelper tempobj1=new FarmerSettingsAdapterHelper("Address",d);
        FarmerSettingsAdapterHelper tempobj2=new FarmerSettingsAdapterHelper("Temp",d);
        list.add(tempobj0);
        list.add(tempobj1);
        list.add(tempobj2);


        SettingsListAdapter adapter=new SettingsListAdapter(getActivity().getApplicationContext(),list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Intent intent=new Intent(getActivity(), ProfileSettings.class);
                    startActivity(intent);
                }
                if(position==1){
                    Intent intent=new Intent(getActivity(), AddressSettings.class);
                    startActivity(intent);
                }
            }
        });
        return rootView;
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
    }
}
