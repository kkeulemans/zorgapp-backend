package com.example.zorgapp.service;

import com.example.zorgapp.dto.AppointmentDto;
import com.example.zorgapp.dto.MessageDto;
import com.example.zorgapp.exceptions.RecordNotFoundException;
import com.example.zorgapp.models.*;
import com.example.zorgapp.repositories.ClientRepository;
import com.example.zorgapp.repositories.DoctorRepository;
import com.example.zorgapp.repositories.ImageRepository;
import com.example.zorgapp.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MessageServiceImpl implements MessageService {


    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private ImageRepository imageRepository;



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
        message.setId(id);
        if (messageRepository.findById(id).isPresent()) {
            Message storedMessage = messageRepository.findById(id).get();
            storedMessage.setId(message.getId());
            storedMessage.setBody(message.getBody());
            storedMessage.setTitle(message.getTitle());
            messageRepository.save(storedMessage);

        }
        else{
            throw new RecordNotFoundException("No message found");
        }



    }

    @Override
    public void assignToDoctor(Long id, Long doctorId) {
        Optional<Message> optionalMessage = messageRepository.findById(id);
        var optionalDoctor = doctorRepository.findById(doctorId);

        if (optionalDoctor.isPresent() && optionalMessage.isPresent()){

            var message = optionalMessage.get();
            var doctor = optionalDoctor.get();

            message.setDoctor(doctor);
            messageRepository.save(message);
            }
        else {
            throw new RecordNotFoundException("Doctor or Message not found");
        }
        }


    @Override
    public void assignToClient(Long id, Long clientId) {

        Optional<Client> optionalClient = clientRepository.findById(clientId);
        Optional<Message> optionalMessage = messageRepository.findById(id);

        if (optionalMessage.isPresent() && optionalClient.isPresent()){

            var message = optionalMessage.get();
            var client = optionalClient.get();

            message.setClient(client);
            messageRepository.save(message);
        }
        else {
            throw new RecordNotFoundException("Client or Message not found");
        }

    }

    public MessageDto transferToDto(Message message){
        var dto = new  MessageDto();
        dto.setId(message.getId());
        dto.setBody(message.getBody());
        dto.setTitle(message.getTitle());

        return dto;
    }

    public Message transferToMessage(MessageDto messageDto){
        var message = new Message();
        message.setId(messageDto.getId());
        message.setBody(messageDto.getBody());
        message.setTitle(messageDto.getTitle());

        return message;
    }

    public void addAttachment (Long id, Long attachmentId){
        Optional<Message> optionalMessage = messageRepository.findById(id);
        Optional<Image> optionalImage = imageRepository.findById(attachmentId);

        if(optionalMessage.isPresent() && optionalImage.isPresent()){
            var message = optionalMessage.get();
            var image = optionalImage.get();

            message.setAttachment(image);
            messageRepository.save(message);

        }
        else {
            throw new RecordNotFoundException("Client or Message not found");
        }
    }
}
