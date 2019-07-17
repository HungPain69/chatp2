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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ManHinhRegister extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private  EditText edtEmail, edtPassword, edtPasswordAgain ;
    private Button btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_register);

        //FBase


        edtEmail = (EditText) findViewById(R.id.id_edt_register_username);
        edtPassword = (EditText) findViewById(R.id.id_edt_register_password);
        edtPasswordAgain = (EditText) findViewById(R.id.id_edt_regiter_password_again);
        btnRegister = (Button) findViewById(R.id.id_btn_register);
        mAuth = FirebaseAuth.getInstance();
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edtEmail.getText().toString()+"@svmc.duc";
                String password = edtPassword.getText().toString();
                String passwordAgain = edtPasswordAgain.getText().toString();

                if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || TextUtils.isEmpty(passwordAgain) ){

                    Toast.makeText(ManHinhRegister.this, "Hãy hoàn thành thông tin đăng kí", Toast.LENGTH_SHORT).show();
                }
                else {

                    if(password.equals(passwordAgain)==true){
                        DangKiTaiKhoan(email,password);
                    } else{
                        Toast.makeText(ManHinhRegister.this,"Mật khẩu không khớp!",Toast.LENGTH_SHORT).show();
                    }

                }
                
            }
        });
    }

    private void DangKiTaiKhoan(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(ManHinhRegister.this,"Đăng kí thành công",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(ManHinhRegister.this,ManHinhNhapThongTin.class));
                            //
                            //updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(ManHinhRegister.this, "Đăng kí thất bại.",
                                    Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }

                        // ...
                    }
                });
    }

}
