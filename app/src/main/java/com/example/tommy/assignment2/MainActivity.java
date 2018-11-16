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



public class MainActivity extends AppCompatActivity implements ChildListFragment.ChildListListener, ChildInfoFragment.ChildInfoListener {
    SQLHelper db;

    @Override
    public void delete(int i) {
        db.deleteChild(i);
        refresh();
    }

    @Override
    public void selectChild(Child c){
        ChildInfoFragment frag = (ChildInfoFragment) getSupportFragmentManager().findFragmentById(R.id.child_info_fragment);
        frag.setChild(c);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("1", "IN ONCREATE");
        setContentView(R.layout.activity_main);
        //APPBAR
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        //CHILDREN LIST
        db = new SQLHelper(this);

        if (db.getChildren().size() == 0) {
            for (Child c : Child.CHILDREN) {
                db.insertChild(c);
            }
        }
        refresh();

    }

    public void refresh(){
        ChildListFragment listFrag = (ChildListFragment) getSupportFragmentManager().findFragmentById(R.id.child_list_fragment);
        ArrayList<Child> children = db.getChildren();
        listFrag.setList(children);
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