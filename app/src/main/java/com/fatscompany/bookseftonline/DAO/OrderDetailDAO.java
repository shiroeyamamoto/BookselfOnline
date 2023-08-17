package com.fatscompany.bookseftonline.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import androidx.room.Delete;

import com.fatscompany.bookseftonline.Entitis.OrderDetail;

import java.util.List;

@Dao
public interface OrderDetailDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertOrderDetail(OrderDetail orderDetail);

    @Update
    void updateOrderDetail(OrderDetail orderDetail);

    @Delete
    void deleteOrderDetail(OrderDetail orderDetail);

    @Query("SELECT * FROM order_detail")
    List<OrderDetail> getAllOrderDetails();

    @Query("SELECT * FROM order_detail WHERE id = :orderDetailId")
    OrderDetail getOrderDetailById(int orderDetailId);


}
