package com.bhoomiputra.Fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.bhoomiputra.Activities.FarmerHistoryDetails;
import com.bhoomiputra.Adapters.FarmerHistoryAdapter;
import com.bhoomiputra.Model.Seller;
import com.bhoomiputra.R;

import java.util.ArrayList;

public class FarmerOrderHistroy extends Fragment {

    View rootView;
    ListView historyListView;

    public FarmerOrderHistroy(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_farmer_order_histroy, container, false);
        historyListView =(ListView)rootView.findViewById(R.id.listView);

        ArrayList<Seller> sellers=new ArrayList<>();
        Seller seller1=new Seller();
        seller1.user_name="Nand Kishore";
        seller1.mobile_no="8904685821";
        seller1.address="#2243 Gali no 3, Dhani Mohabatpur, Mandi Adampur,Hisar, Haryana 125052";
        seller1.charge="Rs. 234/hrs";

        sellers.add(seller1);

        FarmerHistoryAdapter adapter=new FarmerHistoryAdapter(getActivity().getApplicationContext(),sellers);
        historyListView.setAdapter(adapter);

        historyListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity().getApplicationContext(), FarmerHistoryDetails.class);
                startActivity(intent);
            }
        });

        return rootView;
    }
}
