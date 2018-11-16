package com.example.tommy.assignment2;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.text.DateFormat;
import java.util.Date;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import android.support.v7.widget.Toolbar;
import android.widget.AdapterView.OnItemClickListener;
import android.app.AlertDialog;
import android.widget.TextView;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.text.DateFormat;


public class MainActivity extends AppCompatActivity implements ChildListFragment.ChildListListener, ChildInfoFragment.ChildInfoListener {
    SQLHelper db;
    private static Button addButton;
    private static MenuItem actionResetButton;

    @Override
    public void delete(int i) {
        db.deleteChild(i);
        refresh();
        actionResetButton.setVisible(false);
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

    public void addChild() {

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        alertDialog.setTitle("ADD CHILD");
        alertDialog.setMessage("Enter Child Information");
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.child_add, null);
        alertDialog.setView(dialogView);


        final EditText firstName = (EditText)dialogView.findViewById(R.id.first_name);
        final EditText lastName = (EditText)dialogView.findViewById(R.id.last_name);
        final EditText birthDate = (EditText)dialogView.findViewById(R.id.birthDate);
        final EditText street = (EditText)dialogView.findViewById(R.id.street);
        final EditText city = (EditText)dialogView.findViewById(R.id.city);
        final EditText province = (EditText)dialogView.findViewById(R.id.province);
        final EditText postalCode = (EditText)dialogView.findViewById(R.id.postalCode);
        final EditText country = (EditText)dialogView.findViewById(R.id.country);
        final EditText latitude = (EditText)dialogView.findViewById(R.id.latitude);
        final EditText longitude = (EditText)dialogView.findViewById(R.id.longitude);
        final EditText isNaughty = (EditText)dialogView.findViewById(R.id.is_naughty);


        alertDialog.setPositiveButton("Add",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                        Date date = new Date();
                        String dateString = dateFormat.format(date);
                        Child child = new Child(-1, firstName.getText().toString(), lastName.getText().toString(), birthDate.getText().toString(),
                                street.getText().toString(), city.getText().toString(), province.getText().toString(), postalCode.getText().toString(),
                                country.getText().toString(), Integer.parseInt(latitude.getText().toString()), Integer.parseInt(longitude.getText().toString()),
                                Boolean.valueOf(isNaughty.getText().toString()), dateString );
                        db.insertChild(child);
                        refresh();
                        Toast.makeText(MainActivity.this, "Child Added", Toast.LENGTH_LONG).show();
                    }
                });
        AlertDialog dialog = alertDialog.create();
        dialog.show();
    }

    public void search() {

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        alertDialog.setTitle("Search CHILD");
        alertDialog.setMessage("Search for Child");
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.child_search, null);
        alertDialog.setView(dialogView);

        final EditText text = (EditText)dialogView.findViewById(R.id.search_text);

        alertDialog.setPositiveButton("SEARCH",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        ChildListFragment listFrag = (ChildListFragment) getSupportFragmentManager().findFragmentById(R.id.child_list_fragment);
                        ArrayList<Child> children = db.getChildren(text.getText().toString());
                        listFrag.setList(children);
                        actionResetButton.setVisible(true);
                        Toast.makeText(MainActivity.this, "List Filtered", Toast.LENGTH_LONG).show();
                    }
                });
        AlertDialog dialog = alertDialog.create();
        dialog.show();
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
        this.actionResetButton = menu.getItem(0);
        return true;
    }

    @Override
    public void onBackPressed() {
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add:
                addChild();
                return true;

            case R.id.action_search:
                search();
                return true;

            case R.id.action_reset:
                refresh();
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }



}