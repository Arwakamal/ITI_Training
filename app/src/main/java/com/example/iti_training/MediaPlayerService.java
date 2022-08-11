//package com.example.iti_training;
//
//import android.app.Service;
//import android.content.Intent;
//import android.media.MediaPlayer;
//import android.os.IBinder;
//import android.provider.Settings;
//import android.widget.Toast;
//
//import androidx.annotation.Nullable;
//
//public class MediaPlayerService extends Service {
//    @Nullable
//    @Override
//    public IBinder onBind(Intent intent) {
//        return null;
//    }
//
//    @Override
//    public void onCreate() {
//        super.onCreate();
//        Toast.makeText(this,"Created",Toast.LENGTH_SHORT).show();
//    }
//
//    MediaPlayer mediaPlayer;
//
//    @Override
//    public int onStartCommand(Intent intent, int flags, int startId) {
//        super.onStartCommand(intent, flags, startId);
//        Toast.makeText(this,"Started",Toast.LENGTH_SHORT).show();
//        mediaPlayer=MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
//        mediaPlayer.setLooping(true);
//        mediaPlayer.start();
//        return START_STICKY;
//    }
//
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        Toast.makeText(this,"closed",Toast.LENGTH_SHORT).show();
//        mediaPlayer.release();
//    }
//}
