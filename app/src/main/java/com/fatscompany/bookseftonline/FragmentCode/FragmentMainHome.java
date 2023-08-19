package com.fatscompany.bookseftonline.FragmentCode;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.fatscompany.bookseftonline.AppDatabase;
import com.fatscompany.bookseftonline.DbData;
import com.fatscompany.bookseftonline.Entitis.Book;
import com.fatscompany.bookseftonline.Entitis.Category;
import com.fatscompany.bookseftonline.MainActivity;
import com.fatscompany.bookseftonline.R;
import com.fatscompany.bookseftonline.databinding.ActivityMainBinding;
import com.fatscompany.bookseftonline.databinding.FragmentMainHomeBinding;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import Adapter.BookAdapter;
import Adapter.CategoryAdapter;


public class FragmentMainHome extends Fragment {


    public FragmentMainHome() {
    }

    private List<Book> myLBook;
    private List<Category> cates;

    private BookAdapter bookAdapter;
    private CategoryAdapter categoryAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_home, container, false);

        // Thiết lập LayoutManager
        LinearLayoutManager bookLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager categoryLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);

        // Tìm RecyclerView bằng findViewById
        RecyclerView rcv = view.findViewById(R.id.rcvDisplayBook);
        RecyclerView rcvCate = view.findViewById(R.id.rcvCategory);
        rcv.setLayoutManager(bookLayoutManager);
        rcvCate.setLayoutManager(categoryLayoutManager);


        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                AppDatabase database = AppDatabase.getInstance(getActivity());

                database.runInTransaction(new Runnable() {
                    @Override
                    public void run() {
                        myLBook = database.bookDao().getAllBook();
                        cates = database.categoryDao().selectAll();

                        if (myLBook != null || cates != null) {
                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    bookAdapter = new BookAdapter(getContext(), myLBook);
                                    categoryAdapter = new CategoryAdapter(getContext(), cates);
                                    rcvCate.setAdapter(categoryAdapter);
                                    rcv.setAdapter(bookAdapter);

                                }
                            });
                        }
                    }
                });
            }
        });

        return view;
    }


}