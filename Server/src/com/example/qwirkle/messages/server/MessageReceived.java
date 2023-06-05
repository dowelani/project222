package com.example.qwirkle.messages.server;

import com.example.qwirkle.messages.Message;


import java.util.Date;


public class MessageReceived extends Message {
    private static final long serialVersionUID = 100L;

    public Date  timeStamp;
    public String groupName;
    public String handle;
    public String message;

    public MessageReceived(String groupName, String handle, String message) {
        this.groupName = groupName;
        this.handle = handle;
        this.message = message;
        timeStamp = new Date();
    }

    @Override
    public String toString() {
        return String.format("MessageReceived(%s, '%s', '%s', '%s')",
                timeStamp, groupName, handle, message);
    }
}
