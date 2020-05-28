package com.example.contact;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ToolbarWidgetWrapper;
import androidx.core.view.MenuItemCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Contacts;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.ClipData.Item;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //public final static String str="com.example.Contact.ID";

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;
    DatabaseHelpler db;
    ListView userlist,list;
    //String str="com.example.Contact.ID";


    ArrayList<String> listItem ;//arrlist;
    ArrayAdapter adapter;// arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        db=new DatabaseHelpler ( this );
        listItem=new ArrayList<>();
       // arrlist=new ArrayList<>();


        userlist = (ListView)findViewById ( R.id.listviewuserlist );
        list=(ListView)findViewById ( R.id.listviewuserlist );
        drawerLayout=findViewById ( R.id.drawer );
        toolbar=findViewById ( R.id.toolbar );
        navigationView=findViewById ( R.id.navigationview );
        setSupportActionBar ( toolbar );
        getSupportActionBar ().setDisplayHomeAsUpEnabled ( true );
        getSupportActionBar ().setDisplayShowTitleEnabled ( false );
        toggle=new ActionBarDrawerToggle ( this,drawerLayout,toolbar,R.string.open,R.string.close );
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState ();

        viewData ();

        userlist.setOnItemClickListener ( new AdapterView.OnItemClickListener () {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String text=userlist.getItemAtPosition ( position ).toString ();
                //Toast.makeText ( MainActivity.this, ""+text, Toast.LENGTH_SHORT ).show ();
                Intent intent=new Intent(getApplicationContext (),NewActivity.class);
                intent.putExtra ( "name",text );
                intent.putExtra ( "id", String.valueOf ( id ) );
                //intent.putExtra ( "position",String.valueOf ( view ) );
                startActivity ( intent );
            }
        } );

    }

    public void viewData() {
        Cursor cursor=db.viewData ();
       // Cursor data=db.getData ();
        if (cursor.getCount ()== 0)
        {
            Toast.makeText ( this, "No Data To Show", Toast.LENGTH_SHORT ).show ();
        }
        else
        {
            while (cursor.moveToNext ())
            {
                listItem.add ( cursor.getString ( 1 ) );// index 1 is name
            }


            Context context;
            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItem);
            userlist.setAdapter(adapter);
        }
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater ().inflate ( R.menu.search_menu, menu );

        MenuInflater inflater =getMenuInflater ();
        inflater.inflate ( R.menu.menu, menu );
        SearchView searchView;

        MenuItem searchItem = menu.findItem(R.id.itemsearch);

        searchView=(SearchView) MenuItemCompat.getActionView ( searchItem );
        searchView.setOnQueryTextListener ( new SearchView.OnQueryTextListener () {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                ArrayList<String> userslist = new ArrayList<>();

                for (String user : listItem)
                {
                    if (user.toLowerCase ().contains ( newText.toLowerCase () ))
                    {
                        userslist.add ( user );
                    }
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<String> ( MainActivity.this, android.R.layout.simple_list_item_1,userslist );
                userlist.setAdapter(adapter);

                return true;
            }
        } );

        return super.onCreateOptionsMenu ( menu );
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id=item.getItemId ();
        if (id==R.id.addcontact)
        {
            Intent intent=new Intent ( MainActivity.this,NewContact.class );
            startActivity ( intent );
            return true;
        }
        else
            if (id==R.id.update)
            {
                Intent intent=new Intent ( MainActivity.this,UpdateContact.class );
                startActivity ( intent );
                return true;
            }
            else
                if (id==R.id.delete)
                {
                    Intent intent=new Intent ( MainActivity.this,DeleteContact.class );
                    startActivity ( intent );

                    return true;
                }
                /*else
                    if (id==R.id.itemsearch)
                    {
                        Intent intent=new Intent ( MainActivity.this,SearchContact.class );
                        startActivity ( intent );

                        return true;
                    }*/

        return super.onOptionsItemSelected ( item );
    }
}
