package com.example.zorgapp.models;

import com.example.zorgapp.models.Client;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "doctors")
public class Doctor extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "doctor")
    private List<Client> clients;

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

    public List<Client>  getClients(){
        return clients ;
    }

    public void setClients(List<Client> clients){
        this.clients = clients;
    }

    public void addClient (Client client){


    }

}
