package com.fatscompany.bookseftonline.Entitis;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

public class User {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "username")
    private String username;

    @ColumnInfo(name = "password")
    private String password;

    @ColumnInfo(name = "first_name")
    private String firstName;

    @ColumnInfo(name = "last_name")
    private String lastName;

    @ColumnInfo(name = "email")
    private String email;

    @ColumnInfo(name = "phone")
    private String phone;

    @ColumnInfo(name = "active")
    private boolean active;

    @ColumnInfo(name = "user_role")
    private String userRole;

}
