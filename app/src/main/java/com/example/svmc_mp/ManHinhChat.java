package com.example.svmc_mp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.svmc_mp.DoiTuong.Users;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;

public class ManHinhChat extends AppCompatActivity {

    CircleImageView anh_avatar;
    TextView ten_ban_chat;


    FirebaseUser firebaseUser;
    DatabaseReference reference;

    ImageButton send_button;
    EditText message_text;

    Intent intent;


    private ViewPager mViewPager;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_chat);


       //toolbar
        mToolbar = (Toolbar) findViewById(R.id.id_toolbar_man_hinh_chat);
        setMyToolBar(mToolbar,"",false);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });




        ten_ban_chat = findViewById(R.id.ten_bb_toolbar_chat);
        message_text = findViewById(R.id.message_text);
        send_button = findViewById(R.id.send_btn);


        intent = getIntent();
        final String username = intent.getStringExtra("username");

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        send_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mess = message_text.getText().toString();

                if(mess.equals("")){
                    Toast.makeText(ManHinhChat.this, "Hãy viết cho nhau", Toast.LENGTH_SHORT).show();
                }
                else{
                    sendMess(firebaseUser.getEmail(),username, mess);
                }

                //clear box input mess
                message_text.setText("");

            }
        });



        reference = FirebaseDatabase.getInstance().getReference("users").child(username);
        reference.addValueEventListener(new ValueEventListener() {

            //setText cho tên bạn chát
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Users users = dataSnapshot.getValue(Users.class);
                ten_ban_chat.setText(users.getHoTen());

            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    //Set toolbar
    public final void setMyToolBar(Toolbar toolbar, String title, Boolean showBackHome){
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(title);
        actionBar.setDisplayShowHomeEnabled(showBackHome);
        actionBar.setDisplayHomeAsUpEnabled(showBackHome);
    }


    public void sendMess(String nguoiGui, String nguoiNhan, String noiDung){

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("nguoiGui", nguoiGui);
        hashMap.put("nguoiNhan", nguoiNhan);
        hashMap.put("noiDung", noiDung);

        //tao child "Chatting" đẩy thông tin lên
      reference.child("Chatting").push().setValue(hashMap);
    }

}
