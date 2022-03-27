package com.example.zorgapp.models;

import javax.persistence.*;
import java.io.File;
import java.util.List;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @Column(name = "title")
    private String title;
    @Column(name = "body")
    private String body;
    @Column(name = "attachment")
    private File attachment;

    public Client getClient() {
        return client;
    }

    public Doctor getDoctor() {
        return doctor;
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
