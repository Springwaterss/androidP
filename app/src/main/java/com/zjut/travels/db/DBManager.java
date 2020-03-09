//package com.zjut.travels.db;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//
//import com.zjut.travels.VO.Seller;
//import com.zjut.travels.VO.User;
//
//import java.util.List;
//
//public class DBManager {
//    private DBOpenHelper dbOpenHelper;
//    Context context;
//
//    public DBManager(Context context) {
//        this.context = context;
//        dbOpenHelper = new DBOpenHelper(context,"zjut.db");
//    }
//    //用户表操作
//    /**
//     * add users
//     * @param user
//     */
//    public void addUser(User user){
//        SQLiteDatabase db = null;
//        ContentValues value = new ContentValues();
//        value.put("username",user.getUserName());
//        value.put("password",user.getPassword());
//        value.put("email",user.getEmail());
//        value.put("gender",user.getGender());
//        try{
//            db.insert("user",null,value);
//
//        }catch (Exception e){
//            System.out.println("Handle addUser exception");
//        }finally {
//            System.out.println("新建用户成功");
//            db.close();
//        }
//    }
//
//    /**
//     * delete user by userId
//     * @param userId
//     */
//    public void deleteUser(int userId){
//        SQLiteDatabase db = null;
//        try {
//            db = dbOpenHelper.getWritableDatabase();
//            db.delete("user", "renumber=" + userId, null);
//        } catch (Exception e) {
//            System.out.println("Handle deleteUser exception");
//        } finally {
//            db.close();
//        }
//    }
//
//    /**
//     * glance over all user
//     */
//    public void selectUser(){
//        //waiting
//    }
//
//    //商家表操作
//    /**
//     * add seller for system
//     * @param seller
//     */
//    public void addSeller(Seller seller){
//        SQLiteDatabase db = null;
//        ContentValues value = new ContentValues();
//        value.put("sellername",seller.getSellerName());
//        value.put("password",seller.getPassword());
//        value.put("sellertype",seller.getSellerType());
//        try{
//            db.insert("seller",null,value);
//
//        }catch (Exception e){
//            System.out.println("Handle addSeller exception");
//        }finally {
//            System.out.println("新建商家成功");
//            db.close();
//        }
//    }
//
//    /**
//     * delete seller by sellerId
//     * @param sellerId
//     */
//    public void deleteSeller(int sellerId){
//        SQLiteDatabase db = null;
//        try {
//            db = dbOpenHelper.getWritableDatabase();
//            db.delete("sellerid", "renumber=" + sellerId, null);
//        } catch (Exception e) {
//            System.out.println("Handle deleteSeller exception");
//        } finally {
//            db.close();
//        }
//    }
//
//    //商品表操作
//    public void addGoods(){
//
//    }
//}
