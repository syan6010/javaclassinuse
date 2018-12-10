package com.example.nogizaka46top.myapplication;

import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnInsert, btnDel, btnUpdate, btnPrev, btnNext;
    private TextView txtID, txtStdNo, txtScore;
    private SQLiteDatabase mydb;
    private Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnInsert = findViewById(R.id.btnInsert);
        btnDel = findViewById(R.id.btnDel);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnPrev = findViewById(R.id.btnPrev);
        btnNext = findViewById(R.id.btnNext);
        txtID = findViewById(R.id.txtID);
        txtStdNo = findViewById(R.id.txtStdNo);
        txtScore = findViewById(R.id.txtScore);

        mydb = openOrCreateDatabase("mysql.db", MODE_PRIVATE, null);
        mydb.execSQL("create table IF NOT EXISTS table01(_id integer primary key, stdno text, score integer)");
        cursor = mydb.rawQuery("select _id, stdno, score from table01", null);
        if (cursor.moveToNext()){
            loadData();
        }
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stdno = txtStdNo.getText().toString();
                int score = Integer.parseInt(txtScore.getText().toString());
                mydb.execSQL("insert into table01(stdno, score) values ('" + stdno + "', " + score + ")");
                cursor = mydb.rawQuery("select _id, stdno, score from table01", null);
                if (cursor.moveToNext()){
                    loadData();
                }
            }
        });
        btnPrev.setOnClickListener(moveListener);
        btnNext.setOnClickListener(moveListener);
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int _id = Integer.parseInt(txtID.getText().toString());
                mydb.execSQL("delete from table01 where _id=" + _id);
                cursor = mydb.rawQuery("select _id, stdno, score from table01", null);
                if (cursor.moveToNext()){
                    loadData();
                }
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stdno = txtStdNo.getText().toString();
                int score = Integer.parseInt(txtScore.getText().toString());
                int _id = Integer.parseInt(txtID.getText().toString());
                mydb.execSQL("update table01 set stdno='" + stdno + "', score= " + score + " where _id =" + _id);
                cursor = mydb.rawQuery("select _id, stdno, score from table01", null);
                if (cursor.moveToNext()){
                    loadData();
                }
            }
        });
    }

    private View.OnClickListener moveListener = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            if(v.getId() == R.id.btnPrev){
                if(cursor.moveToPrevious())
                    loadData();
            }else if (v.getId() == R.id.btnNext){
                if(cursor.moveToNext())
                    loadData();
            }
        }
    };

    private void loadData(){
        int _id = cursor.getInt(0);
        String stdno = cursor.getString(cursor.getColumnIndex("stdno"));
        int score = cursor.getInt(cursor.getColumnIndex("score"));
        txtID.setText(String.valueOf(_id));
        txtStdNo.setText(stdno);
        txtScore.setText(String.valueOf(score));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mydb.close();
    }
}
