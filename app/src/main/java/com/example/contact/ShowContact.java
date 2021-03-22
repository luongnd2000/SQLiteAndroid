package com.example.contact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ShowContact extends AppCompatActivity {
    ListView listViewContact;
    Button buttonBack;
//    final ContactDAO contactDAO=new ContactDAO(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_contact);
        listViewContact=findViewById(R.id.listViewContact);
        buttonBack=findViewById(R.id.buttonBack);
        final ContactDAO contactDAO=new ContactDAO(this);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent=new Intent(ShowContact.this,MainActivity.class);
                startActivity(myintent);
            }
        });
        List<MyContact> myContacts=new ArrayList<>();
        myContacts=contactDAO.getContactAll();
        ListContactAdapter adapter=new ListContactAdapter(ShowContact.this,R.layout.activity_contact,myContacts);
        listViewContact.setAdapter(adapter);
    }
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
//        getMenuInflater().inflate(R.menu.me);
        super.onCreateContextMenu(menu, v, menuInfo);
    }
}