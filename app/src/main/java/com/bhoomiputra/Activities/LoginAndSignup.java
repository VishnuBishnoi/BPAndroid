package com.bhoomiputra.Activities;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bhoomiputra.R;

import java.util.ArrayList;

public class LoginAndSignup extends Activity implements View.OnClickListener {


    /** Called when the activity is first created. */
    //private Integer images[] = {R.drawable.farming8, R.drawable.farming5, R.drawable.farming9, R.drawable.farming10, R.drawable.farming7};
    ImageView imageView;
    LinearLayout imageGallery;
    HorizontalScrollView ScrollView;
    ArrayList<Bitmap>resizedList=new ArrayList<>();
    static int indexer=0;

    EditText username,password;

    Spinner loginAsSpinner, registerAsSpinner,stateSpinner,districtSpinner,tehSpinner;

    ImageView profilePicImageView;

    Animation fadeout;
    Animation lefttoright;
    Button login,registerBtn;
    TextView link_newuser,link_olduser;
    android.widget.ScrollView signup_scrollView;
    RelativeLayout login_relativelayoutView;

    private static int RESULT_LOAD_IMG = 1;
    String imgDecodableString;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_and_signup);

        ScrollView=(HorizontalScrollView) findViewById(R.id.scrollView);
        imageGallery = (LinearLayout) findViewById(R.id.imageGallery);

        profilePicImageView=(ImageView) findViewById(R.id.profilePicImageView);
        profilePicImageView.setOnClickListener(this);

        signup_scrollView=(android.widget.ScrollView) findViewById(R.id.scrollView2);
        login_relativelayoutView=(RelativeLayout) findViewById(R.id.loginRL);

        username=(EditText)findViewById(R.id.editText2);
        password=(EditText)findViewById(R.id.editText);

        login=(Button)findViewById(R.id.button7);
        registerBtn=(Button)findViewById(R.id.registerBtn);
        login.setOnClickListener(this);
        registerBtn.setOnClickListener(this);

        link_newuser=(TextView)findViewById(R.id.link_newuserTV);
        link_olduser=(TextView)findViewById(R.id.link_olduserTV);

        link_newuser.setOnClickListener(this);
        link_olduser.setOnClickListener(this);

       initializeSpinners();


        lefttoright = AnimationUtils.loadAnimation(this, R.anim.animation_left);
        fadeout = AnimationUtils.loadAnimation(this, R.anim.fadeout);

        resizedList=resizeImages(addImage());


        lefttoright.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        imageView.startAnimation(fadeout);
                    }
                }, 7000);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        fadeout.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if(indexer<resizedList.size()-1){indexer++;}else{indexer=0;}
                imageView.setImageBitmap(resizedList.get(indexer));
                imageView.startAnimation(lefttoright);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        initalizeImage();



    }

    private void initalizeImage() {
        imageView=new ImageView(getApplicationContext());
        imageView.setClickable(false);
           /* LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            lp.setMargins(0, 0,0, 0);
            imageView[i].setLayoutParams(lp);*/
        imageView.setImageBitmap(resizedList.get(indexer));
        imageGallery.addView(imageView);
        imageView.startAnimation(fadeout);
    }

    private  ArrayList<Bitmap> addImage()
    {
        ArrayList<Bitmap>imageList=new ArrayList<>();
        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.farming0);//assign your bitmap;
        Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.farming4);
        Bitmap bitmap3 = BitmapFactory.decodeResource(getResources(), R.drawable.farming9);
        Bitmap bitmap4 = BitmapFactory.decodeResource(getResources(), R.drawable.farming5);
        Bitmap bitmap5 = BitmapFactory.decodeResource(getResources(), R.drawable.farming11);
        Bitmap bitmap6 = BitmapFactory.decodeResource(getResources(), R.drawable.farming1);
        Bitmap bitmap7 = BitmapFactory.decodeResource(getResources(), R.drawable.farmingmilk1);
        imageList.add(bitmap1);
        imageList.add(bitmap2);
        imageList.add(bitmap3);
        imageList.add(bitmap4);
        imageList.add(bitmap5);
        imageList.add(bitmap6);
        imageList.add(bitmap7);

        return imageList;
    }

    private ArrayList<Bitmap> resizeImages(ArrayList<Bitmap> oldList){
        ArrayList<Bitmap>resizedList=new ArrayList<>();
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int height = displaymetrics.heightPixels;
        for(int i=0;i<oldList.size();i++) {

            Bitmap newBitmap = Bitmap.createScaledBitmap(oldList.get(i), oldList.get(i).getWidth(),
                    height, false);
            resizedList.add(newBitmap);
        }
        return resizedList;
    }


    @Override
    public void onClick(View v) {
        int id=v.getId();
        if(id==R.id.registerBtn){
            String text = registerAsSpinner.getSelectedItem().toString();
            Log.e("-----","----->>register as clicked and we have a :"+text);
            PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit().putString("USERTYPE",text).commit();
        }
        if(id==R.id.button7)
        {
            String text = loginAsSpinner.getSelectedItem().toString();
            PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit().putString("USERTYPE",text).commit();
             Intent intent=new Intent(this,UserHome.class);
                startActivity(intent);
        }
        if(id==R.id.link_newuserTV){
           login_relativelayoutView.setVisibility(View.GONE);
            signup_scrollView.setVisibility(View.VISIBLE);
           }
        if(id==R.id.link_olduserTV){login_relativelayoutView.setVisibility(View.VISIBLE);
            signup_scrollView.setVisibility(View.GONE);
        }

        if(id==R.id.profilePicImageView){
            Log.e("-----","----->>imageView Clicked");
            Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                    android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            // Start the Intent
            startActivityForResult(galleryIntent, RESULT_LOAD_IMG);
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            // When an Image is picked
            if (requestCode == RESULT_LOAD_IMG && resultCode == RESULT_OK
                    && null != data) {
                // Get the Image from data

                Uri selectedImage = data.getData();
                String[] filePathColumn = { MediaStore.Images.Media.DATA };

                // Get the cursor
                Cursor cursor = getContentResolver().query(selectedImage,
                        filePathColumn, null, null, null);
                // Move to first row
                cursor.moveToFirst();

                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                imgDecodableString = cursor.getString(columnIndex);
                cursor.close();

                // Set the Image in ImageView after decoding the String

                Bitmap bm=Bitmap.createScaledBitmap(BitmapFactory.decodeFile(imgDecodableString), 150, 150, false);
                profilePicImageView.setImageBitmap(bm);

            } else {
                Toast.makeText(this, "You haven't picked Image",
                        Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG)
                    .show();
        }

    }

    @Override
    protected void onStart() {
        /*login.setVisibility(View.VISIBLE);
        signup.setVisibility(View.VISIBLE);*/
        super.onStart();
    }

    @Override
    protected void onResume() {
       /* login.setVisibility(View.VISIBLE);
        signup.setVisibility(View.VISIBLE);*/
        onStart();
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void initializeSpinners(){
        String[] loginAs=new String[]{"Seller","Farmer","Login As.."};
        ArrayAdapter<String> loginAsSpinnerAdapter = new ArrayAdapter<String>(this, R.layout.spinner_item, loginAs){
            @Override
            public int getCount() {
                // don't display last item. It is used as hint.
                int count = super.getCount();
                return count > 0 ? count - 1 : count;
            }
        }; //selected item will look like a spinner set from XML
        loginAsSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        loginAsSpinner = (Spinner)findViewById(R.id.loginas);
        loginAsSpinner.setAdapter(loginAsSpinnerAdapter);
        loginAsSpinner.setSelection(loginAsSpinnerAdapter.getCount());

        String[] reagisterAs=new String[]{"Seller","Farmer","Register As.."};
        ArrayAdapter<String> registerAsSpinnerAdapter = new ArrayAdapter<String>(this, R.layout.spinner_item, reagisterAs){
            @Override
            public int getCount() {
                // don't display last item. It is used as hint.
                int count = super.getCount();
                return count > 0 ? count - 1 : count;
            }
        }; //selected item will look like a spinner set from XML
        registerAsSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        registerAsSpinner = (Spinner)findViewById(R.id.registerAsSpinner);
        registerAsSpinner.setAdapter(registerAsSpinnerAdapter);
        registerAsSpinner.setSelection(registerAsSpinnerAdapter.getCount());

        String[] states=new String[]{"Haryana","Punjab","Rajasthan","Karnataka","Nagaland","Select State"};
        ArrayAdapter<String> statesSpinnerAdapter = new ArrayAdapter<String>(this, R.layout.spinner_item, states){
            @Override
            public int getCount() {
                // don't display last item. It is used as hint.
                int count = super.getCount();
                return count > 0 ? count - 1 : count;
            }
        }; //selected item will look like a spinner set from XML
        registerAsSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        stateSpinner = (Spinner)findViewById(R.id.stateSpinner);
        stateSpinner.setAdapter(statesSpinnerAdapter);
        stateSpinner.setSelection(statesSpinnerAdapter.getCount());

        String[] districts=new String[]{"Hisar","Rewari","Sirsa","Select District"};
        ArrayAdapter<String> districtsSpinnerAdapter = new ArrayAdapter<String>(this, R.layout.spinner_item, districts){
            @Override
            public int getCount() {
                // don't display last item. It is used as hint.
                int count = super.getCount();
                return count > 0 ? count - 1 : count;
            }
        }; //selected item will look like a spinner set from XML
        registerAsSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        districtSpinner = (Spinner)findViewById(R.id.districtSpinner);
        districtSpinner.setAdapter(districtsSpinnerAdapter);
        districtSpinner.setSelection(districtsSpinnerAdapter.getCount());

        String[] tehsils=new String[]{"Adampur","Bhattu","Select Tehsil"};
        ArrayAdapter<String> tehsilsSpinnerAdapter = new ArrayAdapter<String>(this, R.layout.spinner_item, tehsils){
            @Override
            public int getCount() {
                // don't display last item. It is used as hint.
                int count = super.getCount();
                return count > 0 ? count - 1 : count;
            }
        }; //selected item will look like a spinner set from XML
        registerAsSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tehSpinner = (Spinner)findViewById(R.id.tehSpinner);
        tehSpinner.setAdapter(tehsilsSpinnerAdapter);
        tehSpinner.setSelection(tehsilsSpinnerAdapter.getCount());



    }
}