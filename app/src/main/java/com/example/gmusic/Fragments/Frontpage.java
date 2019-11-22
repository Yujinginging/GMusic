package com.example.gmusic.Fragments;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.gmusic.Activitys.LoginActivity;
import com.example.gmusic.Activitys.MainActivity;
import com.example.gmusic.Activitys.SignupActivity;
import com.example.gmusic.ViewModel.FrontpageViewModel;
import com.example.gmusic.R;

public class Frontpage extends Fragment {

    private FrontpageViewModel mViewModel;
    private View view;

    public static Frontpage newInstance() {
        return new Frontpage();
    }


    private TextView tv2;
    private Button button;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_frontpage, container, false);


        tv2 = (TextView) view.findViewById(R.id.tv_register);
        button = (Button)view.findViewById(R.id.btn_logintext);

        onLoginBtnClick();
        onSignupClicked();

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(FrontpageViewModel.class);
        // TODO: Use the ViewModel
    }


    public void onLoginBtnClick()
    {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });

    }

    public void onSignupClicked(){
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SignupActivity.class);
                startActivity(intent);
            }
        });

    }
}
