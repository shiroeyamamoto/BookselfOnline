package com.fatscompany.bookseftonline.Entitis;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "sale_order",
        foreignKeys = @ForeignKey(entity = User.class, parentColumns = "id", childColumns = "user_id", onDelete = ForeignKey.NO_ACTION, onUpdate = ForeignKey.NO_ACTION))
public class SaleOrder {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "created_date")
    private String createdDate;

    @ColumnInfo(name = "user_id")
    private int userId;

    // Constructors, getters, setters...
}
