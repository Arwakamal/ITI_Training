package com.example.iti_training;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
    public void ONCliclk_loop(View view){
    new LoopLargeNumber().onPostExecute(String.valueOf(10000));

    }
    public class LoopLargeNumber extends AsyncTask<Void,Void,String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
        String state="";
        @Override
        protected String doInBackground(Void... Params) {
           String state="";
           for(int i=0;i<=10000000;i++){
               state="in_loop";
            }
           state="loop_finished";

           return state;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(MainActivity2.this,"Post",Toast.LENGTH_SHORT).show();

            Toast.makeText(MainActivity2.this,state,Toast.LENGTH_SHORT).show();
        }
    }
}