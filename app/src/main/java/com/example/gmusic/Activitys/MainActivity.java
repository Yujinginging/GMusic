package com.example.gmusic.Activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gmusic.Fragments.Frontpage;
import com.example.gmusic.R;

public class MainActivity extends AppCompatActivity {


    private ImageView imageView;
    private TextView tv1,tv2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        imageView = (ImageView)findViewById(R.id.imageView2);
        tv1 = (TextView) findViewById(R.id.textView);
        tv2 = (TextView) findViewById(R.id.tv_register);

        //show front page
        toFrontPage();


    }

    //directly jump to the front page
    public void toFrontPage()
    {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();

        fragmentTransaction.replace(R.id.frameLayout, new Frontpage());
        fragmentTransaction.commit();
    }


}
