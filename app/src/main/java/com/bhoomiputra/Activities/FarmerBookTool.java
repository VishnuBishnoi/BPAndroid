package com.bhoomiputra.Activities;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.ListView;

import com.bhoomiputra.R;
import com.bhoomiputra.Util.MultiSelectSpinner;

import java.util.Calendar;
import java.util.List;

public class FarmerBookTool extends AppCompatActivity implements View.OnClickListener {

    ImageView plus,minus;
    Button landBtn,datePickerBtn;
    static int LAND=1;
    StartDateDialogFragment startDatepicker;

    final Calendar c = Calendar.getInstance();
    int Year = c.get(Calendar.YEAR);
    int Month = c.get(Calendar.MONTH)+1;
    int Day = c.get(Calendar.DAY_OF_MONTH);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_tool);

        plus=(ImageView)findViewById(R.id.plus);
        minus=(ImageView)findViewById(R.id.minus);
        landBtn=(Button)findViewById(R.id.landBtn);
        datePickerBtn=(Button)findViewById(R.id.datePickerBtn);

        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        datePickerBtn.setOnClickListener(this);

        String[] strings = { "Red", "Blue", "Green" };

        MultiSelectSpinner mySpin = (MultiSelectSpinner)findViewById(R.id.toolsSpin);
        mySpin.setItems(strings);
        mySpin.setSelection(strings);


        List<String> selected = mySpin.getSelectedStrings();
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        if(id==R.id.plus){
            LAND++;
            landBtn.setText("LAND: "+LAND+" acrs");}
        if(id==R.id.minus){
            if(LAND==1){}
            else{ LAND--;}
            landBtn.setText("LAND: "+LAND+" acrs");}

        if(id==R.id.datePickerBtn){
            startDatepicker = new StartDateDialogFragment();
            startDatepicker.show(getSupportFragmentManager(), "showDate");
        }
    }

    public class StartDateDialogFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener{

        public StartDateDialogFragment()
        {
        }
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            Calendar cal=Calendar.getInstance();
            int year=cal.get(Calendar.YEAR);
            int month=cal.get(Calendar.MONTH);
            int day=cal.get(Calendar.DAY_OF_MONTH);
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            Log.e("","Year:"+year+" month:"+monthOfYear+"day:"+dayOfMonth);
            datePickerBtn.setText(dayOfMonth+"-"+monthOfYear+"-"+year);
        }

    }


}
