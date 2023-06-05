package com.example.qwirkle;


import static com.example.qwirkle.EnterDetails.client;
import static com.example.qwirkle.EnterDetails.player;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
     public static GameModel gameModel;
     public static Context context;
     public static MainActivity mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView1=findViewById(R.id.t1);
        textView1.setVisibility(View.GONE);
        TextView textView2=findViewById(R.id.t2);
        textView2.setVisibility(View.GONE);
        TextView textView3=findViewById(R.id.t3);
        textView3.setVisibility(View.GONE);
        TextView textView4=findViewById(R.id.t4);
        textView4.setVisibility(View.GONE);
        context=this;
        mainActivity=this;
        try {
            gameModel=new GameModel();

        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(player.getId().equals("1")){player.isturn=true;
           new Thread(()->{client.sendMessage("set1;"+player.getName()+";"+player.getPoints()); }).start();
        }
        else if(player.getId().equals("2")){
            new Thread(()->{client.sendMessage("set2;"+player.getName()+";"+player.getPoints()); }).start();
        }
        else if(player.getId().equals("3")){
            new Thread(()->{client.sendMessage("set3;"+player.getName()+";"+player.getPoints()); }).start();
        }
        else if(player.getId().equals("4")){
            new Thread(()->{client.sendMessage("set4;"+player.getName()+";"+player.getPoints()); }).start();
        }
        if(player.isturn){
        new Thread(()->{client.sendMessage("set5;"+player.getName()); }).start();}
    }


    public void click(View view)  {
        if(player.isturn){
        gameModel.click(view.getId());}
    }

    public void onClick(View view) throws InterruptedException {
        if(player.isturn){
       gameModel.onClick(view.getId());}
    }

    public void undo(View view) throws InterruptedException {
        if(player.isturn){
        gameModel.undo(view.getId());}
    }

    public void replace(View view)  {
        if(player.isturn){ gameModel.replace(view.getId());}
    }

    public void info(View view) {
       gameModel.info(view.getId());
    }

    public void endTurn(View view) throws InterruptedException {
        if(player.isturn){
        gameModel.endTurn(view.getId());}
    }


}
