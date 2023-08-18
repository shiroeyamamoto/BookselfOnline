package com.fatscompany.bookseftonline.FragmentCode;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.fatscompany.bookseftonline.Database.DatabaseAdapter;
import com.fatscompany.bookseftonline.MainActivity;
import com.fatscompany.bookseftonline.R;
import com.fatscompany.bookseftonline.Utils.SignUp;
import com.fatscompany.bookseftonline.databinding.AddUserBinding;
import com.fatscompany.bookseftonline.databinding.FragmentAdminStatisticBinding;
import com.fatscompany.bookseftonline.databinding.FragmentAdminUserManagementBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AdminUserManagementFrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AdminUserManagementFrag extends Fragment {

    private FragmentAdminUserManagementBinding binding;
    private AddUserBinding addUserBinding;
    private DatabaseAdapter dbAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentAdminUserManagementBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        binding.btnCreateUser.setOnClickListener(v->{
            showAddUserContent();
        });
        return view;
    }

    private void showAddUserContent() {
        addUserBinding = AddUserBinding.inflate(getLayoutInflater());
        // Get the root view of the inflated layout
        View addUserView = addUserBinding.getRoot();
        binding.countainerFrameLayout.removeAllViews();
        // Add the inflated layout to a container in the fragment's layout``
        binding.countainerFrameLayout.addView(addUserView);

        addUserBinding.btnSave.setOnClickListener(v->{
            btnsaveAddUserClick();
        });
    }

    private void btnsaveAddUserClick(){
        String uName = addUserBinding.txtuName.getText().toString();
        String pw  = addUserBinding.txtpassword.getText().toString();
        String role = addUserBinding.txtRole.getText().toString();
        String fName  = addUserBinding.txtfName.getText().toString();
        String lName = addUserBinding.txtfName.getText().toString();
        String mail  = addUserBinding.txtMail.getText().toString();
        String sdt = addUserBinding.txtSDT.getText().toString();
        Boolean active = true;
        if (uName.isEmpty() || pw.isEmpty()){
            Toast.makeText(requireContext(), "Please fill out the fields", Toast.LENGTH_SHORT).show();
        }
        else{
            try {
                dbAdapter = new DatabaseAdapter(requireContext());
                dbAdapter.InsertUser(uName, pw, fName, lName, mail, sdt, active, role);
                Toast.makeText(requireContext(), "Added successfully", Toast.LENGTH_SHORT).show();

            }catch (Exception ex){
                Toast.makeText(requireContext(), "Unknown errors", Toast.LENGTH_SHORT).show();
            }
        }
    }
}