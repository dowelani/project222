package com.example.qwirkle.messages.server;

import com.example.qwirkle.messages.Message;
import com.example.qwirkle.messages.client.Quit;
import com.example.qwirkle.messages.client.SendMessage;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

    public class Client {

        private Socket client;

        private ObjectInputStream in;
        private ObjectOutputStream out;


        private BlockingQueue<Message> outgoingMessages = new LinkedBlockingDeque<>();


        private ReadThread readThread;


        private WriteThread writeThread;


        public int clientNum;
        public String handle = "";
        public String groupName = "";

        public Client(Socket client, int clientNum,int a,int b,int rNum) {
            this.client = client;
            this.clientNum = clientNum;
            send(new SendMessage(Integer.toString(clientNum)));
            readThread = new ReadThread();
            readThread.start();


            Groups.join("lobby"+rNum, com.example.qwirkle.messages.server.Client.this);


            send(new GroupsListed());
        }


        public void send(Message message) {
            try {
                outgoingMessages.put(message);
            } catch (InterruptedException e) {
                System.out.println(clientNum + ": Read.Exception: " + e.getMessage());
                e.printStackTrace();
            }
        }


        private class ReadThread extends Thread {
            @Override
            public void run() {
                try {
                    System.out.println(clientNum + ": Read thread started.");


                    out = new ObjectOutputStream(client.getOutputStream());
                    out.flush();
                    in = new ObjectInputStream(client.getInputStream());
                    System.out.println(clientNum + ": Obtained I/O streams.");


                    writeThread = new WriteThread();
                    writeThread.start();


                    System.out.println(clientNum + ": Started Read Loop...");
                    Message msg;
                    do {

                        msg = (Message) in.readObject();
                        System.out.println(clientNum + " --> " + msg);


                        msg.apply(Client.this);

                    } while (msg.getClass() != Quit.class);


                    client.close();

                } catch (Exception e) {
                    System.out.println(clientNum + ": Read.Exception: " + e.getMessage());
                    e.printStackTrace();

                } finally {
                    System.out.println(clientNum + ": Leaving groups...");
                    Groups.leave(com.example.qwirkle.messages.server.Client.this);

                    System.out.println(clientNum + ": Stopping Write thread...");
                    writeThread.interrupt();

                    System.out.println(clientNum + ": Read thread finished.");
                }
            }
        }


        private class WriteThread extends Thread {
            @Override
            public void run() {
                System.out.println(clientNum + ": Started Write Loop thread...");

                writeThread = this;

                try {

                    while (!isInterrupted()) {
                        Message msg = outgoingMessages.take();

                        out.writeObject(msg);
                        out.flush();

                        System.out.println(msg + " --> " + clientNum);
                    }

                } catch (Exception e) {
                    System.out.println(clientNum + ": Write.Exception = " + e.getMessage());
                    e.printStackTrace();

                } finally {
                    writeThread = null;
                    System.out.println(clientNum + ": Write thread finished.");
                }
            }
        }
    }

