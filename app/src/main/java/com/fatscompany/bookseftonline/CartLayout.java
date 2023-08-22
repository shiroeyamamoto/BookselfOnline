package com.fatscompany.bookseftonline;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.fatscompany.bookseftonline.Entitis.OrderDetail;
import com.fatscompany.bookseftonline.Entitis.SaleOrder;
import com.fatscompany.bookseftonline.databinding.ActivityCartLayoutBinding;
import com.fatscompany.bookseftonline.databinding.ActivityCategoryBookResultBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import Adapter.OrderedBookAdapter;


public class CartLayout extends AppCompatActivity {
    private ActivityCartLayoutBinding binding;
    private RecyclerView rcvCart;
    private List<OrderDetail> orderDetailList;
    private OrderedBookAdapter orderedBookAdapter;
    private UserSessionManager sessionManager;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCartLayoutBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        rcvCart = findViewById(R.id.rcvCart);
        LinearLayoutManager cartLayoutManager = new LinearLayoutManager(CartLayout.this, LinearLayoutManager.VERTICAL, false);
        rcvCart.setLayoutManager(cartLayoutManager);

        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                AppDatabase database = AppDatabase.getInstance(CartLayout.this);

                UserSessionManager sessionManager = new UserSessionManager(CartLayout.this);
                int userCurrent = sessionManager.getUserId();
                List<SaleOrder> saleOrders = database.saleOrderDao().getAllSaleOrderByUserId(userCurrent);

                List<OrderDetail> orderDetailList = new ArrayList<>(); // Create a list to store order details

                // Duyệt qua từng đơn hàng và lấy các chi tiết đơn hàng liên quan
                for (SaleOrder saleOrder : saleOrders) {
                    List<OrderDetail> orderDetails = database.orderDetailDao().getAllOrderDetailBySaleOrderId(saleOrder.getId());
                    orderDetailList.addAll(orderDetails);
                }

                CartLayout.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        orderedBookAdapter = new OrderedBookAdapter(CartLayout.this, orderDetailList);
                        rcvCart.setAdapter(orderedBookAdapter);
                    }
                });
            }
        });
    }


}