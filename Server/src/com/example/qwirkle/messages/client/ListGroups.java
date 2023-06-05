package com.example.qwirkle.messages.client;


import com.example.qwirkle.messages.Message;
import com.example.qwirkle.messages.server.GroupsListed;
import com.example.qwirkle.messages.server.Client;


public class ListGroups extends Message<Client> {
    private static final long serialVersionUID = 3L;

    @Override
    public String toString() {
        return "ListGroups()";
    }

    @Override
    public void apply(Client client) {

        client.send(new GroupsListed());
    }
}
