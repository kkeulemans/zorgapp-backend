package com.example.zorgapp.service;

import com.example.zorgapp.models.Doctor;
import com.example.zorgapp.models.Message;

import java.util.List;

public interface MessageService {

    public List<Message> getAllMessages();
    public Message getMessage(Long id);
    Message addMessage (Message message);
    void deleteMessage(Long id);
    void updateMessage(Long id, Message message);
}
