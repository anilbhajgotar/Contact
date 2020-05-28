package com.example.contact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateContact extends AppCompatActivity {

    EditText name,mo_number, email;
    Button Update;
    DatabaseHelpler database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_update_contact );

        name=(EditText)findViewById ( R.id.etupdatename );
        mo_number=(EditText)findViewById ( R.id.etupdatenumber );
        email=(EditText)findViewById ( R.id.etupdateemail );
        Update=(Button)findViewById ( R.id.btnupdate );
        Update.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                database.updateData ( name.getText ().toString (),mo_number.getText ().toString (),email.getText ().toString () );

                Toast.makeText ( UpdateContact.this, "Number Update Successfully", Toast.LENGTH_SHORT ).show ();
                mo_number.setText ( " " );
                name.setText ( " " );
                email.setText ( " " );

                /*Intent intent=new Intent ( UpdateContact.this,MainActivity.class );
                startActivity ( intent );*/
            }
        } );
    }
}
