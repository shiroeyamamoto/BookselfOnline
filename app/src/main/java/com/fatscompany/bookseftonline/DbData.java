package com.fatscompany.bookseftonline;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.fatscompany.bookseftonline.DAO.BookDAO;
import com.fatscompany.bookseftonline.DAO.CategoryDAO;
import com.fatscompany.bookseftonline.DAO.InventoryDAO;
import com.fatscompany.bookseftonline.DAO.OrderDetailDAO;
import com.fatscompany.bookseftonline.DAO.PublishersDAO;
import com.fatscompany.bookseftonline.DAO.SaleOrderDAO;
import com.fatscompany.bookseftonline.DAO.UserDAO;
import com.fatscompany.bookseftonline.Entitis.Book;
import com.fatscompany.bookseftonline.Entitis.Category;
import com.fatscompany.bookseftonline.Entitis.Inventory;
import com.fatscompany.bookseftonline.Entitis.OrderDetail;
import com.fatscompany.bookseftonline.Entitis.Publishers;
import com.fatscompany.bookseftonline.Entitis.SaleOrder;
import com.fatscompany.bookseftonline.Entitis.User;
import com.fatscompany.bookseftonline.databinding.ActivityDbDataBinding;
import com.fatscompany.bookseftonline.databinding.ActivitySignUpAppBinding;

import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class DbData extends AppCompatActivity {
    ActivityDbDataBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDbDataBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.btnClick.setOnClickListener(v -> {
            Executor executor = Executors.newSingleThreadExecutor();
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    AppDatabase database = AppDatabase.getInstance(DbData.this);

                    database.runInTransaction(new Runnable() {
                        @Override
                        public void run() {
                            insertInitialData();
                        }
                    });
                }
            });

        });


    }

    private void insertInitialData() {
        AppDatabase database = AppDatabase.getInstance(DbData.this);

        //USER
        User user1 = new User("user1", "pass1", "First 1", "Last 1", "email1@example.com", "123456789", false, "role1");
        User user2 = new User("user2", "pass2", "First 2", "Last 2", "email2@example.com", "987654321", false, "role2");
        UserDAO userDao = database.userDao();
        userDao.insert(user1, user2);



        CategoryDAO cateDao = database.categoryDao();
        cateDao.insert(new Category("Mystery", "Books with suspense and puzzles"));
        cateDao.insert(new Category("Fantasy", "Books set in imaginary worlds"));
        cateDao.insert(new Category("Romance", "Books about love and relationships"));

        PublishersDAO pb = database.publishersDao();
        pb.insertPublisher(new Publishers("Publisher A"));
        pb.insertPublisher(new Publishers("Publisher B"));
        pb.insertPublisher(new Publishers("Publisher C"));

        Book book1 = new Book("The Last Thing He Told Me: A Novel", "123", 16.99, "KhoaBeo", 2023, true, 1, 1
                , "https://m.media-amazon.com/images/I/91qHnMH6v7L._AC_UL320_.jpg");
        Book book2 = new Book("The Wager: A Tale of Shipwreck, Mutiny and Murder", "123", 16.99, "KhoaBeo", 2023, true, 1, 1, "https://m.media-amazon.com/images/I/91qXDU9TXvL._AC_UL320_.jpg");
        Book book3 = new Book("The Covenant of Water ", "123", 16.99, "KhoaBeo", 2023, true, 1, 1, "https://m.media-amazon.com/images/I/91b7tm523VL._AC_UL320_.jpg");
        BookDAO bookDao = database.bookDao();
        bookDao.insert(book1, book2, book3);

        InventoryDAO ivo = database.inventoryDao();
        ivo.insertInventory(new Inventory(10, 1));
        ivo.insertInventory(new Inventory(23, 2));
        ivo.insertInventory(new Inventory(33, 3));

        SaleOrderDAO sod = database.saleOrderDao();
        sod.insertSaleOrder(new SaleOrder(new Date(), 1));
        sod.insertSaleOrder(new SaleOrder(new Date(), 2));
        sod.insertSaleOrder(new SaleOrder(new Date(), 1));

        OrderDetailDAO ord = database.orderDetailDao();
        ord.insertOrderDetail(new OrderDetail("Order 1", 1, 1, 5));
        ord.insertOrderDetail(new OrderDetail("Order 2", 2, 1, 3));
        ord.insertOrderDetail(new OrderDetail("Order 3", 3, 2, 2));
    }

}