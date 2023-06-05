package com.example.qwirkle.messages.server;


import java.util.List;

import com.example.qwirkle.messages.Message;

public class GroupsListed extends Message {
    private static final long serialVersionUID = 101L;

    public List<String> groupNames;

    @Override
    public String toString() {
        return String.format("GroupsListed(%s)", groupNames.toString());
    }
}
