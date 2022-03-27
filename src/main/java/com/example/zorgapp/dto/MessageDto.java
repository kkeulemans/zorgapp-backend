package com.example.zorgapp.dto;

import com.example.zorgapp.models.Client;
import com.example.zorgapp.models.Doctor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.File;

public class MessageDto {

    private Long id;
    private Doctor doctor;
    private Client client;
    private String title;
    private String body;
    private File attachment;

    public Client getClient() {
        return client;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Long getId() {
        return id;
    }


    public String getTitle(){
        return title;
    }
    public String getBody(){
        return body;
    }

    public File getAttachment(){
        return attachment;
    }


    public void setId(Long id) {
        this.id = id;
    }
    public Client setClient( Client client) {
        this.client = client;
        return client;
    }

    public Doctor setDoctor( Doctor doctor) {
        this.doctor = doctor;
        return doctor;
    }

    public String setTitle( String title){
        this.title = title;
        return title;
    }
    public String setBody( String body){
        this.body = body;
        return body;
    }

    public File setAttachment( File attachment){
        this.attachment = attachment;
        return attachment;
    }

}
