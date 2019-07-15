package com.example.svmc_mp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.svmc_mp.Fragment.Fragment_Adapter;
import com.google.android.material.tabs.TabLayout;

public class ManHinhChinhTablayout extends AppCompatActivity {
    private Fragment_Adapter mFragment_Adapter;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_chinh_tablayout);
        mToolbar = (Toolbar) findViewById(R.id.id_toolbar_man_hinh_chinh);
        setMyToolBar(mToolbar,getString(R.string.title_fragment_1),false);

        //TabLayout
        mTabLayout = (TabLayout) findViewById(R.id.id_tablayout);
        mViewPager = (ViewPager) findViewById(R.id.id_viewpager);
        mFragment_Adapter = new Fragment_Adapter(ManHinhChinhTablayout.this,getSupportFragmentManager(),3);
        mViewPager.setAdapter(mFragment_Adapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.getTabAt(0).setIcon(R.drawable.icon_public_white);
        mTabLayout.getTabAt(1).setIcon(R.drawable.icon_group_white);
        mTabLayout.getTabAt(2).setIcon(R.drawable.icon_settings_white);
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition()==0) setMyToolBar(mToolbar, getString(R.string.title_fragment_1),false);
                if(tab.getPosition()==1) setMyToolBar(mToolbar, getString(R.string.title_fragment_2),false);
                if(tab.getPosition()==2) setMyToolBar(mToolbar, getString(R.string.title_fragment_3),false);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }



    //region Hàm set tiêu đề và nút bấm back quay về trang trước
    public final void setMyToolBar(Toolbar toolbar, String title, Boolean showBackHome){
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(title);
        actionBar.setDisplayShowHomeEnabled(showBackHome);
        actionBar.setDisplayHomeAsUpEnabled(showBackHome);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
    //endregion
}
