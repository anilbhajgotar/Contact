package com.example.contact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteContact extends AppCompatActivity {

    EditText name;
    Button delete;
    DatabaseHelpler database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_delete_contact );

        delete=(Button)findViewById ( R.id.btndeletcontact );
        name=(EditText)findViewById ( R.id.etdeletename );

        database =new DatabaseHelpler ( this );
        delete.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {

                database.deleteData ( name.getText ().toString () );
                Toast.makeText ( DeleteContact.this, "Contact Deleted", Toast.LENGTH_SHORT ).show ();
                /*Intent intent=new Intent ( DeleteContact.this,MainActivity.class );
                startActivity ( intent );*/
                
            }
        } );

    }
}
