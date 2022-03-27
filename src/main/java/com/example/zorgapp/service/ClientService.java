package com.example.zorgapp.service;

import com.example.zorgapp.models.Client;
import com.example.zorgapp.models.Doctor;

import java.util.List;

public interface ClientService {

    public List<Client> getAllClients();
    public Client getClient(Long id);
    Client addClient (Client client);
    void deleteClient(Long id);
    void updateClient(Long id, Client client);
    void addDoctor(Long doctorId, Long id);

}
