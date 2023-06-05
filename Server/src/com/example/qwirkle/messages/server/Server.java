package com.example.qwirkle.messages.server;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class Server {
    public static void main(String[] args) throws Exception {
        new Server();
    }

    private ServerSocket server;

    private int clientNum = 0;
    int a=1;int b=2;  int rNum=100;

    public Server() throws Exception {

        server = new ServerSocket(5050);
        System.out.printf("Chat com.example.qwirkle.messages.server started on: %s:5050\n",
                InetAddress.getLocalHost().getHostAddress());




        while(true) {

            Socket client = server.accept();
            System.out.printf("Connection request received: %s\n", client.getInetAddress().getHostAddress());

            clientNum=clientNum+1;
            if(clientNum>=a||clientNum<=b){
                if(a==clientNum){
                    Groups.addGroup("lobby"+rNum);rNum++;
                }
                Client connectionClient = new Client(client, clientNum,a,b,rNum);
                if(b==clientNum){
                    a=1;b=2;clientNum=0;
                }
            }
        }
    }
}

