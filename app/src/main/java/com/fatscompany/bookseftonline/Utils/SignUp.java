package com.fatscompany.bookseftonline.Utils;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.fatscompany.bookseftonline.Database.DatabaseAdapter;
import com.fatscompany.bookseftonline.Database.DatabaseController;
import com.fatscompany.bookseftonline.R;
import com.fatscompany.bookseftonline.databinding.ActivitySignUpAppBinding;

public class SignUp extends AppCompatActivity {
    private ActivitySignUpAppBinding binding;
    private DatabaseAdapter dbAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySignUpAppBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Glide.with(this).load(R.drawable.logo).into(binding.imgSignUp);

        binding.btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String FName  = binding.signUpFName.getText().toString();
                String LName = binding.signUpLName.getText().toString();
                String email= binding.signUpEmail.getText().toString();
                String phone = binding.signUpSDT.getText().toString();
                String acName = binding.signUpAName.getText().toString();
                String pw = binding.signUpPw.getText().toString();
                Boolean active = false;
                String userole = "CUSTOMER";

                if (FName.isEmpty() || LName.isEmpty() || email.isEmpty() || phone.isEmpty() || acName.isEmpty() || pw.isEmpty()){
                    Toast.makeText(SignUp.this, "Nhập đủ dữ liệu đcmm", Toast.LENGTH_SHORT).show();
                    return;
                }

                dbAdapter = new DatabaseAdapter(SignUp.this);
//                dbAdapter.insertUser(acName,pw,FName,LName,email,phone,active,userole);
                Toast.makeText(SignUp.this, "Tạo tài khỏan thành công", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SignUp.this,Login.class);
                startService(intent);
            }
        });
    }
}