package com.bhoomiputra.Activities;

import android.app.FragmentManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Fragment;

import com.bhoomiputra.Fragments.FarmerHomeFragment;
import com.bhoomiputra.Fragments.FarmerOrderHistroy;
import com.bhoomiputra.Fragments.FarmerSettings;
import com.bhoomiputra.Fragments.SellerHome;
import com.bhoomiputra.Fragments.Seller_Add_Edit_Tools;
import com.bhoomiputra.R;

public class UserHome extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    String USER_TYPE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        USER_TYPE= PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getString("USERTYPE", "defaultStringIfNothingFound");
        initNavigationDrawer();

        NavigationView navigationView = (NavigationView)findViewById(R.id.navigation_view);
        View header = navigationView.getHeaderView(0);
        TextView tv_email = (TextView)header.findViewById(R.id.tv_email);
        tv_email.setText("nandkishorv739@gmail.com");
    }

    public void initNavigationDrawer() {

        NavigationView navigationView = (NavigationView)findViewById(R.id.navigation_view);
        navigationView.getMenu().clear();

        Fragment fragment = null;
        if(USER_TYPE.equals("Seller")){
            navigationView.inflateMenu(R.menu.seller);
            fragment = new SellerHome();
            if (fragment != null) {
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.frame_container, fragment).commit();
            }
        }
        else{
            navigationView.inflateMenu(R.menu.farmer);
            fragment = new FarmerHomeFragment();
            if (fragment != null) {
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.frame_container, fragment).commit();
            }
        }
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                int id = menuItem.getItemId();
                Fragment fragment = null;
                switch (id) {
                    case R.id.SELLERHOME:
                        fragment = new SellerHome();
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.SELLERADDEDITTOOLS:
                        fragment = new Seller_Add_Edit_Tools();
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.SELLERHISTORY:
                        Toast.makeText(getApplicationContext(), "SELLERHISTORY", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.SELLERSETTINGS:
                        fragment = new FarmerSettings();
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.SELLERLOGOUT:
                        Log.e("----->>", "seller logout");
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.FARMERHOME:
                        fragment = new FarmerHomeFragment();
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.FARMERHISTORY:
                        fragment = new FarmerOrderHistroy();
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.FARMERSETTINGS:
                        fragment = new FarmerSettings();
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.FARMERLOGOUT:
                        Toast.makeText(getApplicationContext(), "FARMERLOGOUT", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawers();
                        break;
                }

                if (fragment != null) {
                    FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.frame_container, fragment).commit();
                } else {
                    // error in creating fragment
                    Log.e("MainActivity", "Error in creating fragment");
                }

                return true;
            }
        });

        drawerLayout = (DrawerLayout)findViewById(R.id.drawer);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close){
            @Override
            public void onDrawerClosed(View v){
                super.onDrawerClosed(v);
            }

            @Override
            public void onDrawerOpened(View v) {
                super.onDrawerOpened(v);
            }
        };
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

}
