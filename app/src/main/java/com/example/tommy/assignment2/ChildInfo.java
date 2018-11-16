package com.example.tommy.assignment2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ChildInfo extends AppCompatActivity {
    int id;
    SQLHelper2 db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        String firstName = intent.getStringExtra("firstName");
        id = intent.getIntExtra("id", 0);
        String lastName = intent.getStringExtra("lastName");
        String isNaughty = intent.getStringExtra("isNaughty");
        String birthDate = intent.getStringExtra("birthDate");
        String street = intent.getStringExtra("street");
        String city = intent.getStringExtra("city");
        String province = intent.getStringExtra("province");
        String postalCode = intent.getStringExtra("postalCode");
        String country = intent.getStringExtra("country");
        Integer latitude = intent.getIntExtra("latitude", 0);
        Integer longitude = intent.getIntExtra("longitude", 0);
        String dateCreated = intent.getStringExtra("dateCreated");

        TextView firstNameTextView = (TextView) findViewById(R.id.first_name);
        TextView lastNamTextView = (TextView) findViewById(R.id.last_name);
        TextView isNaughtyTextView = (TextView) findViewById(R.id.is_naughty);
        TextView birthDateTextView = (TextView) findViewById(R.id.birthDate);
        TextView streetTextView = (TextView) findViewById(R.id.street);
        TextView cityTextView = (TextView) findViewById(R.id.city);
        TextView provinceTextView = (TextView) findViewById(R.id.province);
        TextView postalCodeTextView = (TextView) findViewById(R.id.postalCode);
        TextView countryTextView = (TextView) findViewById(R.id.country);
        TextView latitudeTextView = (TextView) findViewById(R.id.latitude);
        TextView longitudeTextView = (TextView) findViewById(R.id.longitude);
        TextView dateCreatedTextView = (TextView) findViewById(R.id.dateCreated);

        firstNameTextView.setText("First Name: " + firstName);
        lastNamTextView.setText("Last Name: " + lastName);
        isNaughtyTextView.setText("Naughty: " + isNaughty);
        birthDateTextView.setText("BirthDate: " + birthDate);
        streetTextView.setText(street);
        cityTextView.setText(city);
        provinceTextView.setText(province);
        postalCodeTextView.setText(postalCode);
        countryTextView.setText(country);
        latitudeTextView.setText("Latitude: " + latitude);
        longitudeTextView.setText("Longitude: " + longitude);
        dateCreatedTextView.setText("Date Created: " + dateCreated);


        Button deleteButton = findViewById(R.id.delete_button);

        db = new SQLHelper2(this);
    }


    public void delete(View v){
        SQLHelper db = new SQLHelper(this);
        db.deleteChild(id);
        ArrayList<Child> cs =  db.getChildren();
        for(Child c : cs){
            Log.e("Remaining Child:", cs.toString());
        }
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}



