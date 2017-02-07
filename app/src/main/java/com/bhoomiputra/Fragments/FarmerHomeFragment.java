package com.bhoomiputra.Fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.bhoomiputra.Activities.FarmerBookTool;
import com.bhoomiputra.Adapters.SellersListAdapter;
import com.bhoomiputra.Model.Seller;
import com.bhoomiputra.R;

import java.util.ArrayList;

public class FarmerHomeFragment extends Fragment implements View.OnClickListener{
	View rootView;
    Button start;
	public FarmerHomeFragment(){}
    ListView listView;
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
         rootView = inflater.inflate(R.layout.fragment_home, container, false);
        listView=(ListView)rootView.findViewById(R.id.sellerListView);

        ArrayList<Seller> sellers=new ArrayList<>();
        Seller seller1=new Seller();
        seller1.user_name="Nand Kishore";
        seller1.mobile_no="8904685821";
        seller1.address="#2243 Gali no 3, Dhani Mohabatpur, Mandi Adampur,Hisar, Haryana 125052";
        seller1.charge="Rs. 234/hrs";

        Seller seller2=new Seller();
        seller2.user_name="Vishnu Dutt";
        seller2.mobile_no="9466336287";
        seller2.address="#2243 Gali no 3, Dhani Mohabatpur, Mandi Adampur,Hisar, Haryana 125052";
        seller2.charge="Rs. 432/hrs";
        sellers.add(seller1);
        sellers.add(seller2);
        SellersListAdapter adapter=new SellersListAdapter(getActivity().getApplicationContext(),sellers);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity().getApplicationContext(),FarmerBookTool.class);
                startActivity(intent);
            }
        });
         
        return rootView;
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
    }
}
