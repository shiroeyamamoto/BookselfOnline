package com.fatscompany.bookseftonline;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.fatscompany.bookseftonline.Database.DatabaseAdapter;
import com.fatscompany.bookseftonline.FragmentCode.ViewPagerAdapter;
import com.fatscompany.bookseftonline.databinding.ActivityMainBinding;
import com.fatscompany.bookseftonline.FragmentCode.MainFavorite;
import com.fatscompany.bookseftonline.FragmentCode.MainHome;
import com.fatscompany.bookseftonline.FragmentCode.MainMore;

public class MainActivity extends AppCompatActivity {
    DatabaseAdapter db;
    private ActivityMainBinding binding;
    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);
        setSupportActionBar(binding.toolbar);
        replaceViewPager(0);
        binding.navbottom.setOnItemSelectedListener(item -> {

            if (item.getItemId() == R.id.home) {
                binding.viewPager2.setCurrentItem(0);
            } else if (item.getItemId() == R.id.favorite) {
                binding.viewPager2.setCurrentItem(1);
            } else {
                binding.viewPager2.setCurrentItem(2);
            }

            return true;

        });

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_nav_top, menu);
        return true;
    }

    private void replaceViewPager(int position) {
        viewPagerAdapter = new ViewPagerAdapter(this);
        binding.viewPager2.setAdapter(viewPagerAdapter);
        binding.viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        binding.navbottom.getMenu().findItem(R.id.home).setChecked(true);
                        break;
                    case 1:
                        binding.navbottom.getMenu().findItem(R.id.favorite).setChecked(true);
                        break;
                    case 2:
                        binding.navbottom.getMenu().findItem(R.id.more).setChecked(true);
                        break;
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        db.close();
    }

}