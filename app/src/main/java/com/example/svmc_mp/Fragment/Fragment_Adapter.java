package com.example.svmc_mp.Fragment;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.svmc_mp.Fragment.TabCaiDat;
import com.example.svmc_mp.Fragment.TabPhongChatCongKhai;
import com.example.svmc_mp.Fragment.TabPhongChatRiengTu;

public class Fragment_Adapter extends FragmentStatePagerAdapter {
    int countTab;
    Context context;
    public Fragment_Adapter(Context context, FragmentManager fm, int countTab) {
        super(fm);
        this.context = context;
        this.countTab = countTab;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new TabPhongChatCongKhai();
            case 1: return new TabPhongChatRiengTu();
            case 2: return new TabCaiDat();
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return countTab;
    }

}
