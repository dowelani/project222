package com.example.qwirkle.messages.client;


import com.example.qwirkle.messages.Message;
import com.example.qwirkle.messages.server.Client;
import com.example.qwirkle.messages.server.Groups;


public class Quit extends Message<Client> {
    private static final long serialVersionUID = 4L;

    @Override
    public String toString() {
        return "Quit()";
    }

    @Override
    public void apply(Client client) {
        Groups.leave(client);
    }
}
