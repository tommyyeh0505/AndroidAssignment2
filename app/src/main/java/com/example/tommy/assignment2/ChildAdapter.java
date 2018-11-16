package com.example.tommy.assignment2;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ChildAdapter extends ArrayAdapter<Child> {

    private ArrayList<Child> list;
    public ChildAdapter(Context context, ArrayList<Child> children) {
        super(context, 0, children);
        list = children;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Child user = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.child_list_view, parent, false);
        }
        // Lookup view for data population
        TextView childFirstName = (TextView) convertView.findViewById(R.id.child_first_name);
        TextView childLastName = (TextView) convertView.findViewById(R.id.child_last_name);
        TextView childisNaughty = (TextView) convertView.findViewById(R.id.child_is_naughty);
        // Populate the data into the template view using the data objec
        childFirstName.setText(user.getFirstName());
        childLastName.setText(user.getLastName());
        if(user.getIsNaughty()) {
            childisNaughty.setText("Naughty");
        } else {
            childisNaughty.setText("Good");
        }
        // Return the completed view to render on screen
        return convertView;
    }

    public Child getItem(int position){
        Log.e("CHILD:", list.get(position).getFirstName());
        Log.e("CHILD:", list.get(position).getLastName());
        Log.e("CHILD:", "" + list.get(position).getIsNaughty());
        return list.get(position);
    }

}
