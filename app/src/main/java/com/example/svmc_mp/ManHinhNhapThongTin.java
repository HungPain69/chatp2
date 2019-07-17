package com.example.svmc_mp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.svmc_mp.DoiTuong.Users;
import com.firebase.ui.auth.data.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class ManHinhNhapThongTin extends AppCompatActivity {
    private EditText edtHoTen, edtQueQuan, edtNgaySinh;
    private Button btnCapNhat;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_nhap_thong_tin);

        mAuth = FirebaseAuth.getInstance();

        edtHoTen = (EditText) findViewById(R.id.id_edt_capnhat_hoten);
        edtQueQuan = (EditText) findViewById(R.id.id_edt_caphat_quequan);
        edtNgaySinh = (EditText) findViewById(R.id.id_edt_capnhat_ngaysinh);
        btnCapNhat = (Button) findViewById(R.id.id_btn_capnhat);
        btnCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FirebaseUser user = mAuth.getCurrentUser();
                String username = user.getEmail();
                String []chuoi  = username.split("@");
                username = chuoi[0];
                String hoTen= edtHoTen.getText().toString();
                String queQuan = edtQueQuan.getText().toString();
                String ngaySinh = edtNgaySinh.getText().toString();

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("users").child(username);

//                HashMap<String, String> hashMap = new HashMap<>();
//                hashMap.put("username", username);
//                hashMap.put("hoten", edtHoTen.getText().toString());
//                hashMap.put("quequan", edtQueQuan.getText().toString());
//                hashMap.put("ngaysinh", edtNgaySinh.getText().toString());

                if(TextUtils.isEmpty(hoTen) ){

                    Toast.makeText(ManHinhNhapThongTin.this, "Tên của bạn là gì ????", Toast.LENGTH_SHORT).show();
                }
                else {

                    Users users = new Users(username,hoTen,queQuan,ngaySinh);
                    myRef.setValue(users).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                startActivity(new Intent(ManHinhNhapThongTin.this,ManHinhChinhTablayout.class));
                            }
                            else {
                                Toast.makeText(ManHinhNhapThongTin.this, "Có lỗi nào đó đã xuất hiện", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }





            }
        });

    }
}
