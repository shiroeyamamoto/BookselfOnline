package com.fatscompany.bookseftonline.Database;

import static com.fatscompany.bookseftonline.Database.Settings.TABLE_NAME_06;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseController extends SQLiteOpenHelper {
    static final String DATABASE_NAME = "bookseftdb.db";
    static final int DATABASE_VERSION = 1;

    //TABLE book
    private static final String TABLE_NAME = "book";

    public DatabaseController(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //q = "CREATE TABLE "+Settings.TABLE_NAME_01+"( "+Settings.COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "+Settings.COLUMN_TITLE+" TEXT NOT NULL, "+Settings.COLUMN_DECRIPTION+" TEXT NOT NULL, "+Settings.COLUMN_PRICE+" DOUBLE NOT NULL, "+Settings.COLUMN_AUTHORS+" TEXT, "+Settings.COLUMN_PUBLICATION_YEAR+" TEXT, "+Settings.COLUMN_CONDITION+" BOOLEAN NOT NULL, "+Settings.COLUMN_CATEGORY_ID+" INTEGER NOT NULL, "+Settings.COLUMN_PUBLISHER_ID+" INTEGER NOT NULL, "+Settings.COLUMN_IMAGE+" TEXT, CONSTRAINT "+Settings.TABLE_NAME_07+"_"+Settings.TABLE_NAME_01+" FOREIGN KEY ("+Settings.COLUMN_PUBLISHER_ID+") REFERENCES "+Settings.TABLE_NAME_07+" ("+Settings.COLUMN_ID+") ON DELETE No action ON UPDATE No action, CONSTRAINT "+Settings.TABLE_NAME_02+"_"+Settings.TABLE_NAME_01+" FOREIGN KEY ("+Settings.COLUMN_CATEGORY_ID+") REFERENCES "+Settings.TABLE_NAME_02+" ("+Settings.COLUMN_ID+") ON DELETE No action ON UPDATE No action);    CREATE TABLE "+Settings.TABLE_NAME_02+" ("+Settings.COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "+Settings.COLUMN_NAME+" TEXT, "+Settings.COLUMN_DECRIPTION+" TEXT);                CREATE TABLE "+Settings.TABLE_NAME_03+"( "+Settings.COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "+Settings.COLUMN_STOCK+" INTEGER NOT NULL, "+Settings.COLUMN_BOOK_ID+ " INTEGER NOT NULL, CONSTRAINT "+Settings.TABLE_NAME_01+"_"+Settings.TABLE_NAME_03+" FOREIGN KEY ("+Settings.COLUMN_BOOK_ID+") REFERENCES "+Settings.TABLE_NAME_01+" ("+Settings.COLUMN_ID+") ON DELETE No action ON UPDATE No action);                CREATE TABLE "+Settings.TABLE_NAME_04+"( "+Settings.COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "+Settings.COLUMN_NAME+" TEXT NOT NULL, "+Settings.COLUMN_BOOK_ID+" INTEGER NOT NULL, sale_orderid INTEGER NOT NULL, "+Settings.COLUMN_AMOUNT+" INTEGER NOT NULL, CONSTRAINT "+Settings.TABLE_NAME_05+"_"+Settings.TABLE_NAME_04+" FOREIGN KEY ("+Settings.COLUMN_SALEORDER_ID+") REFERENCES "+Settings.TABLE_NAME_05+" ("+Settings.COLUMN_ID+") ON DELETE No action ON UPDATE No action, CONSTRAINT "+Settings.TABLE_NAME_01+"_"+Settings.TABLE_NAME_04+" FOREIGN KEY ("+ Settings.COLUMN_BOOK_ID +") REFERENCES "+Settings.TABLE_NAME_01+" ("+Settings.COLUMN_ID+") ON DELETE No action ON UPDATE No action                CREATE TABLE "+Settings.TABLE_NAME_07+" ("+Settings.COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "+Settings.COLUMN_NAME+" TEXT NOT NULL);                CREATE TABLE "+Settings.TABLE_NAME_05+"( id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "+Settings.COLUMN_CREATED_DATE+" DATETIME NOT NULL, "+Settings.COLUMN_USER_ID+" INTEGER NOT NULL, CONSTRAINT "+Settings.TABLE_NAME_06+"_"+Settings.TABLE_NAME_05+" FOREIGN KEY ("+Settings.COLUMN_USER_ID+") REFERENCES "+Settings.TABLE_NAME_06+" ("+Settings.COLUMN_ID+") ON DELETE No action ON UPDATE No action);                CREATE TABLE "+Settings.TABLE_NAME_06+"( id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "+Settings.COLUMN_USERNAME+" TEXT NOT NULL, "+Settings.COLUMN_PASSWORD+" TEXT NOT NULL, "+Settings.COLUMN_FIRSTNAME+" TEXT NOT NULL, "+Settings.COLUMN_LASTNAME+" TEXT NOT NULL, "+Settings.COLUMN_EMAIL+" TEXT, "+Settings.COLUMN_PHONE+" TEXT, "+Settings.COLUMN_ACTIVE+" BOOLEAN NOT NULL, "+Settings.COLUMN_USEROLE+" TEXT NOT NULL);";
        String q;
        //String q = "CREATE TABLE book( id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, title TEXT NOT NULL, decription TEXT NOT NULL, price DOUBLE NOT NULL, authors TEXT, publication_year TEXT, condition BOOLEAN NOT NULL, category_id INTEGER NOT NULL, publisher_id INTEGER NOT NULL, image TEXT, CONSTRAINT publishers_book FOREIGN KEY (publisher_id) REFERENCES publishers (id) ON DELETE No action ON UPDATE No action, CONSTRAINT category_book FOREIGN KEY (category_id) REFERENCES category (id) ON DELETE No action ON UPDATE No action);                CREATE TABLE category (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, name TEXT, decription TEXT);                CREATE TABLE inventory( id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, stock INTEGER NOT NULL, book_id INTEGER NOT NULL, CONSTRAINT book_inventory FOREIGN KEY (book_id) REFERENCES book (id) ON DELETE No action ON UPDATE No action);                CREATE TABLE order_detail( id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, name TEXT NOT NULL, book_id INTEGER NOT NULL, sale_orderid INTEGER NOT NULL, amount INTEGER NOT NULL, CONSTRAINT sale_order_order_detail FOREIGN KEY (sale_orderid) REFERENCES sale_order (id) ON DELETE No action ON UPDATE No action, CONSTRAINT book_order_detail FOREIGN KEY (book_id) REFERENCES book (id) ON DELETE No action ON UPDATE No action                CREATE TABLE publishers (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, name TEXT NOT NULL);                CREATE TABLE sale_order( id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, created_date DATETIME NOT NULL, user_id INTEGER NOT NULL, CONSTRAINT user_sale_order FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE No action ON UPDATE No action);                CREATE TABLE user( id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, username TEXT NOT NULL, password TEXT NOT NULL, first_name TEXT NOT NULL, last_name TEXT NOT NULL, email TEXT, phone TEXT, active BOOLEAN NOT NULL, user_role TEXT NOT NULL);";

        q = "CREATE TABLE " + Settings.TABLE_NAME_02 + " (" + Settings.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " + Settings.COLUMN_NAME + " TEXT, " + Settings.COLUMN_DECRIPTION + " TEXT);";
        db.execSQL(q);
        q = "CREATE TABLE " + Settings.TABLE_NAME_07 + " (" + Settings.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " + Settings.COLUMN_NAME + " TEXT NOT NULL);";
        db.execSQL(q);
        q = "CREATE TABLE " + Settings.TABLE_NAME_01 + "( " + Settings.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " + Settings.COLUMN_TITLE + " TEXT NOT NULL, " + Settings.COLUMN_DECRIPTION + " TEXT NOT NULL, " + Settings.COLUMN_PRICE + " DOUBLE NOT NULL, " + Settings.COLUMN_AUTHORS + " TEXT, " + Settings.COLUMN_PUBLICATION_YEAR + " TEXT, " + Settings.COLUMN_CONDITION + " BOOLEAN NOT NULL, " + Settings.COLUMN_CATEGORY_ID + " INTEGER NOT NULL, " + Settings.COLUMN_PUBLISHER_ID + " INTEGER NOT NULL, " + Settings.COLUMN_IMAGE + " TEXT, CONSTRAINT " + Settings.TABLE_NAME_07 + "_" + Settings.TABLE_NAME_01 + " FOREIGN KEY (" + Settings.COLUMN_PUBLISHER_ID + ") REFERENCES " + Settings.TABLE_NAME_07 + " (" + Settings.COLUMN_ID + ") ON DELETE No action ON UPDATE No action, CONSTRAINT " + Settings.TABLE_NAME_02 + "_" + Settings.TABLE_NAME_01 + " FOREIGN KEY (" + Settings.COLUMN_CATEGORY_ID + ") REFERENCES " + Settings.TABLE_NAME_02 + " (" + Settings.COLUMN_ID + ") ON DELETE No action ON UPDATE No action);";
        db.execSQL(q);
        q = "CREATE TABLE " + TABLE_NAME_06 + "( id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " + Settings.COLUMN_USERNAME + " TEXT NOT NULL, " + Settings.COLUMN_PASSWORD + " TEXT NOT NULL, " + Settings.COLUMN_FIRSTNAME + " TEXT NOT NULL, " + Settings.COLUMN_LASTNAME + " TEXT NOT NULL, " + Settings.COLUMN_EMAIL + " TEXT, " + Settings.COLUMN_PHONE + " TEXT, " + Settings.COLUMN_ACTIVE + " BOOLEAN NOT NULL, " + Settings.COLUMN_USEROLE + " TEXT NOT NULL);";
        db.execSQL(q);
        q = "CREATE TABLE " + Settings.TABLE_NAME_05 + "( id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " + Settings.COLUMN_CREATED_DATE + " DATETIME NOT NULL, " + Settings.COLUMN_USER_ID + " INTEGER NOT NULL, CONSTRAINT " + TABLE_NAME_06 + "_" + Settings.TABLE_NAME_05 + " FOREIGN KEY (" + Settings.COLUMN_USER_ID + ") REFERENCES " + TABLE_NAME_06 + " (" + Settings.COLUMN_ID + ") ON DELETE No action ON UPDATE No action);";
        db.execSQL(q);
        q = "CREATE TABLE " + Settings.TABLE_NAME_04 + "( " + Settings.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " + Settings.COLUMN_NAME + " TEXT NOT NULL, " + Settings.COLUMN_BOOK_ID + " INTEGER NOT NULL, sale_orderid INTEGER NOT NULL, " + Settings.COLUMN_AMOUNT + " INTEGER NOT NULL, CONSTRAINT " + Settings.TABLE_NAME_05 + "_" + Settings.TABLE_NAME_04 + " FOREIGN KEY (" + Settings.COLUMN_SALEORDER_ID + ") REFERENCES " + Settings.TABLE_NAME_05 + " (" + Settings.COLUMN_ID + ") ON DELETE No action ON UPDATE No action, CONSTRAINT " + Settings.TABLE_NAME_01 + "_" + Settings.TABLE_NAME_04 + " FOREIGN KEY (" + Settings.COLUMN_BOOK_ID + ") REFERENCES " + Settings.TABLE_NAME_01 + " (" + Settings.COLUMN_ID + ") ON DELETE No action ON UPDATE No action);";
        db.execSQL(q);
        q = "CREATE TABLE " + Settings.TABLE_NAME_03 + "( " + Settings.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " + Settings.COLUMN_STOCK + " INTEGER NOT NULL, " + Settings.COLUMN_BOOK_ID + " INTEGER NOT NULL, CONSTRAINT " + Settings.TABLE_NAME_01 + "_" + Settings.TABLE_NAME_03 + " FOREIGN KEY (" + Settings.COLUMN_BOOK_ID + ") REFERENCES " + Settings.TABLE_NAME_01 + " (" + Settings.COLUMN_ID + ") ON DELETE No action ON UPDATE No action);";
        db.execSQL(q);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
    public void insertUser(String username, String pass, String firstName, String lastName, String email, String phone) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Settings.COLUMN_USERNAME, username);
        values.put(Settings.COLUMN_PASSWORD, pass);
        values.put(Settings.COLUMN_FIRSTNAME, firstName);
        values.put(Settings.COLUMN_LASTNAME, lastName);
        values.put(Settings.COLUMN_EMAIL, email);
        values.put(Settings.COLUMN_PHONE, phone);
        values.put(Settings.COLUMN_ACTIVE, "1");
        values.put(Settings.COLUMN_USEROLE, "NV");
        long newRowId = db.insert(Settings.TABLE_NAME_06, null, values);
        db.close();
    }

    public boolean checkUser(String username, String pw) {
        SQLiteDatabase db = this.getReadableDatabase();
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("SELECT * FROM " + Settings.TABLE_NAME_06 +
                        " WHERE " + Settings.COLUMN_USERNAME + " = ? AND " + Settings.COLUMN_PASSWORD + " = ?",
                new String[]{username, pw});
        return cursor.getCount() > 0;
    }
}
