package com.example.zorgapp.dto;

import com.example.zorgapp.models.Appointment;
import com.example.zorgapp.models.Doctor;
import com.example.zorgapp.models.Message;

import javax.persistence.*;
import java.util.List;

public class ClientDto {

    private Long id;
    private Doctor doctor;
    private List<Message> messageList;
    private List<Appointment> appointmentList;
    String firstName;
    String lastName;
    String address;
    private String password;
    private String email;
    private String username;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    public String getAddress(){ return address;}

    public void setAddress(String address){
        this.address = address;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getUsername() {
        username = email;
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public List<Appointment> getAppointments() {
        return appointmentList;
    }

    public List<Message> getMessages() {
        return messageList;
    }

    public void setAppointments(List<Appointment> appointmentList) {
        this.appointmentList = appointmentList;
    }

    public void setMessages(List<Message> messageList) {
        this.messageList = messageList;
    }
}
