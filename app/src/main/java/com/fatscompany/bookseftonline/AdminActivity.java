package com.fatscompany.bookseftonline;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;

import com.fatscompany.bookseftonline.databinding.ActivityAdminBinding;
import com.google.android.material.navigation.NavigationView;

public class AdminActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ActivityAdminBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        binding = ActivityAdminBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        setSupportActionBar(binding.adminToolBar);
        /*
        toggle = new ActionBarDrawerToggle(
            this, drawlayout cua admin (trang ben ngoai), materialToolbar (cai menu truot),
            R.string.navigation_drawer_open, R.string.navigation_drawer_close
        );*/
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, binding.adminDrawerlayout, binding.adminToolBar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        binding.adminDrawerlayout.addDrawerListener(toggle);
        toggle.syncState();

        binding.adminNav.setNavigationItemSelectedListener(this);
        binding.adminNav.bringToFront();
    }


    /* khong cho out app khi back pressed */
    @Override
    public void onBackPressed() {
        if (binding.adminDrawerlayout.isDrawerOpen(GravityCompat.START)){
            binding.adminDrawerlayout.closeDrawer(GravityCompat.START);
        }
        else super.onBackPressed();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        return true;
    }
}