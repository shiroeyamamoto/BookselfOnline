package com.fatscompany.bookseftonline.Entitis;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;


@Entity(tableName = "book",
        foreignKeys = {
                @ForeignKey(entity = Category.class, parentColumns = "id", childColumns = "category_id", onDelete = ForeignKey.NO_ACTION, onUpdate = ForeignKey.NO_ACTION),
                @ForeignKey(entity = Publishers.class, parentColumns = "id", childColumns = "publisher_id", onDelete = ForeignKey.NO_ACTION, onUpdate = ForeignKey.NO_ACTION)
        })
public class Book {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "title")
    private String title;
    @ColumnInfo(name = "description")
    private String description;
    @ColumnInfo(name = "price")
    private double price;
    @ColumnInfo(name = "authors")
    private String authors;
    @ColumnInfo(name = "publication_year")
    private String publicationYear;
    @ColumnInfo(name = "condition")
    private boolean condition;
    @ColumnInfo(name = "category_id")
    private int categoryId;
    @ColumnInfo(name = "publisher_id")
    private int publisherId;
    @ColumnInfo(name = "image")
    private String image;

}