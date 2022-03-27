package com.example.zorgapp.dto;


import com.example.zorgapp.models.Client;

import java.util.List;

public class DoctorDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String workAddress;
    private List<Client> clients;

    public DoctorDto(){}

    public DoctorDto(Long id, String firstName, String lastName, String workAddress){
        this.firstName = firstName;
        this.id = id;
        this.lastName = lastName;
        this.workAddress = workAddress;
    }
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
        return  lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = firstName;
    }

    public String getWorkAddress() {
        return  workAddress;
    }

    public void setWorkAddress(String workAddress) {
        this.workAddress = workAddress;
    }


    public List<Client> getClients(){
        return clients ;
    }

    public void setClients(List<Client> clients){
        this.clients = clients;
    }

    public void addClient (Client client){
        clients.add(client);

    }
}
