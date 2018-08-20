package com.work.bhaskar.counterapp;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    String BaseUrl = "http://192.168.2.3:3004/api/v1/";
    EditText userName, password;
    Button submitButton;
    Intent intent;
    private int mStatusCode;
    private String MY_PREFS_NAME = "myTokenFile";
    RequestQueue requestQueue;
    String JsonURL = BaseUrl + "authenticate";

    TextView registerText, forgetText, registerhere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
       // getSupportActionBar().setCustomView(R.layout.actionbar);
        setContentView(R.layout.login);
        registerComponents();

        forgetText.setMovementMethod(LinkMovementMethod.getInstance());
        Spannable spanpan_1 = (Spannable) forgetText.getText();
        ClickableSpan  clickSpan_1 = new ClickableSpan() {

            @Override
            public void onClick(View widget)
            {
                //put whatever you like here, below is an example
                goToForgetPage();

            }

            @Override
            public void updateDrawState(TextPaint ds) {
                forgetText.setHighlightColor(Color.parseColor("#f6f8fa"));
                super.updateDrawState(ds);
            }
        };
        spanpan_1.setSpan(clickSpan_1, 0, spanpan_1.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);


        registerhere.setMovementMethod(LinkMovementMethod.getInstance());
        Spannable spans_1 = (Spannable) registerhere.getText();
        ClickableSpan clickSpan_12 = new ClickableSpan() {

            @Override
            public void onClick(View widget)
            {
                //put whatever you like here, below is an example
                goToRegistrationPage();
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                registerhere.setHighlightColor(Color.parseColor("#f6f8fa"));
                super.updateDrawState(ds);
            }
        };
        spans_1.setSpan(clickSpan_12, 0, spans_1.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);




        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToHomePage();
            }
        });
    }

    public void goToRegistrationPage(){
        Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
        startActivity(intent);
    }

    public void goToForgetPage(){
        Intent intent = new Intent(LoginActivity.this, ForgetPassActivity.class);
        startActivity(intent);
    }

    public void goToHomePage(){
        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
        startActivity(intent);
    }

    public void setConnection(RequestQueue queue) {
        JsonObjectRequest obreq = new JsonObjectRequest(Request.Method.POST, JsonURL,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            if (mStatusCode == 200) {
                                Boolean success = response.getBoolean("success");
                                String token = response.getString("token");

                                SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                                editor.putString("token", token);
                                editor.apply();

                                if (success) {
                                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(LoginActivity.this, "User cant login !!", Toast.LENGTH_LONG).show();
                                }
                            }else{
                            }

                        }
                        catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                }
        ) {
            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }

            @Override
            protected Response<JSONObject> parseNetworkResponse(NetworkResponse response) {
                Log.d("Bhaskar:: ", "protected Response<JSONObject> parseNetworkResponse(NetworkResponse response)");
                mStatusCode = response.statusCode;
                return super.parseNetworkResponse(response);

            }

            @Override
            protected Map<String, String> getParams() {
                Log.d("Bhaskar:: ", "protected Map<String, String> getParams");
                Map<String, String> params = new HashMap<String, String>();
                params.put("contact_number", userName.getText().toString());
                params.put("password", password.getText().toString());

                return params;
            }
        };
        queue.add(obreq);

    }

    public void registerComponents() {
        userName = (EditText) findViewById(R.id.userName);
        password = (EditText) findViewById(R.id.password);
        submitButton = (Button) findViewById(R.id.button);
        forgetText = (TextView)findViewById(R.id.forgetpassword) ;
        registerText = (TextView)findViewById(R.id.noteyetregister) ;
        registerhere = (TextView)findViewById(R.id.registerhere);

    }
}
