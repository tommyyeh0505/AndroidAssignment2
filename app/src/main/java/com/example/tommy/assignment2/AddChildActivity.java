package com.example.tommy.assignment2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AddChildActivity extends AppCompatActivity implements ChildInfoFragment.ChildInfoListener {
    private SQLHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_child);
        db = new SQLHelper(this);
        int id = getIntent().getIntExtra("id", 0);
        ChildInfoFragment frag = (ChildInfoFragment) getSupportFragmentManager().findFragmentById(R.id.child_info_fragment_activity);
        frag.setChild(db.getChild(id));

    }

    @Override
    public void delete(int i) {
        db.deleteChild(i);
        Intent in = new Intent(this, MainActivity.class);
        in.putExtra("redirect", "true");
        startActivity(in);
    }




}
