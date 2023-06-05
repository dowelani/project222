package com.example.qwirkle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;

public class EnterDetails extends AppCompatActivity {
    public static Client client;
    public static String name;
    public static Player player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_details);
        EditText editText =findViewById(R.id.editTextTextPersonName3);
        editText.setText("192.168.5.18");

    }

    public void joinServer(View view) {
        EditText editText =findViewById(R.id.editTextTextPersonName3);
        String serverAddress=editText.getText().toString();
        EditText editText1 =findViewById(R.id.editTextTextPersonName);
        String handle=editText1.getText().toString();
        name=handle;
        player=new Player(EnterDetails.name,0, Collections.synchronizedList(new ArrayList<>()),Collections.synchronizedList(new ArrayList<>()),Collections.synchronizedList(new ArrayList<>()),Collections.synchronizedList(new ArrayList<>()));
        client = new Client();
        client.connect(serverAddress, handle+player.getId());
        Intent intent = new Intent(this, WaitForFriends.class);
        startActivity(intent);
    }

}