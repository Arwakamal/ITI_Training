package com.example.iti_training;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class Home extends AppCompatActivity {
    String username;
    String age;
    String salary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    @Override
    protected void onStart() {
        super.onStart();
        username= getIntent().getStringExtra("Username");
        age= getIntent().getStringExtra("age");
        salary=getIntent().getStringExtra("salary");

        ((TextView)findViewById(R.id.editText_data)).setText(username+"\n"+age+"\n"+salary);

    }
}