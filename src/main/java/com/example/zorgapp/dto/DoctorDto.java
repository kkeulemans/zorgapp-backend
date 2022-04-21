package com.example.zorgapp.dto;


import com.example.zorgapp.models.Client;

import java.util.List;

public class DoctorDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String workAddress;
    private List<Client> clients;
    private String password;
    private String email;
    private String username;

    public DoctorDto(){}

    public DoctorDto(Long id, String firstName, String lastName, String workAddress, String email, String password){
        this.firstName = firstName;
        this.id = id;
        this.lastName = lastName;
        this.workAddress = workAddress;
        this.email = email;
        this.password = password;
        this.username = email;
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
        this.lastName = lastName;
    }

    public String getWorkAddress() {
        return  workAddress;
    }

    public void setWorkAddress(String workAddress) {
        this.workAddress = workAddress;
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
