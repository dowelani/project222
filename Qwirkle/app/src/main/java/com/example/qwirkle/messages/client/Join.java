package com.example.qwirkle.messages.client;


import com.example.qwirkle.messages.Message;

public class Join extends Message {
    private static final long serialVersionUID = 1L;
    public String groupName;

    public Join(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return String.format("Join('%s')", groupName);
    }
}
