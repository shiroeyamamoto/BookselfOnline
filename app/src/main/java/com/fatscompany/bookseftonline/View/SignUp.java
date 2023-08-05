package com.fatscompany.bookseftonline.View;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.fatscompany.bookseftonline.R;

public class SignUp extends AppCompatActivity {
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
                Toast.makeText(SignUp.this, "hahahaha", Toast.LENGTH_SHORT).show();
            }
        });
    }
}