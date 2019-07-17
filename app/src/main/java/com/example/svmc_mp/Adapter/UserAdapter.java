package com.example.svmc_mp.Adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.svmc_mp.DoiTuong.Users;
import com.example.svmc_mp.ManHinhChat;
import com.example.svmc_mp.R;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder>{

    private Context mContext;
    private List<Users> mUsers;

    private ImageView imgAvatar;

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
        final Users nguoiDung = mUsers.get(position);
        holder.tenBanBe.setText(nguoiDung.getHoTen());

//        if(nguoiDung.get)

        String ten = nguoiDung.getHoTen();
        int i = ten.lastIndexOf(' ');
        if(i==-1){
            holder.anhAvatar.setImageResource(setAvatar(ten.charAt(0)));
        }
        else {holder.anhAvatar.setImageResource(setAvatar(ten.charAt(i+1)));}







        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, ManHinhChat.class);
                intent.putExtra("username",nguoiDung.getUsername());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView tenBanBe;
        public ImageView anhAvatar;


        public ViewHolder(@NonNull View itemView) {          //contructor
            super(itemView);

            tenBanBe =  itemView.findViewById(R.id.user_name_tab_ban_be);
            anhAvatar = itemView.findViewById(R.id.profile_image);





        }
    }
    private int setAvatar(char ch) {
        if(ch == 'A' || ch =='a'){return (R.drawable.avatar_a);}


        if(ch == 'B' || ch =='b'){ return (R.drawable.avatar_b);}


        if(ch == 'C' || ch =='c') {return (R.drawable.avatar_c);}


        if(ch == 'D' || ch =='d' || ch =='Đ' || ch =='đ'){return (R.drawable.avatar_d);}

        if(ch == 'E' || ch =='e'){  return (R.drawable.avatar_e);}


        if(ch == 'F' || ch =='f'){ return (R.drawable.avatar_f);}


        if(ch == 'G' || ch =='g'){  return (R.drawable.avatar_g);}


        if(ch == 'H' || ch =='h'){  return (R.drawable.avatar_h);}


        if(ch == 'I' || ch =='i'){  return (R.drawable.avatar_i);}


        if(ch == 'J' || ch =='j'){return(R.drawable.avatar_j);}


        if(ch == 'K' || ch =='k') {return(R.drawable.avatar_k);}


        if(ch == 'L' || ch =='l'){  return(R.drawable.avatar_l);}


        if(ch == 'M' || ch =='m'){  return(R.drawable.avatar_m);}


        if(ch == 'N' || ch =='n') {  return(R.drawable.avatar_n);}


        if(ch == 'O' || ch =='o') {  return(R.drawable.avatar_o);}


        if(ch == 'P' || ch =='p') { return(R.drawable.avatar_p);}


        if(ch == 'Q' || ch =='q') {return(R.drawable.avatar_q);}


        if(ch == 'R' || ch =='r') {return(R.drawable.avatar_r);}


        if(ch == 'S' || ch =='s'){ return(R.drawable.avatar_s);}


        if(ch == 'T' || ch =='t') {return(R.drawable.avatar_t);}


        if(ch == 'U' || ch =='u') {return(R.drawable.avatar_u);}


        if(ch == 'V' || ch =='v'){return(R.drawable.avatar_v);}


        if(ch == 'W' || ch =='w'){ return(R.drawable.avatar_w);}


        if(ch == 'X' || ch =='x') {return(R.drawable.avatar_x);}


        if(ch == 'Y' || ch =='y'){ return(R.drawable.avatar_y);}


        if(ch == 'Z' || ch =='z'){ return(R.drawable.avatar_z);}

        return(R.drawable.avatar_u);


    }

}