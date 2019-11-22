package com.example.gmusic.Fragments;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gmusic.R;
import com.example.gmusic.ViewModel.FavouriteViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Favourite extends Fragment {

    private FavouriteViewModel mViewModel;

    private View root;

    public static Favourite newInstance() {
        return new Favourite();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.favourite_fragment, container, false);

        FloatingActionButton addBtn = (FloatingActionButton)root.findViewById(R.id.floatingActionButton3);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                        FragmentManager fm = getFragmentManager();
                        FragmentTransaction fragmentTransaction = fm.beginTransaction();
                        fragmentTransaction.replace(R.id.nav_host_fragment, new Search());
                        fragmentTransaction.commit();
            }
        });


        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(FavouriteViewModel.class);
        // TODO: Use the ViewModel
    }

}
