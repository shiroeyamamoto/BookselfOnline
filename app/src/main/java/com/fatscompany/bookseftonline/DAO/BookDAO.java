package com.fatscompany.bookseftonline.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.fatscompany.bookseftonline.Entitis.Book;

import java.util.List;
@Dao
public interface BookDAO {
    @Query("SELECT * FROM Book")
    List<Book> selectAllBook();

    @Query("SELECT * FROM Book WHERE id=:id")
    Book findById(String id);

    @Insert
    void insert(Book... books);

    @Update
    void update(Book... books);

    @Delete
    void delete(Book... books);
}
