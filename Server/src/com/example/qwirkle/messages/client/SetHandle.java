package com.example.qwirkle.messages.client;

import com.example.qwirkle.messages.Message;
import com.example.qwirkle.messages.server.HandleSet;
import com.example.qwirkle.messages.server.Client;
import com.example.qwirkle.messages.server.Groups;

import java.util.Collection;


public class SetHandle extends Message<Client> {
    private static final long serialVersionUID = 6L;

    public String handle;

    public SetHandle(String handle) {
        this.handle = handle;
    }

    @Override
    public String toString() {
        return String.format("SetHandle('%s')", handle);
    }

    @Override
    public void apply(Client client) {

        long count = Groups.groups.values()
                .stream()
                .flatMap(Collection::stream)
                .distinct()
                .filter(client1 -> client1.handle.equalsIgnoreCase(handle))
                .count();
        if(count > 0) handle = String.format("%s#%d", handle, client.clientNum);


        client.handle = handle;


        client.send(new HandleSet(handle));
    }
}
