package com.example.contact;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ListContactAdapter extends ArrayAdapter<MyContact> {

    public ListContactAdapter(@NonNull Context context, int resource, @NonNull List<MyContact> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view=convertView;
        if(view==null){
            LayoutInflater inflater=LayoutInflater.from(getContext());
            view=inflater.inflate(R.layout.activity_contact,null);

        }
        MyContact myContact=getItem(position);
        if(myContact!=null){
            TextView tvName=view.findViewById(R.id.textViewName);
            TextView tvNumber=view.findViewById(R.id.textViewNumber);
            tvName.setText(myContact.Name);
            tvNumber.setText(myContact.PhoneNumber);
        }
        return view;
    }
}
