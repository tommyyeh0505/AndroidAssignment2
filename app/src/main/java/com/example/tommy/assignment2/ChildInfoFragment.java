package com.example.tommy.assignment2;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;



public class ChildInfoFragment extends Fragment {

    private  TextView firstName;
    private  TextView lastName;
    private  TextView birthDate;
    private  TextView street;
    private  TextView city;
    private  TextView postalCode;
    private  TextView country;
    private  TextView latitude;
    private  TextView longitude;
    private  TextView isNaughty;
    private  TextView dateCreated;
    private  Button delete;
    private  Button edit;
    private  TextView selectChild;
    private  TextView id;
    private Child c;

    ChildInfoFragment.ChildInfoListener acitivityInterface;

    public interface ChildInfoListener {
        public void delete(int id);
    }

    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
        try{
            acitivityInterface = (ChildInfoListener) activity;
        } catch (ClassCastException e){
            throw new ClassCastException(activity.toString());
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.child_info_fragment, container, false);
        id = (TextView) view.findViewById(R.id.child_id);
        firstName = (TextView) view.findViewById(R.id.first_name);
        lastName = (TextView) view.findViewById(R.id.last_name);
        birthDate = (TextView) view.findViewById(R.id.birthDate);
        street = (TextView) view.findViewById(R.id.street);
        city = (TextView) view.findViewById(R.id.city);
        postalCode = (TextView) view.findViewById(R.id.postalCode);
        country = (TextView) view.findViewById(R.id.country);
        latitude = (TextView) view.findViewById(R.id.latitude);
        longitude = (TextView) view.findViewById(R.id.longitude);
        isNaughty = (TextView) view.findViewById(R.id.is_naughty);
        dateCreated = (TextView) view.findViewById(R.id.dateCreated);
        delete = (Button) view.findViewById(R.id.delete_button);
        selectChild = (TextView) view.findViewById(R.id.select_child_textview);

        delete.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        acitivityInterface.delete(c.getId());
                        clearAllText();
                    }
                }
        );
        return view;
    }

    public void clearAllText(){
        id.setText("");
        selectChild.setText(R.string.select_child);
        firstName.setText("");
        lastName.setText("");
        birthDate.setText("");
        street.setText("");
        city.setText("");
        postalCode.setText("");
        country.setText("");
        latitude.setText("");
        longitude.setText("");
        isNaughty.setText("");
        dateCreated.setText("");
        delete.setVisibility(View.INVISIBLE);
        delete.setVisibility(View.GONE);
        id.setVisibility(View.GONE);
        firstName.setVisibility(View.GONE);
        lastName.setVisibility(View.GONE);
        birthDate.setVisibility(View.GONE);
        street.setVisibility(View.GONE);
        city.setVisibility(View.GONE);
        postalCode.setVisibility(View.GONE);
        country.setVisibility(View.GONE);
        latitude.setVisibility(View.GONE);
        longitude.setVisibility(View.GONE);
        isNaughty.setVisibility(View.GONE);
        dateCreated.setVisibility(View.GONE);

    }

    public void setChild(Child c){
        Log.e("child: ", c.toString());
        this.c = c;
        delete.setVisibility(View.VISIBLE);
        id.setVisibility(View.VISIBLE);
        firstName.setVisibility(View.VISIBLE);
        lastName.setVisibility(View.VISIBLE);
        birthDate.setVisibility(View.VISIBLE);
        street.setVisibility(View.VISIBLE);
        city.setVisibility(View.VISIBLE);
        postalCode.setVisibility(View.VISIBLE);
        country.setVisibility(View.VISIBLE);
        latitude.setVisibility(View.VISIBLE);
        longitude.setVisibility(View.VISIBLE);
        isNaughty.setVisibility(View.VISIBLE);
        dateCreated.setVisibility(View.VISIBLE);

        id.setText("ID: " + Integer.toString(c.getId()));
        selectChild.setVisibility(View.GONE);
        firstName.setText(c.getFirstName());
        lastName.setText(c.getLastName());
        birthDate.setText(c.getBirthDate());
        street.setText(c.getStreet());
        city.setText(c.getCity());
        postalCode.setText(c.getPostalCode());
        country.setText(c.getCountry());
        latitude.setText(Double.toString(c.getLatitude()));
        longitude.setText(Double.toString(c.getLongitude()));
        if(c.getIsNaughty()){
            isNaughty.setText(R.string.naughty);
        } else {
            isNaughty.setText(R.string.good);
        }
        dateCreated.setText(c.getDateCreated());
    }
}
