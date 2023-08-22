package com.fatscompany.bookseftonline;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.fatscompany.bookseftonline.Entitis.Book;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import Adapter.BookSearchAdapter;

public class CategoryBookResult extends AppCompatActivity {
    List<Book> bookListWithCategory;
    Adapter.CategoryBookResult categoryBookResult;
    private RecyclerView rcvBookCategoryResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_book_result);

        rcvBookCategoryResult = findViewById(R.id.rcvCategoryBook);

        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                AppDatabase database = AppDatabase.getInstance(CategoryBookResult.this);

                database.runInTransaction(new Runnable() {
                    @Override
                    public void run() {

                        bookListWithCategory = database.bookDao().getBooksInCategory("History");
                        if (bookListWithCategory != null) {
                            CategoryBookResult.this.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    categoryBookResult = new Adapter.CategoryBookResult(CategoryBookResult.this, bookListWithCategory);

                                    rcvBookCategoryResult.setAdapter(categoryBookResult);
                                }
                            });
                        }
                    }
                });
            }
        });

    }
}