package com.fatscompany.bookseftonline.Database;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;

import java.sql.Time;

public class DatabaseAdapter extends BaseAdapter {
    private DatabaseController dbHelper;
    private SQLiteDatabase database;

    public DatabaseAdapter(Context context) {
        dbHelper = new DatabaseController(context);
    }

    public void open() throws SQLException {
       database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public void CheckUser(String username, String pw){
        dbHelper.CheckUser(username,pw);
    }

    public void InsertUser(String username, String pass, String firstName, String lastName,
                           String email, String phone, Boolean active, String userole){
        dbHelper.InsertUser(username, pass, firstName,lastName, email, phone,active, userole);
    }

    public void InsertBook(String title, String decription, double price, String author, String pubYear,
                           Boolean condition, int cateId, int publisherId, String image){
        dbHelper.InsertBook(title, decription, price,author, pubYear, condition,cateId, publisherId,image);
    }

    public void InsertPublisher(String username){
        dbHelper.InsertPublisher(username);
    }

    public void InsertCategory(String cateName, String decription){
        dbHelper.InsertCategory(cateName, decription);
    }

    public void InsertSaleOrder(Time createdDate, int userId){
        dbHelper.InsertSaleOrder(createdDate, userId);
    }

    public void InsertInventory(int stock, int bookId){
        dbHelper.InsertInventory(stock,bookId);
    }

    public void InsertOrderDetail(String name, int bookId, int saleOrderId, int amount){
        dbHelper.InsertOrderDetail(name, bookId, saleOrderId,amount);
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
