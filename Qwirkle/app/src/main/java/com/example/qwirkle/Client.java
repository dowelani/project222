package com.example.qwirkle;

import static com.example.qwirkle.EnterDetails.player;
import static com.example.qwirkle.MainActivity.gameModel;
import static com.example.qwirkle.WaitForFriends.waitForFriends;

import android.util.Log;

import com.example.qwirkle.messages.Message;
import com.example.qwirkle.messages.client.AddGroup;
import com.example.qwirkle.messages.client.Join;
import com.example.qwirkle.messages.client.Leave;
import com.example.qwirkle.messages.client.Quit;
import com.example.qwirkle.messages.client.SendMessage;
import com.example.qwirkle.messages.client.SetHandle;
import com.example.qwirkle.messages.server.MessageReceived;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public class Client {
    private String serverAddress;
    private ObjectInputStream in = null;
    private ObjectOutputStream out = null;
    private BlockingQueue<Message> outgoingMessages;
    private Thread readThread;
    private Thread writeThread;


    private void send(Message message) {
        try {
            outgoingMessages.put(message);
        } catch (InterruptedException e) {
            Log.e("Client", e.getMessage());
        }
    }

    public Client() {
        super();
        outgoingMessages = new LinkedBlockingQueue<>();
    }


    public void connect(String serverAddress, String handle) {
        this.serverAddress = serverAddress;
        readThread = new ReadThread();
        readThread.start();
        send(new SetHandle(handle));
    }


    public void disconnect() {
        leaveGroup();
        send(new Quit());
    }

    public void addGroup(String groupName) {
        send(new AddGroup(groupName));
    }

    public void joinGroup(String group) {
        send(new Join(group));
    }

    public void leaveGroup() {
        send(new Leave());
    }

    public void sendMessage(String message) {
        send(new SendMessage(message));
    }

    private class ReadThread extends Thread {
        @Override
        public void run() {

            readThread = this;

            try {

                Socket connection = new Socket(serverAddress, 5050);
                in = new ObjectInputStream(connection.getInputStream());
                out = new ObjectOutputStream(connection.getOutputStream());
                out.flush();
                writeThread = new WriteThread();
                writeThread.start();

                Message msg;
                do {

                    msg = (Message) in.readObject();
                    Log.i("Client", ">> " + msg);
                    if(msg instanceof SendMessage){
                        SendMessage sendMessage=(SendMessage)msg;
                        player.setId(sendMessage.message);
                    }
                    if(msg instanceof MessageReceived){
                    MessageReceived message1= (MessageReceived) msg;
                    String message=message1.message;
                    if(message.contains(";")){
                        String messageArray[]=message.split(";");
                        if(messageArray[0].equals("click")&&gameModel!=null){
                            gameModel.click(Integer.parseInt(messageArray[1]));
                        }
                        else if(messageArray[0].equals("onClick")&&gameModel!=null){
                            gameModel.onClick(Integer.parseInt(messageArray[1]));
                        }
                        else if(messageArray[0].equals("undo")&&gameModel!=null){
                            gameModel.undo(Integer.parseInt(messageArray[1]));
                        }
                        else if(messageArray[0].equals("replace")&&gameModel!=null){
                            gameModel.replace(Integer.parseInt(messageArray[1]));
                        }
                        else if(messageArray[0].equals("info")&&gameModel!=null){
                            gameModel.info(Integer.parseInt(messageArray[1]));
                        }
                        else if(messageArray[0].equals("endTurn")&&gameModel!=null){
                            gameModel.endTurn(Integer.parseInt(messageArray[1]));
                        }
                        else if(messageArray[0].equals("addToTiles")&&gameModel!=null){
                            gameModel.addToTiles(messageArray[1],messageArray[2]);
                        }
                        else if(messageArray[0].equals("removeFromTiles")&&gameModel!=null){
                            gameModel.removeFromTiles(messageArray[1],messageArray[2]);
                        }
                        else if(messageArray[0].equals("onClickFunctionality")&&gameModel!=null){
                            gameModel.onClickFunctionality(Integer.parseInt(messageArray[1]),messageArray[2],messageArray[3]);
                        }
                        else if(messageArray[0].equals("setEndTileValidity")&&gameModel!=null){
                            gameModel.setEndTileValidity();
                        }
                        else if(messageArray[0].equals("undoForAll")&&gameModel!=null){
                            gameModel.undoForAll(Integer.parseInt(messageArray[1]));
                        }
                        else if(messageArray[0].equals("changeTurn")&&gameModel!=null){
                            gameModel.changeTurn(messageArray[1]);
                        }
                        else if(messageArray[0].equals("set1")&&gameModel!=null){
                            gameModel.set1(messageArray[1],messageArray[2]);
                        }

                        else if(messageArray[0].equals("set2")&&gameModel!=null){
                            gameModel.set2(messageArray[1],messageArray[2]);
                        }
                        else if(messageArray[0].equals("set3")&&gameModel!=null){
                            gameModel.set3(messageArray[1],messageArray[2]);
                        }
                        else if(messageArray[0].equals("set4")&&gameModel!=null){
                            gameModel.set4(messageArray[1],messageArray[2]);
                        }
                        else if(messageArray[0].equals("set5")&&gameModel!=null){
                            gameModel.set5(messageArray[1]);
                        }
                        else if(messageArray[0].equals("onPlay")){
                            waitForFriends.onPlay();
                        }



                    }}


                } while (msg.getClass() != Quit.class);

                connection.close();

            } catch (Exception e) {
                Log.e("Client", "Exception: " + e.getMessage());

            } finally {
                readThread = null;
                if (writeThread != null) writeThread.interrupt();
            }
        }
    }

    private class WriteThread extends Thread {
        @Override
        public void run() {


            try {

                while (true) {

                    Message msg = outgoingMessages.take();
                    out.writeObject(msg);
                    out.flush();

                }
            } catch (Exception e) {
                writeThread = null;
            }
        }
    }
}
