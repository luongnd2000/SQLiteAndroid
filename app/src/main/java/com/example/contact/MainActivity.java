package com.example.contact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editTextID;
    EditText editTextName;
    EditText editTextPhoneNumber;
    Button buttonAdd;
    Button buttonDelete;
    Button buttonUpdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonShow=findViewById(R.id.showContact);
        buttonAdd=findViewById(R.id.buttonAdd);
        buttonDelete=findViewById(R.id.buttonDelete);
        buttonUpdate=findViewById(R.id.buttonUpdate);
        editTextID=findViewById(R.id.editTextID);
        editTextName=findViewById(R.id.editTextName);
        editTextPhoneNumber=findViewById(R.id.editTextPhoneNumber);
        final ContactDAO contactDAO=new ContactDAO(this);
        buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent=new Intent(MainActivity.this,ShowContact.class);
                startActivity(myintent);
            }
        });
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ID=editTextID.getText().toString();
                String Name=editTextName.getText().toString();
                String PhoneNumber=editTextPhoneNumber.getText().toString();
                MyContact myContact=new MyContact(ID,Name,PhoneNumber);
                if(contactDAO.insert(myContact)==-1){
                    Toast.makeText(MainActivity.this,"Error! Insert not Success.",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(MainActivity.this,"Insert Success.",Toast.LENGTH_LONG).show();
                }

            }
        });
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ID=editTextID.getText().toString();
                if(contactDAO.delete(ID)==-1){
                    Toast.makeText(MainActivity.this,"Error! Delete not Success.",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(MainActivity.this,"Delete Success.",Toast.LENGTH_LONG).show();
                }

            }
        });
        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ID=editTextID.getText().toString();
                String Name=editTextName.getText().toString();
                String PhoneNumber=editTextPhoneNumber.getText().toString();
                MyContact myContact=new MyContact(ID,Name,PhoneNumber);
                if(contactDAO.update(myContact)==-1){
                    Toast.makeText(MainActivity.this,"Error! Update not Success.",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(MainActivity.this,"Update Success.",Toast.LENGTH_LONG).show();
                }

            }
        });
    }



}