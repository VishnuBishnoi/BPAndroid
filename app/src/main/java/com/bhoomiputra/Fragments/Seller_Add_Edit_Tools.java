package com.bhoomiputra.Fragments;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.bhoomiputra.Activities.SellerAddNewTool;
import com.bhoomiputra.Adapters.SellerToolsAdapter;
import com.bhoomiputra.R;

public class Seller_Add_Edit_Tools extends android.app.Fragment implements View.OnClickListener {
    View rootView;
    Button addNewToolBtn;
    ListView listView;

    public Seller_Add_Edit_Tools(){}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_seller__add__edit__tools, container, false);
        listView = (ListView) rootView.findViewById(R.id.listView3);

        SellerToolsAdapter adapter=new SellerToolsAdapter(getActivity().getApplicationContext());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
                final CharSequence[] items = {"Edit", "Remove"};

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Make your selection");
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int index) {
                        if(index == 0){
                            Intent intent=new Intent(getActivity(), SellerAddNewTool.class);
                            startActivity(intent);
                        }
                        else if(index == 1){
                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                            builder.setMessage("Do you really want to remove ?").setPositiveButton("Yes", dialogClickListener)
                                    .setNegativeButton("No", dialogClickListener).show();
                        }
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        addNewToolBtn = (Button) rootView.findViewById(R.id.button9);
        addNewToolBtn.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        if(id==R.id.button9){
            Intent intent=new Intent(getActivity(), SellerAddNewTool.class);
            startActivity(intent);
        }
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
