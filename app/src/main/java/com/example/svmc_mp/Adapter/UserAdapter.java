package com.example.svmc_mp.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.svmc_mp.DoiTuong.Users;
import com.example.svmc_mp.R;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder>{

    private Context mContext;
    private List<Users> mUsers;


    public UserAdapter(Context mContext, List<Users> mUsers){
        this.mUsers = mUsers;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_ban_be,parent,false);
        return  new UserAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Users nguoiDung = mUsers.get(position);
        holder.tenBanBe.setText(nguoiDung.getHoTen());

//        if(nguoiDung.get)

    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView tenBanBe;
//        public ImageView anhAvatar;


        public ViewHolder(@NonNull View itemView) {          //contructor
            super(itemView);

            tenBanBe =  itemView.findViewById(R.id.user_name_tab_ban_be);
//            anhAvatar = itemView.findViewById(R.id.profile_image);

        }
    }
}