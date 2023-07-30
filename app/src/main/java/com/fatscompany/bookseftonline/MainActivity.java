package com.fatscompany.bookseftonline;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.fatscompany.bookseftonline.database.DatabaseManager;

public class MainActivity extends AppCompatActivity {
    DatabaseManager db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseManager(this);
        db.open();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        db.close();
    }
}