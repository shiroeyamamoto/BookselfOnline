package com.fatscompany.bookseftonline;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.fatscompany.bookseftonline.Admin.HomeFragment;
import com.fatscompany.bookseftonline.Admin.ProfileFragment;
import com.fatscompany.bookseftonline.Admin.ToolsFragment;
import com.fatscompany.bookseftonline.databinding.AcitvityAdminBinding;
public class AdminActivity extends AppCompatActivity {

    AcitvityAdminBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = AcitvityAdminBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // mac dinh la home
        replaceFragment(new HomeFragment());


        binding.adminBottomNav.setOnItemSelectedListener(item -> {
            if(item.getItemId() == 0){
                replaceFragment(new HomeFragment());
                return true;
            }
            else if (item.getItemId() == 1){
                replaceFragment(new ToolsFragment());
                return true;
            }
            else if (item.getItemId() == 2){
                replaceFragment(new ProfileFragment());
                return true;
            }
            return true;
        });
    }

    private void replaceFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment).commit();
    }
}