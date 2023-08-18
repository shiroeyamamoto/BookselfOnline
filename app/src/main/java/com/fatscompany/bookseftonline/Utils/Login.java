package com.fatscompany.bookseftonline.Utils;

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
import com.fatscompany.bookseftonline.AppDatabase;
import com.fatscompany.bookseftonline.Database.DatabaseController;
import com.fatscompany.bookseftonline.Entitis.User;
import com.fatscompany.bookseftonline.R;
import com.fatscompany.bookseftonline.databinding.ActivityLoginAppBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

public class Login extends AppCompatActivity {

    private ActivityLoginAppBinding binding;
    private DatabaseController db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginAppBinding.inflate(getLayoutInflater());
        View v = binding.getRoot();
        setContentView(v);

        Glide.with(this).load(R.drawable.logo).into(binding.imgView);
        AppDatabase db = AppDatabase.getInstance(Login.this);
        binding.mbtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Login.this, "ON CLICK", Toast.LENGTH_SHORT).show();
            }
        });
        binding.txtInAcc.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (binding.txtInAcc.length() >= 20) {
                    binding.textLayout1.setError("Nhập ít thôi thằng nguu");
                } else if (binding.txtInAcc.length() < 20) {
                    binding.textLayout1.setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String user = binding.txtInAcc.getText().toString();
                String pw = binding.txtInPas.getText().toString();

                ExecutorService executor = Executors.newSingleThreadExecutor();
                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        User userCheck = db.userDao().checkUser(user, pw);

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (userCheck != null) {
                                    Toast.makeText(Login.this, "hay lam dmm", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(Login.this, "Nhập nguu cái đmmm", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                });
            }

        });
        binding.btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, SignUp.class);
                startActivity(intent);
            }
        });
    }
}