package com.example.zorgapp.service;

import com.example.zorgapp.dto.AppointmentDto;
import com.example.zorgapp.dto.MessageDto;
import com.example.zorgapp.models.Appointment;
import com.example.zorgapp.models.Message;
import com.example.zorgapp.repositories.ClientRepository;
import com.example.zorgapp.repositories.DoctorRepository;
import com.example.zorgapp.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<MessageDto> getAllMessages() {
        List<Message> messageList= messageRepository.findAll();
        List<MessageDto> messageDtoList = new ArrayList<>();


        for (Message message: messageList){
            MessageDto dto = transferToDto(message);
            messageDtoList.add(dto);
        }
        return messageDtoList;
    }

    @Override
    public MessageDto getMessageById(Long id) {
        return null;
    }

    @Override
    public MessageDto addMessage(MessageDto messageDto) {
        Message messageToBeAdded = transferToMessage(messageDto);
        messageRepository.save(messageToBeAdded);
        return messageDto;
    }

    @Override
    public void deleteMessage(Long id) {
        messageRepository.deleteById(id);
    }

    @Override
    public void updateMessage(Long id, MessageDto message) {

    }

    @Override
    public void assignToDoctor(Long id, Long doctorId) {

    }

    @Override
    public void assignToClient(Long id, Long clientId) {

    }

    public MessageDto transferToDto(Message message){
        var dto = new  MessageDto();
        dto.setId(message.getId());
        dto.setAttachment(message.getAttachment());
        dto.setBody(message.getBody());
        dto.setTitle(message.getTitle());
        dto.setClient(message.getClient());
        dto.setDoctor(message.getDoctor());

        return dto;
    }

    public Message transferToMessage(MessageDto messageDto){
        var message = new Message();
        message.setId(messageDto.getId());
        message.setClient(messageDto.getClient());
        message.setDoctor(messageDto.getDoctor());
        message.setAttachment(message.getAttachment());
        message.setBody(message.getBody());
        message.setTitle(message.getTitle());

        return message;
    }

}
