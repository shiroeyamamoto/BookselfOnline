package com.khoabeo.fatsbook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class SignUp_App extends AppCompatActivity {
    private Button btnSBack;
    private ImageView imgViewSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_app);
        btnSBack = findViewById(R.id.btnSignUpBack);
        imgViewSignUp = findViewById(R.id.imgSignUp);
        Glide.with(this).load(R.drawable.logo).into(imgViewSignUp);

        btnSBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SignUp_App.this, "hahahaha", Toast.LENGTH_SHORT).show();
            }
        });
    }
}