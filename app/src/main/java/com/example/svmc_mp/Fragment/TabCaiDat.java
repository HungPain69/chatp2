package com.example.svmc_mp.Fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.svmc_mp.DoiTuong.Users;
import com.example.svmc_mp.ManHinhLogin;
import com.example.svmc_mp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static android.content.Intent.getIntent;

public class TabCaiDat extends Fragment {
    private TextView tvHoTen,tvQueQuan,tvNgaySinh;
    private Button btnDangXuat;
    private ImageView imgAvatar;
    public TabCaiDat() {
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_cai_dat,container,false);

        tvHoTen = (TextView) view.findViewById(R.id.id_tv_thongtin_hoten);
        tvQueQuan = (TextView) view.findViewById(R.id.id_tv_thongtin_quequan);
        tvNgaySinh = (TextView) view.findViewById(R.id.id_tv_thongtin_ngaysinh);
        imgAvatar = (ImageView) view.findViewById(R.id.id_img_avatar);
        btnDangXuat = view.findViewById(R.id.id_btn_dangxuat);

        // Logout khi click button Đăn xuất
        btnDangXuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getActivity(), ManHinhLogin.class);
                getActivity().startActivity(intent);
            }
        });

        //setText để hiển thị thông tin trên màn hình cài đặt
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        String s = currentUser.getEmail();
        String []arr=s.split("@");
        s=arr[0];
        DatabaseReference myRef = database.getReference("users").child(s);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Users users = dataSnapshot.getValue(Users.class);
                tvHoTen.setText(tvHoTen.getText().toString()+users.getHoTen());
                tvQueQuan.setText(tvQueQuan.getText().toString()+users.getQueQuan());
                tvNgaySinh.setText(tvNgaySinh.getText().toString()+users.getNgaySinh());
                String ten = users.getHoTen();
                int i = ten.lastIndexOf(' ');
                if(i==-1){
                    setAvatar(ten.charAt(0));
                }
                else setAvatar(ten.charAt(i+2));
            }
            @Override
            public void onCancelled(DatabaseError error) {

            }
        });
        return view;
    }


    //set avatar theo kí tự đầu tiên của tên
    private void setAvatar(char ch) {
        switch (ch){
            case 'A':
            case 'a':
                imgAvatar.setImageResource(R.drawable.avatar_a); break;
            case 'B':
            case 'b':
                imgAvatar.setImageResource(R.drawable.avatar_b);break;
            case 'C':
            case 'c':
                imgAvatar.setImageResource(R.drawable.avatar_c);break;
            case 'D':
            case 'd':
                imgAvatar.setImageResource(R.drawable.avatar_d);break;
            case 'E':
            case 'e':
                imgAvatar.setImageResource(R.drawable.avatar_e);break;
            case 'F':
            case 'f':
                imgAvatar.setImageResource(R.drawable.avatar_f);break;
            case 'G':
            case 'g':
                imgAvatar.setImageResource(R.drawable.avatar_g);break;
            case 'H':
            case 'h':
                imgAvatar.setImageResource(R.drawable.avatar_h);break;
            case 'I':
            case 'i':
                imgAvatar.setImageResource(R.drawable.avatar_i);break;
            case 'J':
            case 'j':
                imgAvatar.setImageResource(R.drawable.avatar_j);break;
            case 'K':
            case 'k':
                imgAvatar.setImageResource(R.drawable.avatar_k);break;
            case 'L':
            case 'l':
                imgAvatar.setImageResource(R.drawable.avatar_l);break;
            case 'M':
            case 'm':
                imgAvatar.setImageResource(R.drawable.avatar_m);break;
            case 'N':
            case 'n':
                imgAvatar.setImageResource(R.drawable.avatar_n);break;
            case 'O':
            case 'o':
                imgAvatar.setImageResource(R.drawable.avatar_o);break;
            case 'P':
            case 'p':
                imgAvatar.setImageResource(R.drawable.avatar_p);break;
            case 'Q':
            case 'q':
                imgAvatar.setImageResource(R.drawable.avatar_q);break;
            case 'R':
            case 'r':
                imgAvatar.setImageResource(R.drawable.avatar_r);break;
            case 'S':
            case 's':
                imgAvatar.setImageResource(R.drawable.avatar_s);break;
            case 'T':
            case 't':
                imgAvatar.setImageResource(R.drawable.avatar_t);break;
            case 'U':
            case 'u':
                imgAvatar.setImageResource(R.drawable.avatar_u);break;
            case 'V':
            case 'v':
                imgAvatar.setImageResource(R.drawable.avatar_v); break;
            case 'W':
            case 'w':
                imgAvatar.setImageResource(R.drawable.avatar_w);break;
            case 'X':
            case 'x':
                imgAvatar.setImageResource(R.drawable.avatar_x);break;
            case 'Y':
            case 'y':
                imgAvatar.setImageResource(R.drawable.avatar_y);break;
            case 'Z':
            case 'z':
                imgAvatar.setImageResource(R.drawable.avatar_z);break;
        }
    }
}
