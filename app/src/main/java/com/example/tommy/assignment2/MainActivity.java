package com.example.tommy.assignment2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Arrays;
import android.support.v7.widget.Toolbar;
import android.widget.AdapterView.OnItemClickListener;



public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("1", "IN ONCREATE");
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);


        //CHILDREN LIST
        SQLHelper db = new SQLHelper(this);

        if (db.getChildren().size() == 0) {
            for (Child c : Child.CHILDREN) {
                db.insertChild(c);
            }
        }



        Log.e("2", "Created DATABASE");
        ListView list_children = (ListView) findViewById(R.id.children_list);
        final ArrayList<Child> children = db.getChildren();
        String[] childrenNames = new String[db.getChildren().size()];
        for (int i = 0; i < db.getChildren().size(); i++) {
            childrenNames[i] = children.get(i).toString();
        }
        Log.e("2", Arrays.asList(children).toString());
        ChildAdapter arrayAdapter = new ChildAdapter(this, children);
        list_children.setAdapter(arrayAdapter);

        list_children.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position, long pos) {

                Intent intent = new Intent(MainActivity.this, ChildInfo.class);
                Child c = children.get(position);
                Log.e("C info", c.toString());
                intent.putExtra("firstName", c.getFirstName());
                intent.putExtra("id", c.getId());
                intent.putExtra("lastName", c.getLastName());
                intent.putExtra("isNaughty", c.getIsNaughty());
                intent.putExtra("birthDate", c.getBirthDate());
                intent.putExtra("street", c.getIsNaughty());
                intent.putExtra("city", c.getCity());
                intent.putExtra("province", c.getProvince());
                intent.putExtra("postalCode", c.getPostalCode());
                intent.putExtra("country", c.getCountry());
                intent.putExtra("latitude", c.getLatitude());
                intent.putExtra("longitude", c.getLongitude());
                intent.putExtra("dateCreated", c.getDateCreated());

                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.app_bar, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add:
                // User chose the "Settings" item, show the app settings UI...
                return true;

            case R.id.action_search:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

}