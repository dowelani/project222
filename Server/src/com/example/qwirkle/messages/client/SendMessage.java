package com.example.qwirkle.messages.client;

import com.example.qwirkle.messages.Message;
import com.example.qwirkle.messages.server.MessageReceived;
import com.example.qwirkle.messages.server.Client;
import com.example.qwirkle.messages.server.Groups;


public class SendMessage extends Message<Client> {
    private static final long serialVersionUID = 5L;

    public String message;

    public SendMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return String.format("SendMessage('%s')", message);
    }

    @Override
    public void apply(Client client) {

        String groupName = client.groupName;

        if(groupName.length() == 0) return;


        Groups.send(groupName,
                new MessageReceived(groupName, client.handle, message));
    }
}
