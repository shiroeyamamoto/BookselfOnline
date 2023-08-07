package com.fatscompany.bookseftonline.Database;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;

public class DatabaseAdapter extends BaseAdapter {
    private DatabaseController dbHelper;
    private SQLiteDatabase database;

    public DatabaseAdapter(Context context) {
        dbHelper = new DatabaseController(context);
    }

    private void open() throws SQLException {
       database = dbHelper.getWritableDatabase();
    }

    private void close() {
        dbHelper.close();
    }

    public void checkUser(String username, String pw){
        dbHelper.checkUser(username,pw);
    }

    public void insertUser(String username, String pass, String firstName, String lastName, String email, String phone){
        dbHelper.insertUser(username, pass, firstName,lastName, email, phone);
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
