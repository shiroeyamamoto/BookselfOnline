package com.fatscompany.bookseftonline.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import androidx.room.Delete;

import com.fatscompany.bookseftonline.Entitis.SaleOrder;

import java.util.List;

@Dao
public interface SaleOrderDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertSaleOrder(SaleOrder saleOrder);

    @Update
    void updateSaleOrder(SaleOrder saleOrder);

    @Delete
    void deleteSaleOrder(SaleOrder saleOrder);

    @Query("SELECT * FROM sale_order")
    List<SaleOrder> getAllSaleOrders();

}
