package com.fatscompany.bookseftonline;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.fatscompany.bookseftonline.Database.DatabaseAdapter;
import com.fatscompany.bookseftonline.databinding.ActivityLoginAppBinding;
import com.fatscompany.bookseftonline.databinding.ActivityMainBinding;
import com.fatscompany.bookseftonline.databinding.ActivitySignUpAppBinding;

public class MainActivity extends AppCompatActivity {
    DatabaseAdapter db;
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        setContentView(R.layout.activity_main);

    }
}