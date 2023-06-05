package com.example.qwirkle.messages.server;



import com.example.qwirkle.messages.Message;

import java.util.ArrayList;
import java.util.List;


public class GroupsListed extends Message {
    private static final long serialVersionUID = 101L;

    public List<String> groupNames;

    public GroupsListed() {
        groupNames = new ArrayList<>(Groups.groups.keySet());
    }

    @Override
    public String toString() {
        return String.format("GroupsListed(%s)", groupNames.toString());
    }
}
