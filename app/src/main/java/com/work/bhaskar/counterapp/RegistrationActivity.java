package com.work.bhaskar.counterapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class RegistrationActivity extends AppCompatActivity {

    EditText mobileNumber, fullName, password;
    Button reset;
    Spinner gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

          getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mobileNumber = (EditText)findViewById(R.id.mobileNumber);
        fullName = (EditText)findViewById(R.id.userName);
        password = (EditText)findViewById(R.id.password);

        reset = (Button)findViewById(R.id.register_button);


        gender = (Spinner)findViewById(R.id.gender_button);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.gender_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gender.setAdapter(adapter);


        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToLoginPage();
            }
        });
    }

    public void goToLoginPage(){
        Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
        startActivity(intent);
        super.onBackPressed();
        this.finish();
    }
}
