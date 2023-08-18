package com.fatscompany.bookseftonline.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.fatscompany.bookseftonline.Entitis.User;

import java.util.List;

@Dao
public interface UserDAO {
    @Query("SELECT * FROM User")
    List<User> selectAll();

    @Query("SELECT * FROM User WHERE id=:id")
    User findById(String id);

    @Query("SELECT * FROM USER WHERE username=:username AND password = :password")
    User checkUser(String username, String password);
    @Insert
    void insert(User... users);

    @Update
    void update(User... users);

    @Delete
    void delete(User... users);
}