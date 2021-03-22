package com.example.contact;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListMap;

public class ContactDAO {
    private SQLiteDatabase db;
    public ContactDAO(Context context){
        ContactDBHelper dbHelper=new ContactDBHelper(context);
        db=dbHelper.getWritableDatabase();
    }
    public List<MyContact> getContacts(String sql,String...selectionArgs){
        List<MyContact> list=new ArrayList<>();
        Cursor c=db.rawQuery(sql,selectionArgs);
        while (c.moveToNext()){
            MyContact ct=new MyContact();
            ct.Id=c.getString(c.getColumnIndex("ID"));
            ct.Name=c.getString(c.getColumnIndex("Name"));
            ct.PhoneNumber=c.getString(c.getColumnIndex("PhoneNumber"));
            list.add(ct);
        }
        return list;
    }

    public List<MyContact> getContactAll(){
        String sql="Select * from "+ContactDBHelper.TableName;
        return getContacts(sql);
    }

    public MyContact getContactByID(String id){
        String sql="select * from "+ContactDBHelper.TableName+" where id=?";
        List<MyContact> list=getContacts(sql,id);
        return list.get(0);
    }
    public long insert(MyContact contact){
        ContentValues values=new ContentValues();
        values.put("ID",contact.Id);
        values.put("Name",contact.Name);
        values.put("PhoneNumber",contact.PhoneNumber);
        return db.insert(ContactDBHelper.TableName,null,values);
    }
    public int update(MyContact contact){
        ContentValues values=new ContentValues();
        if(!contact.Name.equals("")) values.put("Name",contact.Name);
        if(!contact.PhoneNumber.equals("")) values.put("PhoneNumber",contact.PhoneNumber);
        return db.update(ContactDBHelper.TableName,values,"id=?",new String[]{contact.Id});
    }
    public int delete(String id){
        return db.delete(ContactDBHelper.TableName,"id=?",new String[]{id});
    }
}
