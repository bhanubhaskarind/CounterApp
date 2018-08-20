package com.work.bhaskar.counterapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ChangePassActivity extends AppCompatActivity {

    Button change_pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_password);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        change_pass = (Button)findViewById(R.id.change_pass);

        change_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToLoginPage();
            }
        });
    }

    public void goToLoginPage(){
        Intent intent = new Intent(ChangePassActivity.this, LoginActivity.class);
        startActivity(intent);
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
