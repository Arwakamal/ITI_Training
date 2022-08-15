package com.example.iti_training;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

public class Check_Permission extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check__permission);
    }

    @Override
    protected void onStart() {
        super.onStart();
       if(checkPermission()){
           Toast.makeText(this,"Permission Granted",Toast.LENGTH_SHORT).show();
       }else{
           Toast.makeText(this,"Permission NOT Granted",Toast.LENGTH_SHORT).show();
           requestPermission();
       }

    }
    private boolean checkPermission(){
        int result= ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA);
        return  result== PackageManager.PERMISSION_GRANTED;
    }
    private static final int PERMISSION_REQUEST_CODE=200;
    private void requestPermission(){
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA},PERMISSION_REQUEST_CODE);
    }
}