package com.work.bhaskar.counterapp;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;


public class FirstFragment extends Fragment {

    private View mView;

    public FirstFragment() {
        // Required empty public constructor
    }

    CircleImageView resetButton,nightModeButton, pressingButton;
    TextView recitedTodayText;
    Vibrator mVibrator;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.content_home, container, false);

        resetButton = (CircleImageView)mView.findViewById(R.id.reset);
        nightModeButton = (CircleImageView)mView.findViewById(R.id.nightMode);
        pressingButton = (CircleImageView)mView.findViewById(R.id.id_press);
        recitedTodayText = (TextView)mView.findViewById(R.id.recitedTodayText);


        recitedTodayText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ResetCustomDailog dailog = new ResetCustomDailog(getActivity());
                dailog.show();
            }
        });
        //Open the dialog
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ResetCustomDailog dailog = new ResetCustomDailog(getActivity());
                dailog.show();
            }
        });

        //        pressingButton.setOnClickListener(new View.OnClickListener() {
        pressingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mVibrator  = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    mVibrator.vibrate(VibrationEffect.createOneShot(500,VibrationEffect.DEFAULT_AMPLITUDE));
                }else{
                    mVibrator.vibrate(500);
                }
            }
        });
        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("First Fragment");
    }
}
