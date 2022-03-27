package com.example.zorgapp.service;

import com.example.zorgapp.models.Client;
import com.example.zorgapp.models.Doctor;
import com.example.zorgapp.repositories.ClientRepository;
import com.example.zorgapp.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl  implements ClientService{
    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private ClientRepository clientRepository;
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

    @Override
    public void addDoctor(Long doctorId, Long id) {
        var optionalClient = clientRepository.findById(id);
        var optionalDoctor = doctorRepository.findById(doctorId);
        if (optionalClient.isPresent() && optionalDoctor.isPresent()) {
            var doctor = optionalDoctor.get();
            var client = optionalClient.get();

            client.setDoctor(doctor);
        }
    }
}
