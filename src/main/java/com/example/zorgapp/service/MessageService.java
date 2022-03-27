package com.example.zorgapp.service;

import com.example.zorgapp.dto.MessageDto;
import com.example.zorgapp.models.Doctor;
import com.example.zorgapp.models.Message;

import java.util.List;

public interface MessageService {

    public List<MessageDto> getAllMessages();
    public MessageDto getMessageById(Long id);
    MessageDto addMessage (MessageDto message);
    void deleteMessage(Long id);
    void updateMessage(Long id, MessageDto message);
    void assignToDoctor(Long id, Long doctorId);
    void assignToClient(Long id, Long clientId);
}
