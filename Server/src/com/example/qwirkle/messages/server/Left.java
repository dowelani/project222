package com.example.qwirkle.messages.server;

import com.example.qwirkle.messages.Message;



public class Left extends Message {
    private static final long serialVersionUID = 103L;

    public String groupName;
    public String handle;

    public Left(String groupName, String handle) {
        this.groupName = groupName;
        this.handle = handle;
    }

    @Override
    public String toString() {
        return String.format("Left('%s', '%s')", groupName, handle);
    }
}
