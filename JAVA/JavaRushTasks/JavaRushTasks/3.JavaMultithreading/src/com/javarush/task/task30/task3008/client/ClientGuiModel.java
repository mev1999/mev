package com.javarush.task.task30.task3008.client;

import java.util.*;
import com.javarush.task.task30.task3008.*;
import com.javarush.task.task30.task3008.Message;
import java.io.*;

public class ClientGuiModel {
    private final Set<String> allUserNames = new HashSet<String>();
    private String newMessage;

    public final Set<String> getAllUserNames() {
        return Collections.unmodifiableSet(allUserNames);
    }    
    
    public String getNewMessage() {
        return newMessage;
    }
    
    public void setNewMessage(String newMessage) {
        this.newMessage = newMessage;
    }
    
    public void addUser(String newUserName) {
        allUserNames.add(newUserName);
    }
    
    public void deleteUser(String userName) {
        allUserNames.remove(userName);
    }
}


