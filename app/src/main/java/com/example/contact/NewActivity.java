package com.example.contact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Console;

public class NewActivity extends AppCompatActivity {

    TextView txtname;
    TextView txtmobile;
    TextView txtemail, txtid,tvid;
    DatabaseHelpler db;
    String tempid, tempname,iddata,strname,strmobile,stremail;
    int temp = 0,check=0,ID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_new );
        db = new DatabaseHelpler ( this );
        //sqLiteDatabase=new SQLiteDatabase (this);
        txtname =  findViewById ( R.id.tvname );
        txtemail = findViewById ( R.id.tvemail );
        txtmobile =  findViewById ( R.id.tvmobile );
        txtid = findViewById ( R.id.tvid );
        tvid=findViewById ( R.id.textid );
        //txtmobile=(R.string.openactivity);
        tempid = getIntent ().getStringExtra ( "id");
        //tempname=getIntent ().getStringExtra ( "name" );
        txtname.setText ( tempname );
        txtid.setText ( tempid );
        //txtid.setText ( tempid );
        /*Cursor cursor=db.viewData ();
        if (cursor.moveToFirst ())
        {
            ID=cursor.getInt ( 0 );
            do {
                //iddata=cursor.getString ( 0 );
                if (ID == Integer.parseInt ( tempid ))
                {
                   strname=cursor.getString(1);
                   strmobile=cursor.getString(2);
                   stremail=cursor.getString(3);
                   txtname.setText ( strname );
                   txtmobile.setText ( strmobile );
                   txtemail.setText ( stremail );
                }
                    ID=+1;
            }
            while (cursor.moveToNext ());
        }*/
        //Cursor cursor=db.getData (txtid.toString ());
        /*String mobile=cursor.getString ( 2 );
        String name=cursor.getColumnName ( 1 );
        String email=cursor.getColumnName ( 3 );*/
        //txtmobile.setText ( mobile );
        //txtname.setText ( name );
        /*while (cursor.moveToNext ())
        {*/
            //String idData=cursor.getString ( 0 );
        /*if (!idData.equals ( txtid ))
            {
               while (cursor.moveToNext ())
               {
                   //if (idData.);
               }
            }*/

        /*do {

            //iddata=cursor.getColumnName ( 0 );
            //txtid.setText ( cursor.getColumnIndex ( "ID" ) );
            //tvid.setText ( cursor.getString ( 0 ) );
            if (txtid.equals ( tempname ))
                {
                    txtname.setText ( cursor.getString ( 1 ) );
                    txtmobile.setText ( cursor.getString ( 2 ) );
                    txtemail.setText ( cursor.getString ( 3 ) );
                }
            }
            while (cursor.moveToNext ());*/

        //Cursor cursor1=db.viewData ();
        //cursor1.moveToFirst ();
             /*for (txtid.setText ( cursor1.getString ( 0 ) );tempid.equals (txtid );temp++)
             {
                while (cursor1.moveToNext ()) {
                    tvid.setText ( cursor1.getString ( 0 ) );
                    if (tempid.equals ( txtid )) {
                        txtname.setText ( cursor1.getString ( 1 ) );
                        txtmobile.setText ( cursor1.getString ( 2 ) );
                        txtemail.setText ( cursor1.getString ( 3 ) );
                    }
                }
             }*/


        /*f (tempname.equals (i)  )
        {
            //while (cursor1.moveToNext ()) {
                txtname.setText ( cursor1.getString ( 1 ) );
                txtmobile.setText ( cursor1.getString ( 2 ) );
                txtemail.setText ( cursor1.getString ( 3 ) );
              //  continue;
            //}
        }
        else
        {

                    txtname.setText ( "no data" );
        }*/
    }
}
