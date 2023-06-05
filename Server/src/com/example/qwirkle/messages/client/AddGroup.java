package com.example.qwirkle.messages.client;

import com.example.qwirkle.messages.Message;
import com.example.qwirkle.messages.server.GroupsListed;
import com.example.qwirkle.messages.server.Client;
import com.example.qwirkle.messages.server.Groups;


public class AddGroup extends Message<Client> {
    private static final long serialVersionUID = 7L;


    public String groupName;

    public AddGroup(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return String.format("AddGroup('%s')", groupName);
    }

    @Override
    public void apply(Client chatClient) {

        Groups.addGroup(groupName);


        Groups.sendAll(new GroupsListed());
    }
}
