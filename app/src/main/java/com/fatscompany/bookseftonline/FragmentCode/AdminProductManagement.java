package com.fatscompany.bookseftonline.FragmentCode;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.fatscompany.bookseftonline.AdminActivity;
import com.fatscompany.bookseftonline.AppDatabase;
import com.fatscompany.bookseftonline.Database.DatabaseAdapter;
import com.fatscompany.bookseftonline.Entitis.User;
import com.fatscompany.bookseftonline.Entitis.Book;
import com.fatscompany.bookseftonline.R;
import com.fatscompany.bookseftonline.databinding.AddUserBinding;
import com.fatscompany.bookseftonline.databinding.FragmentAdminProductManagementBinding;
import com.fatscompany.bookseftonline.databinding.UpdateUserBinding;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;


import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import Adapter.BookAdapter;
import Adapter.UserAdapter;
import Adapter.iClickItemBookListener;
import Adapter.iClickItemUserListener;


public class AdminProductManagement extends Fragment {

    private FragmentAdminProductManagementBinding binding;
    private AddUserBinding addUserBinding;
    private DatabaseAdapter dbAdapter;

    private List<Book> bookList;

    private BookAdapter bookAdapter;

    private AdminActivity adminActivity;

    private iClickItemUserListener listener;

    private UpdateUserBinding updateBookBinding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentAdminProductManagementBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        binding.btnCreateUser.setOnClickListener(v -> {
            showAddUserContent();
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        RecyclerView rcv = view.findViewById(R.id.userRecyclerView);
        rcv.setLayoutManager(linearLayoutManager);

        adminActivity = (AdminActivity) getActivity();
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                AppDatabase database = AppDatabase.getInstance(getActivity());
                database.runInTransaction(new Runnable() {
                    @Override
                    public void run() {
                        bookList = database.bookDao().getAllBook();

                        if (bookList != null) {
                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    bookAdapter = new BookAdapter(bookList, getContext(), new iClickItemBookListener() {
                                        @Override
                                        public void onClickItemBook(Book book) {
                                            showUpdateContent(book);
                                        }
                                    });
                                    rcv.setAdapter(bookAdapter);
                                }
                            });
                        }
                    }
                });
            }
        });

        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(rcv);
        return view;
    }

    public void showUpdateContent(Book book){
        updateBookBinding = UpdateUserBinding.inflate(getLayoutInflater());
        TextInputEditText txtId = updateBookBinding.txtuName2;
        TextInputEditText txtTitle = updateBookBinding.txtpassword2;
        TextInputEditText txtDescription = updateBookBinding.txtfName2;
        TextInputEditText txtAuthors = updateBookBinding.txtlName2;
        TextInputEditText txtImage = updateBookBinding.txtMail2;
        TextInputEditText txtPublicationYear = updateBookBinding.txtRole2;
        TextInputEditText txtSoldBook = updateBookBinding.txtSDT2;

        txtId.setText(book.id);
        txtTitle.setText(book.getTitle());
        txtDescription.setText(book.getDescription());
        txtAuthors.setText(book.getAuthors());
        txtImage.setText(book.getImage());
        txtPublicationYear.setText(book.getPublicationYear());
        txtSoldBook.setText(book.getSoldBook());

        View updateUserView = updateBookBinding.getRoot();
        binding.countainerFrameLayout.removeAllViews();
        binding.countainerFrameLayout.addView(updateUserView);

        updateBookBinding.btnUpdate.setOnClickListener(v -> {
            book.setTitle(txtTitle.getText().toString());
            book.setDescription(txtDescription.getText().toString());
            book.setAuthors(txtAuthors.getText().toString());
            book.setImage(txtImage.getText().toString());
            book.setPublicationYear(Integer.parseInt(txtPublicationYear.getText().toString()));
            book.setSoldBook(Integer.parseInt(txtSoldBook.getText().toString()));

            AppDatabase db = AppDatabase.getInstance(getActivity());
            Executor executor = Executors.newSingleThreadExecutor();
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    db.runInTransaction(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                db.bookDao().update(book);
                                Log.d("UpdateUser", "User updated successfully");
                                getActivity().runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(requireContext(), "User updated successfully", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            } catch (Exception ex) {
                                Log.e("UpdateUser", "Error updating user: " + ex.getMessage());
                            }
                        }
                    });
                }
            });
        });
    }

    private void showDeleteUserContent(){

    }
    private void showAddUserContent() {
        addUserBinding = AddUserBinding.inflate(getLayoutInflater());
        // Get the root view of the inflated layout
        View addUserView = addUserBinding.getRoot();
        binding.countainerFrameLayout.removeAllViews();
        // Add the inflated layout to a container in the fragment's layout``
        binding.countainerFrameLayout.addView(addUserView);

        addUserBinding.btnSave.setOnClickListener(v -> {
            btnsaveAddUserClick();
            adminActivity.replaceFragment(new AdminUserManagementFrag());
        });
    }



    private void btnsaveAddUserClick() {
        String uName = addUserBinding.txtuName.getText().toString();
        String pw = addUserBinding.txtpassword.getText().toString();
        String role = addUserBinding.txtRole.getText().toString();
        String fName = addUserBinding.txtfName.getText().toString();
        String lName = addUserBinding.txtfName.getText().toString();
        String mail = addUserBinding.txtMail.getText().toString();
        String sdt = addUserBinding.txtSDT.getText().toString();
        Boolean active = true;
        if (uName.isEmpty() || pw.isEmpty()) {
            Toast.makeText(requireContext(), "Please fill out the fields", Toast.LENGTH_SHORT).show();
        } else {
            AppDatabase db = AppDatabase.getInstance(requireContext());
            Executor executor = Executors.newSingleThreadExecutor();
            executor.execute(new Runnable() {
                @Override
                public void run() {

                    db.runInTransaction(new Runnable() {
                        @Override
                        public void run() {
                            User user = new User(uName, pw, fName, lName, mail, sdt, active, role);

                            try {
                                db.userDao().insert(user);
                            }
                            catch (Exception ex){

                            }
                        }
                    });
                }
            });
        }
    }

    //swipe to delete item SimpleCallback(Drag=0 - false, Swipe dir - left)
    ItemTouchHelper.SimpleCallback callback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            Snackbar snackbar = Snackbar.make(binding.countainerFrameLayout, "Item deleted successfully", Snackbar.LENGTH_LONG);
            snackbar.show();

            int position = viewHolder.getAdapterPosition();
            Book bookDeleted = bookList.get(position);

            bookList.remove(viewHolder.getAdapterPosition());
            bookAdapter.notifyDataSetChanged();

            AppDatabase db = AppDatabase.getInstance(getActivity());
            Executor executor = Executors.newSingleThreadExecutor();
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    db.runInTransaction(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                db.bookDao().delete(bookDeleted);
                                Log.d("UpdateUser", "User delete successfully");
                                getActivity().runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {

                                    }
                                });
                            } catch (Exception ex) {
                                Log.e("UpdateUser", "Error deleting user: " + ex.getMessage());
                            }
                        }
                    });
                }
            });
        }
    };
}