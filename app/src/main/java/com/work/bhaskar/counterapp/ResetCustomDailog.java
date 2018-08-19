package com.work.bhaskar.counterapp;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class ResetCustomDailog extends Dialog implements View.OnClickListener {

    public Activity c;
    public Button reset_Button, cancelButton;


    public ResetCustomDailog(Activity a) {
        super(a);
        // TODO Auto-generated constructor stub
        this.c = a;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.reset_dailog);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ok_button:
                dismiss();
                break;
            case R.id.reset_button:
                this.dismiss();
                break;
            default:
                break;
        }

    }
}