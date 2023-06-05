package com.example.qwirkle.messages.client;

import com.example.qwirkle.messages.Message;

public class SendMessage extends Message {
    private static final long serialVersionUID = 5L;

    public String message;

    public SendMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return String.format("SendMessage('%s')", message);
    }
}
