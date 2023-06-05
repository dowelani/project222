package com.example.qwirkle;

import static com.example.qwirkle.EnterDetails.client;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class WaitForFriends extends AppCompatActivity {
    static WaitForFriends waitForFriends;
    static Context context1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wait_for_friends);
        waitForFriends=this;
        context1=this;
    }

    public void play(View view) throws InterruptedException {
        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            client.sendMessage("onPlay;  " );
        });
        thread2.start();

    }
    public void onPlay(){
        Intent intent = new Intent(context1, MainActivity.class);
        context1.startActivity(intent);
    }
}