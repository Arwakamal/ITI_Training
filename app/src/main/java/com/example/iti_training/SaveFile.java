package com.example.iti_training;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class SaveFile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_file);
    }

    public void onClick_Write(View view){
        String data = "my first file";
        File file = null;
        FileOutputStream stream = null;
        try {
            file = new File(getCacheDir(), "data.txt");
            stream = new FileOutputStream("file");
            stream.write(data.getBytes());
            stream.close();
            Toast.makeText(this,"Saved",Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }catch (IOException ee) {
            Toast.makeText(this, ee.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void onClick_Read(View view){
       File file = new File(getCacheDir(), "data.txt");
        BufferedReader input=null;
        String line="";
        StringBuffer mydata=new StringBuffer();
        try{
            input=new BufferedReader(new InputStreamReader(new FileInputStream(file)));

            while ((line=input.readLine())!=null){
                mydata.append(line);
            }
            Toast.makeText(this,mydata,Toast.LENGTH_LONG).show();

        }catch (Exception ec){
         Toast.makeText(this,ec.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }
}