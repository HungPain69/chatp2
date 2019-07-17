package com.example.svmc_mp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ManHinhLogin extends AppCompatActivity {
    private EditText edtEmail, edtPassword;
    private Button btnLogin;
    private TextView tvSignUp;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_login);
        edtEmail = (EditText) findViewById(R.id.id_edt_username);
        edtPassword = (EditText) findViewById(R.id.id_edt_password);
        btnLogin = (Button) findViewById(R.id.id_btn_login);
        mAuth = FirebaseAuth.getInstance();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edtEmail.getText().toString()+"@svmc.duc";
                String password = edtPassword.getText().toString();
                if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)){

                    Toast.makeText(ManHinhLogin.this, "Bạn chưa điền thông tin kìa !!", Toast.LENGTH_SHORT).show();

                }
                else {

                    DangNhapTaiKhoan(email, password);
                }
            }
        });

        tvSignUp = (TextView) findViewById(R.id.id_textview_signup);
        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ManHinhLogin.this,ManHinhRegister.class);
                startActivity(intent);
            }
        });

    }

    private void DangNhapTaiKhoan(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(ManHinhLogin.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(ManHinhLogin.this,ManHinhChinhTablayout.class);
                            startActivity(intent);
//                            FirebaseUser user = mAuth.getCurrentUser();
//                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(ManHinhLogin.this, "Có gì đó sai sai ...",
                                    Toast.LENGTH_SHORT).show();
//                            updateUI(null);
                        }

                        // ...
                    }
                });
    }
}
