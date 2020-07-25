package com.example.sqliteexternal;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //download DB opener from https://sqlitebrowser.org/blog/portableapp-for-3-12-0-release-now-available/
    //open external DB

    public static MyDatabase database;

    String content2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        database  = new MyDatabase(this);




        SQLiteDatabase sql = MainActivity.database.getWritableDatabase();
        Cursor c = sql.rawQuery("SELECT * FROM tabirkhabcontent",null);

        final List<String> listTitle = new ArrayList<String>();
        final List<Integer> listID = new ArrayList<Integer>();
        final List<String> listContent = new ArrayList<String>();
        try {
            while(c.moveToNext()) {                               
                listTitle.add(c.getString(c.getColumnIndex("list")));
                listID.add(c.getInt(c.getColumnIndex("id")));
                listContent.add(c.getString(c.getColumnIndex("content")));
            }
        } finally {
            c.close();
        }

        // show content
        for (int i = 0; i <listContent.size() ; i++) {
            if(i == 2 ){
                content2 = listContent.get(i);
            }
        }

        String f = content2;



    }
}