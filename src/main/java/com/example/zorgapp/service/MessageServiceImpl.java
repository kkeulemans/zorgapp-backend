package com.example.zorgapp.service;

import com.example.zorgapp.models.Message;
import com.example.zorgapp.repositories.ClientRepository;
import com.example.zorgapp.repositories.DoctorRepository;
import com.example.zorgapp.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {


    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private MessageRepository messageRepository;



    @Override
    public List<Message> getAllMessages() {
        return null;
    }

    @Override
    public Message getMessage(Long id) {
        return null;
    }

    @Override
    public Message addMessage(Message message) {
        return null;
    }

    @Override
    public void deleteMessage(Long id) {

    }

    @Override
    public void updateMessage(Long id, Message message) {

    }
}
