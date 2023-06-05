package com.example.qwirkle.messages.client;


import com.example.qwirkle.messages.Message;
import com.example.qwirkle.messages.server.Client;
import com.example.qwirkle.messages.server.Groups;


public class Join extends Message<Client> {
    private static final long serialVersionUID = 1L;
    public String groupName;

    public Join(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return String.format("Join('%s')", groupName);
    }

    @Override
    public void apply(Client client) {
        Groups.join(groupName, client);
    }
}
