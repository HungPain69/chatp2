package com.example.svmc_mp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

import de.hdodenhof.circleimageview.CircleImageView;

public class ManHinhChat extends AppCompatActivity {

    CircleImageView anh_avatar;
    TextView ten_ban_be;


    FirebaseUser firebaseUser;
    DatabaseReference reference;


    Intent intent;


    private ViewPager mViewPager;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_chat);


       //toolbar
        mViewPager = (ViewPager) findViewById(R.id.id_viewpager_mh_chat);
        mToolbar = (Toolbar) findViewById(R.id.id_toolbar_man_hinh_chat);

        setMyToolBar(mToolbar,"",false);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }

    public final void setMyToolBar(Toolbar toolbar, String title, Boolean showBackHome){
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(title);
        actionBar.setDisplayShowHomeEnabled(showBackHome);
        actionBar.setDisplayHomeAsUpEnabled(showBackHome);
    }
}
