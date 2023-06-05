package com.example.qwirkle.messages.server;

import com.example.qwirkle.messages.Message;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

public class Groups {

    private static final ReentrantLock lock = new ReentrantLock();


    public static final Map<String, Set<Client>> groups = new HashMap<>();


    public static void join(String groupName, Client client) {

        leave(client);


        if(!groups.containsKey(groupName))
            addGroup(groupName);


        lock.lock();

        groups.get(groupName).add(client);
        client.groupName = groupName;


        groups.get(groupName)
                .forEach(client1 -> client1.send(new Joined(groupName, client.handle)));
        lock.unlock();
    }


    public static void leave(Client client) {
        lock.lock();

        List<String> groupsIn = groups.entrySet()
                .stream()
                .filter(entry -> entry.getValue().contains(client))
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());


        groupsIn.forEach(groupName -> {

            Set<Client> group = groups.get(groupName);


            group.remove(client);
            client.groupName = "";


            Left msg = new Left(groupName, client.handle);
            group.forEach(client1 -> client1.send(msg));
        });
        lock.unlock();
    }


    public static void addGroup(String groupName) {
        lock.lock();
        groups.put(groupName, new HashSet<>());
        lock.unlock();
    }


    public static void send(String groupName, Message message) {
        lock.lock();

        if(!groups.containsKey(groupName)) return;

        Set<Client> clients = groups.get(groupName);

        for(Client client : clients)
            client.send(message);
        lock.unlock();
    }


    public static void sendAll(Message message) {
        lock.lock();

        groups.values()
                .stream()
                .flatMap(Collection::stream)
                .distinct()
                .forEach(client -> {
                    client.send(message);
                    System.out.println("sendAll: " + client.handle + ", " + message);
                });
        lock.unlock();
    }
}
