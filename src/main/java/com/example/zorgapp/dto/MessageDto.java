package com.example.zorgapp.dto;

import com.example.zorgapp.models.Client;
import com.example.zorgapp.models.Doctor;
import com.example.zorgapp.models.Image;


public class MessageDto {

    private Long id;
    private DoctorDto doctor;
    private ClientDto client;
    private String title;
    private String body;
    private ImageDto attachment;

    public ClientDto getClient() {
        return client;
    }

    public DoctorDto getDoctor() {
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

    public ImageDto getAttachment(){
        return attachment;
    }


    public void setId(Long id) {
        this.id = id;
    }
    public ClientDto setClient( ClientDto client) {
        this.client = client;
        return client;
    }

    public DoctorDto setDoctor( DoctorDto doctor) {
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

    public ImageDto setAttachment( ImageDto attachment){
        this.attachment = attachment;
        return attachment;
    }

}
