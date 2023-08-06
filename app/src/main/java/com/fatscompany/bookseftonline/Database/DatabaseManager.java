package com.fatscompany.bookseftonline.Database;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseManager {
    private DatabaseController dbHelper;
    private SQLiteDatabase database;

    public DatabaseManager(Context context) {
        dbHelper = new DatabaseController(context);
    }

    public void open() throws SQLException {
       database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

}
