package com.example.zorgapp.models;

import javax.persistence.*;

@Entity
public class Image {
    @Id
    @GeneratedValue
    Long id;

    @Lob
    public byte[] content;

    @OneToOne
    @JoinColumn(name = "message_id")
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
    public void setContent(byte[] content){
        this.content = content;
    }

    public Message getMessage(){
        return message;
    }
    public void addToMessage (Message message){
        this.message = message;
    }
}
