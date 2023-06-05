package com.example.qwirkle.messages.client;


import com.example.qwirkle.messages.Message;

public class AddGroup extends Message {
    private static final long serialVersionUID = 7L;

    public String groupName;

    public AddGroup(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return String.format("AddGroup('%s')", groupName);
    }
}
