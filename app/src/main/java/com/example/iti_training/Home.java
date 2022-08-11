package com.example.iti_training;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.prefs.Preferences;


public class Home extends AppCompatActivity {
    String username;
    String age;
    String salary;

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    @Override
    protected void onStart() {
        super.onStart();
       preferences=getApplicationContext().getSharedPreferences("userdata",MODE_PRIVATE);

        username= getIntent().getStringExtra("Username");
        age= getIntent().getStringExtra("age");
        salary=getIntent().getStringExtra("salary");

        ((TextView)findViewById(R.id.editText_data)).setText(username+"\n"+age+"\n"+salary);

    }
    public void onClick_shared(View view){
       // SharedPreferences preferences=getApplicationContext().getSharedPreferences("userdata",MODE_PRIVATE);
        Toast.makeText(this,preferences.getString("Username","No Data"),Toast.LENGTH_SHORT).show();
        Toast.makeText(this,preferences.getString("Age","No Data"),Toast.LENGTH_SHORT).show();
        Toast.makeText(this,preferences.getString("Salary","No Data"),Toast.LENGTH_SHORT).show();
    }
    public void onClickEditName(View view){
        SharedPreferences.Editor editor= preferences.edit();
        editor.putString("Age","30").commit();
        Toast.makeText(this,preferences.getString("Age","No Data"),Toast.LENGTH_SHORT).show();
        //editor.remove("Age").commit();
    }
    public void onClickClear(View view){
        SharedPreferences.Editor editor= preferences.edit();
        editor.clear().commit();

    }
}