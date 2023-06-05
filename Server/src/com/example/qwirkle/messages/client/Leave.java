package com.example.qwirkle.messages.client;


import com.example.qwirkle.messages.Message;
import com.example.qwirkle.messages.server.Client;
import com.example.qwirkle.messages.server.Groups;


public class Leave extends Message<Client> {
    private static final long serialVersionUID = 2L;

    @Override
    public String toString() {
        return "Leave()";
    }

    @Override
    public void apply(Client chatClient) {
        Groups.leave(chatClient);
    }
}
