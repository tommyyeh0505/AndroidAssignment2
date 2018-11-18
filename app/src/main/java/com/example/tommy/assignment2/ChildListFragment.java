package com.example.tommy.assignment2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import java.util.ArrayList;
import java.util.Arrays;


public class ChildListFragment extends Fragment {

    private static ListView childListView;

    ChildListListener acitivityInterface;

    public interface ChildListListener {
        public void selectChild(Child c);
    }

    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
        try{
            acitivityInterface = (ChildListListener) activity;
        } catch (ClassCastException e){
            throw new ClassCastException(activity.toString());
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.child_list_fragment, container, false);

        childListView = (ListView) view.findViewById(R.id.children_list);


        return view;
    }


    public void setList(ArrayList<Child> list){
        final ArrayList<Child> childList = list;
        Log.e("2", Arrays.asList(list).toString());
        ChildAdapter arrayAdapter = new ChildAdapter(getActivity(), childList);
        childListView.setAdapter(arrayAdapter);

        childListView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position, long pos) {

                Child c = childList.get(position);
                acitivityInterface.selectChild(c);
                }
        });

    }


}
