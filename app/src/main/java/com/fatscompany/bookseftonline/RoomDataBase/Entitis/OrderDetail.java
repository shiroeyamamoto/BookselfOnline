package com.fatscompany.bookseftonline.Entitis;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "order_detail",
        foreignKeys = {
                @ForeignKey(entity = SaleOrder.class, parentColumns = "id", childColumns = "saleOrderId", onDelete = ForeignKey.NO_ACTION, onUpdate = ForeignKey.NO_ACTION),
                @ForeignKey(entity = Book.class, parentColumns = "id", childColumns = "bookId", onDelete = ForeignKey.NO_ACTION, onUpdate = ForeignKey.NO_ACTION)
        })
public class OrderDetail {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "book_id")
    private int bookId;

    @ColumnInfo(name = "sale_order_ id")
    private int saleOrderId;

    @ColumnInfo(name = "amount")
    private int amount;

    // Constructors, getters, setters...
}