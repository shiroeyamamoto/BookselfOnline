package com.khoabeo.fatsbook;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Login_app extends AppCompatActivity {
    private ImageView imgView;
    private TextInputLayout txtAccount;
    private TextInputLayout txtPassworld;
    private TextInputEditText editAccount;
    private TextInputEditText editPass;
        private Button btnSignUp;
    private Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_app);
        btnBack = findViewById(R.id.mbtnBack);
        imgView = findViewById(R.id.imgView);
        txtAccount = findViewById(R.id.textLayout1);
        txtPassworld = findViewById(R.id.textLayoutPassworld);
        editAccount = findViewById(R.id.txtInAcc);
        editPass = findViewById(R.id.txtInPas);
       btnSignUp = findViewById(R.id.btnSignup);

        Glide.with(this).load(R.drawable.logo).into(imgView);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Login_app.this,"ON CLICK",Toast.LENGTH_SHORT).show();
            }
        });
        editAccount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(editAccount.length() >=20){
                    txtAccount.setError("Nhập ít thôi thằng nguu");
                }
                else if(editAccount.length() <20){
                    txtAccount.setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(Login_app.this, SignUp_App.class);
                startActivity(intent);
            }
        });
    }
}