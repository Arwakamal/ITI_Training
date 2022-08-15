package com.example.iti_training;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UserDataBase {
    private static final String DATABASE_NAME="UserData";
    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_TABLE="User";
    private static final String KEY_NAME="name";
    private static final String KEY_AGE="age";
    private static final String KEY_ROWID1="_id1";

    Context context;
    UserDataBaseH userH;
    SQLiteDatabase sql;


    public static class UserDataBaseH extends SQLiteOpenHelper {
        public UserDataBaseH(Context context){
            super(context,DATABASE_NAME,null,DATABASE_VERSION);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
         db.execSQL("CREATE TABLE "+DATABASE_TABLE+" ("+KEY_ROWID1 +" INTEGER PRIMARY KEY AUTOINCREMENT,"+KEY_NAME +" TEXT NOT NULL "+" ,"+ KEY_AGE +" TEXT NOT NULL );");
         System.out.println("Created");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
          db.execSQL("CREATE TABLE "+"Customer" + " ("+ "_id1"+"INTEGER PRIMARY KEY AUTOINCREMENT,"+"customer_name"+" TEXT NOT NULL "+" ,"+"phone"+" TEXT NOT NULL );");
        }
    }
    UserDataBase(Context context){
        this.context=context;
    }
    public UserDataBase open() throws SQLException {
        userH=new UserDataBaseH(context);
        sql=userH.getWritableDatabase();
        System.out.println("created1");
        return this;
    }
    public void insert(person p){
        ContentValues c=new ContentValues();
        c.put(KEY_NAME,p.getName());
        c.put(KEY_AGE,p.getAge());
        sql.insert(DATABASE_TABLE,null,c);

    }
    public void delete(String Id){
        try{
            sql.delete(DATABASE_TABLE,KEY_ROWID1+"="+Integer.parseInt(Id),null);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
