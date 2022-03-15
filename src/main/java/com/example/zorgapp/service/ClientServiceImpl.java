package com.example.zorgapp.service;

import com.example.zorgapp.models.Client;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl  implements ClientService{

    @Override
    public List<Client> getAllClients() {
        return null;
    }

    @Override
    public Client getClient(Long id) {
        return null;
    }

    @Override
    public Client addClient(Client client) {
        return null;
    }

    @Override
    public void deleteClient(Long id) {

    }

    @Override
    public void updateClient(Long id, Client client) {

    }
}
