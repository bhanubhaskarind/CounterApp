package com.work.bhaskar.counterapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    CircleImageView filterButton, resetButton,nightModeButton, pressingButton;
    TextView recitedTodayText;
    Vibrator mVibrator;
    View  content_frame;
    public static final String MY_PREFS_NAME = "MyPrefsFile";


    View homeView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_home);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportFragmentManager().beginTransaction().replace(R.id.framecheck, new FirstFragment()).commit();

       // content_frame = (LinearLayout)findViewById(R.id.home_layout);


//        resetButton = (CircleImageView)findViewById(R.id.reset);
//        nightModeButton = (CircleImageView)findViewById(R.id.nightMode);
//        pressingButton = (CircleImageView)findViewById(R.id.id_press);
        recitedTodayText = (TextView)findViewById(R.id.recitedTodayText);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

//        //Press the Action Bar Filter Button
        filterButton = (CircleImageView)findViewById(R.id.filter);
        filterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialogClass dailog = new CustomDialogClass(HomeActivity.this);
                dailog.show();

            }
        });
//
//        //Open the dialog
//        resetButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Log.d("Bhaskar:=======", "reset click: ");
//                ResetCustomDailog dailog = new ResetCustomDailog(HomeActivity.this);
//                dailog.show();
//            }
//        });
////
////        // When we press the big Button
//        pressingButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Log.d("Bhaskar:=======", "counter click: ");
//                mVibrator  = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//                    mVibrator.vibrate(VibrationEffect.createOneShot(500,VibrationEffect.DEFAULT_AMPLITUDE));
//                }else{
//                    mVibrator.vibrate(500);
//                }
//            }
//        });
////
////        //Night Mode Screen layout
//        nightModeButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d("Bhaskar:=======", "nightmode click: ");
//            }
//        });
}

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        displaySelectedScreen(item.getItemId());
        return true;
    }

    private void displaySelectedScreen(int itemId) {

        Fragment fragment = null;
        switch (itemId) {
            case R.id.about_option:
                fragment = new FirstFragment();
                Toast.makeText(this, "First Fragment", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tasbih_option:
                fragment = new SecondFragment();
                Toast.makeText(this, "Second Fragment", Toast.LENGTH_SHORT).show();;
                break;
            case R.id.profile_option:
                fragment = new ThirdFragment();
                Toast.makeText(this, "Third Fragment", Toast.LENGTH_SHORT).show();;
                break;
        }

        //replacing the fragment
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.framecheck, fragment);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }
}
