package com.work.bhaskar.counterapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class ChangePassActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_password);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public void onBackPressed() {
        Log.d("Bhaskar:: ", "ChangePassActivity: onBackPressed");
        Intent intent = new Intent(ChangePassActivity.this, LoginActivity.class);
        startActivity(intent);
        super.onBackPressed();
        this.finish();
    }
}
