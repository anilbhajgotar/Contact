package com.example.contact;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelpler extends SQLiteOpenHelper {

    //private static final String DB_PATH="";
    private static final String DB_NAME="User.db";
    private static final String DB_TABLE="Users_Table";

    //db columns
    private static final String ID="ID";
    private static final String NAME="NAME";
    private static final String NUMBER="NUMBER";
    private static final String EMAIL="EMAIL";

    public static final String CREATE_TABLE =" CREATE TABLE " +DB_TABLE+ "(" +ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME+ " TEXT ,"+NUMBER+ " INTEGER ,"+EMAIL+" TEXT "+")";

    public DatabaseHelpler (Context context){ super(context,DB_NAME, null,1);}


    @Override
    public void onCreate(SQLiteDatabase db) {

       // db.execSQL ( "CREATE TABLE "+DB_TABLE+ " ( ID INTEGER PRIMARY KEY AUTOINCREMENT , NAME TEXT, NUMBER INTEGER, EMAIL TEXT ) " );
        db.execSQL ( "CREATE TABLE "+DB_TABLE );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL ( " DROP TABLE IF EXISTS "+DB_TABLE );
        onCreate ( db );

    }

    //create method to insert data
    public boolean insertData(String name, String number, String email)
    {
        SQLiteDatabase db=this.getWritableDatabase ();
        ContentValues contentValues = new ContentValues();
        contentValues.put ( NAME, name );
        contentValues.put ( NUMBER, number );
        contentValues.put ( EMAIL, email );

        long result=db.insert ( DB_TABLE,null,contentValues );
        return result != -1; //if result = -1 data doesn't insert

    }

    //Create Method to show data
    public Cursor viewData ()
    {
        SQLiteDatabase db =this.getReadableDatabase ();
        String query = "select * from "+DB_TABLE;
        Cursor cursor = db.rawQuery ( query,null );
        //System.out.println ( Arrays.toString(cursor) );
        return cursor;
    }
    //get data
    public Cursor getData(String ID) {
        SQLiteDatabase db=this.getReadableDatabase ();
        String query=" SELECT * FROM " +DB_TABLE+ " WHERE ID = '" +ID+ "'";
        Cursor result =db.rawQuery ( query,null );
         //result= db.execSQL ( " SELECT * FROM "+DB_TABLE+ " WHERE ID = "+ID+"" );
        /*String sql=" SELECT * FROM "+DB_TABLE+ " WHERE NUMBER LIKE " + NUMBER + "";
        Cursor res=db.rawQuery(sql, null);*/
       /* String str=" SELECT * FROM " + DB_TABLE + " WHERE ID = '" +ID+ "'";
        Cursor res=db.rawQuery ( str,null );
        return res;*/
        return result;
    }
    //delete data
    public void deleteData(String name)
    {

        SQLiteDatabase db=this.getWritableDatabase ();
        db.delete ( DB_TABLE, "NAME = '" +name+ "'",null );
        db.close ();

    }

    //update data
    public void updateData(String name, String mobile_number, String email)
    {
        SQLiteOpenHelper dbHelper;
        SQLiteDatabase db=this.getWritableDatabase ();
        ContentValues contentValues=new ContentValues (  );
        contentValues.put ( "NAME", name );
        contentValues.put ( "EMAIL",email );

        db.update ( DB_TABLE,contentValues,"NUMBER = '" +mobile_number+ "'", null );
        db.close ();
    }



}
