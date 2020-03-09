//package com.zjut.travels.db;
//
//import android.content.Context;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//
//import androidx.annotation.Nullable;
//
///**
// * @author imotto
// * @version 1.0
// * a means for the use of SQLite
// */
//public class DBOpenHelper extends SQLiteOpenHelper {
//    public static final String CREATE_USER = "create table user ("
//            //primary key设置为主键，autoincrement关键字表示该列是自增长的
//            + "userid integer primary key autoincrement,"
//            + "username text,"
//            + "password text,"
//            + "gender text,"
//            + "email text)";
//    public static final String CREATE_SELLER = "create table seller ("+
//            "sellerid integer primary key autoincrement,"
//            + "password text,"
//            +"sellertype text,"
//            + "sellername text)";
//    public static final String CREATE_ADMIN = "create table viewspot ("+
//            " adminid integer primary key autoincrement,"
//            + "password text)";
//    public static final String CREATE_VIEWSPOT = "create table viewspot ("+
//            "viewid integer primary key autoincrement,"
//            + "viewname text,"
//            + "viewtype text)";
//    public static final String CREATE_GOODS = "create table goods ("+
//            "goodsid integer primary key autoincrement,"
//            + "sellerid integer,"
//            + "unitprice real,"
//            + "goodstype text,"
//            + "goodsname text)";
//
//    public DBOpenHelper(Context context,String name) {
//        super(context, name, null, 1);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        //user table
//        db.execSQL(CREATE_USER);
//        db.execSQL(CREATE_SELLER);
//        db.execSQL(CREATE_GOODS);
//        db.execSQL(CREATE_VIEWSPOT);
//        db.execSQL(CREATE_ADMIN);
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("drop table if exists user");
//        db.execSQL("drop table if exists  seller");
//        db.execSQL("drop table if exists viewspot");
//        db.execSQL("drop table if exists  goods");
//        db.execSQL("drop table if exists admin");
//        onCreate(db);
//    }
//}
