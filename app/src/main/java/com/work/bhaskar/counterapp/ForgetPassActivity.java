package com.work.bhaskar.counterapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ForgetPassActivity extends AppCompatActivity {

    Button confirm_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forget_password);

//        getSupportActionBar().setCustomView();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        confirm_button = (Button)findViewById(R.id.confirm_button);

        confirm_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToHomePage();
            }
        });
    }
    public void goToHomePage(){
        Intent intent = new Intent(ForgetPassActivity.this, ChangePassActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
