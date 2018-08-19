package com.work.bhaskar.counterapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
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

    CircleImageView filterButton, resetButton,nightModeButton, pressingButton;
    TextView recitedTodayText;

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

        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("First Fragment");
    }
}
