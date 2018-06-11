package com.devandroid.fbatista.musicmachine;

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
        
        mDownloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Iniciando o download", Toast.LENGTH_SHORT).show();

                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        download();
                    }
                };

                Thread thread = new Thread(runnable);
                thread.setName("Download Thread");
                thread.start();


            }
        });
    }

    

    private void download(){
        Long endTime = System.currentTimeMillis() + 10 * 1000;
        while(System.currentTimeMillis() < endTime){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Log.d(TAG, "Download terminado");
    }
}
