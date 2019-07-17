package com.example.svmc_mp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.svmc_mp.DoiTuong.Chatting;

import com.example.svmc_mp.ManHinhChat;
import com.example.svmc_mp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder>{


    public static final int MSG_TYPE_RECEIVE = 0;
    public static final int MSG_TYPE_SEND = 1;

    private Context mContext;
    private List<Chatting> mchat;

    FirebaseUser firebaseUser;


    //constructor
    public MessageAdapter(Context mContext, List<Chatting> mchat) {
        this.mContext = mContext;
        this.mchat = mchat;
    }

    @NonNull
    @Override
    public MessageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if(viewType == MSG_TYPE_SEND){
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_chat_sender,parent,false);
            return  new MessageAdapter.ViewHolder(view);
        }
        else{
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_chat_receiver,parent,false);
            return  new MessageAdapter.ViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull MessageAdapter.ViewHolder holder, int position) {

        Chatting chat = mchat.get(position);
        holder.show_mess.setText(chat.getNoiDung());

    }

    @Override
    public int getItemCount() {
        return mchat.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView show_mess;
//        public ImageView anhAvatar;


        public ViewHolder(@NonNull View itemView) {          //contructor
            super(itemView);

            show_mess =  itemView.findViewById(R.id.mess_show);
//            anhAvatar = itemView.findViewById(R.id.profile_image);

        }
    }

         /////////////////////////////////
    @Override
    public int getItemViewType(int position) {
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        String currenUsr = firebaseUser.getEmail();
        String []arr=currenUsr.split("@");

        String currentUser=arr[0];

        String getNguoiGuiTrongModelChat =mchat.get(position).getNguoiGui();


//        Log.d("a", "onClick"+getNguoiGuiTrongModelChat);
//
//        Log.d("b", "sender"+currentUser);


        if(mchat.get(position).getNguoiGui().equals(currentUser)){
            return MSG_TYPE_SEND;
        }
        else{
            return MSG_TYPE_RECEIVE;
        }
    }
}