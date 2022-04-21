package com.example.zorgapp.models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "doctors")
public class Doctor extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "doctor")
    List<Client> clients ;

    @OneToMany(mappedBy = "doctor")
    private List<Message> messageList;

    @OneToMany(mappedBy = "doctor")
    List<Appointment> appointmentList;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;

    @Column(name = "work_address")
    String workAddress;

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

    public String getWorkAddress() {
        return  workAddress;
    }

    public void setWorkAddress(String workAddress) {
        this.workAddress = workAddress;
    }

    public List<Client>  getClients(){
        return clients ;
    }
    public List<Appointment>  getAppointments(){
        return appointmentList ;
    }
    public List<Message>  getMessages(){
        return messageList ;
    }

    public void setClients(List<Client> clients){
        this.clients = clients;
    }
    public void setAppointments(List <Appointment> appointmentList){
        this.appointmentList = appointmentList;
    }

    public void addClient (Client client){
        clients.add(client);
    }


}
