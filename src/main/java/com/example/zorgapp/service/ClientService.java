package com.example.zorgapp.service;

import com.example.zorgapp.dto.ClientDto;
import com.example.zorgapp.models.Client;
import com.example.zorgapp.models.Doctor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientService {

    public List<ClientDto> getAllClients();
    public ClientDto getClientById(Long id);
    ClientDto addClient (ClientDto client);
    void deleteClient(Long id);
    void updateClient(Long id, ClientDto clientDto);
    void addDoctor(Long doctorId, Long id);
    void addAppointment(Long id, Long appointmentId);
    void addMessage(Long id, Long messageId);

}
