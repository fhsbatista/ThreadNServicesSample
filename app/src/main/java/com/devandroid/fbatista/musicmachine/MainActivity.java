package com.devandroid.fbatista.musicmachine;

import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private Button mDownloadButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDownloadButton = findViewById(R.id.btn_download);

        final DownloadThread thread = new DownloadThread();
        thread.setName("Download Thread");
        thread.start();
        
        mDownloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Iniciando o download", Toast.LENGTH_SHORT).show();





                //Send messages to handler for processing
                for(String song : Playlist.songs){
                    Message message = Message.obtain();
                    message.obj = song;
                    thread.mHandler.sendMessage(message);
                }


            }
        });
    }



    


}
