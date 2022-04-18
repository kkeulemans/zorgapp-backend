package com.example.zorgapp.dto;

import com.example.zorgapp.models.Message;


public class ImageDto {

    Long id;
    public byte[] content;
    private Message message;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getContent(){
        return content;
    }
    public void setContent(){}

    public Message getMessage(){
        return message;
    }
    public void addToMessage (Message message){
        this.message = message;
    }
}
