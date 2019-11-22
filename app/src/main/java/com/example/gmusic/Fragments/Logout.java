package com.example.gmusic.Fragments;

import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gmusic.Activitys.LoginActivity;
import com.example.gmusic.R;
import com.google.firebase.auth.FirebaseAuth;

public class Logout extends Fragment {

    private LogoutViewModel mViewModel;
    private TextView logoutText;
    private View root;

    public static Logout newInstance() {
        return new Logout();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.logout_fragment, container, false);
        logoutText = root.findViewById(R.id.logout);
        logout();
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(LogoutViewModel.class);
        // TODO: Use the ViewModel
    }

    public void logout(){
        logoutText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();//logout
                startActivity(new Intent(getContext(), LoginActivity.class));
            }
        });


    }

}
