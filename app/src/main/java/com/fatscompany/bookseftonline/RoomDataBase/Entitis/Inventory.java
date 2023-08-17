package com.fatscompany.bookseftonline.Entitis;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "Inventory", foreignKeys = {
        @ForeignKey(entity = Book.class, parentColumns = "id", childColumns = "bookId", onDelete = ForeignKey.NO_ACTION, onUpdate = ForeignKey.NO_ACTION)})
public class Inventory {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "stock")
    private int stock;

    @ColumnInfo(name = "book_id")
    private int bookId;

}
