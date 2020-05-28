package com.example.contact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class NewContact extends AppCompatActivity {

EditText name,mobile_number,email;
int pos=0;
Button save;
private DatabaseHelpler database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_new_contact );

        database=new DatabaseHelpler ( this );
        name=(EditText)findViewById ( R.id.edittxtname );
        mobile_number=(EditText)findViewById ( R.id.edittxtmobile );
        email=(EditText)findViewById ( R.id.edittxtemail );
        save=(Button)findViewById ( R.id.btnsave );
        save.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {

               boolean result= database.insertData ( name.getText ().toString (),mobile_number.getText ().toString () , email.getText ().toString () );
                if (result)
                {
                    Toast.makeText ( NewContact.this, "Contact Save Successfully", Toast.LENGTH_SHORT ).show ();
                }
                else
                {
                    Toast.makeText ( NewContact.this, "Contact Not Save", Toast.LENGTH_SHORT ).show ();
                }
                /*Intent intent=new Intent ( NewContact.this,MainActivity.class );
                startActivity ( intent );*/

            }
        } );

        /*nametv.setText ( adaptor.names[position] );
        mobiletv.setText ( adaptor.mobile[position] );
        emailtv.setText ( adaptor.email[position] );*/




    }
}
