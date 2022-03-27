package com.example.zorgapp.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "time")
    private LocalTime time;


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
