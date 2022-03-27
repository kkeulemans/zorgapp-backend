package com.example.zorgapp.dto;

import com.example.zorgapp.models.Client;
import com.example.zorgapp.models.Doctor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalTime;

public class AppointmentDto {

    private Long id;
    private Doctor doctor;
    private Client client;
    private LocalDate date;
    private LocalTime time;

    public AppointmentDto(){}
    public AppointmentDto(Long id, Doctor doctor, Client client, LocalDate date, LocalTime time){}

    public Long getId(){
        return id;
    }
    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public Client getClient() {
        return client;
    }

    public Doctor getDoctor(){
        return doctor;
    }

    public void setId(Long id){
        this.id = id;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public void setClient (Client client) {
        this.client = client;
    }

    public void setDoctor(Doctor doctor){
        this.doctor = doctor;
    }

}
