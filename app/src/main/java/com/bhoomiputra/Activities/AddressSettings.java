package com.bhoomiputra.Activities;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatRadioButton;
import android.widget.ListView;
import android.widget.TextView;

import com.bhoomiputra.Adapters.AddressesListAdapter;
import com.bhoomiputra.Model.Address;
import com.bhoomiputra.R;

import java.util.ArrayList;

public class AddressSettings extends AppCompatActivity {

    TextView textView;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_settings);

       // initRadioButtonTint();

        textView=(TextView)findViewById(R.id.textView39);
        listView=(ListView)findViewById(R.id.listView);

        ArrayList<Address>list=new ArrayList<>();
        String address="#2243 Gali no 3, Dhani Mohabatpur, Mandi Adampur,Hisar, Haryana 125052";
        Address address1=new Address("Nand Kishore","9466336287",address);
        Address address2=new Address("Vishnu","9729415933",address);
        Address address3=new Address("Sanjeev","8904685821",address);
        list.add(address1);
        list.add(address2);
        list.add(address3);

        textView.setText("Found "+list.size()+" address");

        AddressesListAdapter adapter=new AddressesListAdapter(this,list);
        listView.setAdapter(adapter);
    }

    public void initRadioButtonTint(){
        AppCompatRadioButton rb;
        rb = new AppCompatRadioButton(getApplicationContext());
        ColorStateList colorStateList = new ColorStateList(
                new int[][]{
                        new int[]{-android.R.attr.state_checked},
                        new int[]{android.R.attr.state_checked}
                },
                new int[]{

                        Color.BLACK
                        , Color.rgb (0,0,0),
                }
        );
        rb.setSupportButtonTintList(colorStateList);
    }
}
