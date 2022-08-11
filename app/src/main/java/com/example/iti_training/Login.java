package com.example.iti_training;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    protected void onStart() {
        super.onStart();
     //   startService(new Intent(this,MediaPlayerService.class));
        ((Button)findViewById(R.id.btn_to_home)).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String username;
                String salary;
                String age;

                username= ((EditText)findViewById(R.id.edit_text_user_name)).getText().toString();
                salary=((EditText)findViewById(R.id.edit_text_salary)).getText().toString();
                age=((EditText)findViewById(R.id.edit_text_age)).getText().toString();

                SharedPreferences shared_=getApplicationContext().getSharedPreferences("userdata",MODE_PRIVATE);
                SharedPreferences.Editor editor= shared_.edit();

                editor.putString("Username",username);
                editor.putString("Salary",salary);
                editor.putString("Age",age);

                editor.commit();

                Intent i =new Intent(Login.this,Home.class);

                i.putExtra("Username", username);
                i.putExtra("salary",  salary);
                i.putExtra("age", age);
                startActivity(i);
            }

        });

}


    public void OnClick_share(View view) {
     Intent intent=new Intent();
     intent.setAction(Intent.ACTION_SEND);
     intent.setType("text/plain");
     intent.putExtra(Intent.EXTRA_TEXT,"this my first app");
     startActivity(intent);

    }
}