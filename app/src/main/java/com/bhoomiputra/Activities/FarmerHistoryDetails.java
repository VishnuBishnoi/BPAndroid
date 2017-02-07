package com.bhoomiputra.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.bhoomiputra.R;

public class FarmerHistoryDetails extends AppCompatActivity implements View.OnClickListener
{

    Button repeatBtn, reviewBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_history_details);

        repeatBtn =(Button)findViewById(R.id.repeatBtn);
        reviewBtn =(Button)findViewById(R.id.reviewBtn);
        repeatBtn.setOnClickListener(this);
        reviewBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        if(id==R.id.repeatBtn){
            Intent intent = new Intent(getApplicationContext(), FarmerBookTool.class);
            startActivity(intent);
        }

        if(id==R.id.reviewBtn){
            Intent intent = new Intent(getApplicationContext(), FarmerBookingReview.class);
            startActivity(intent);
        }

    }
}
