package com.example.zorgapp.service;

import com.example.zorgapp.dto.ClientDto;
import com.example.zorgapp.exceptions.RecordNotFoundException;
import com.example.zorgapp.models.Appointment;
import com.example.zorgapp.models.Client;
import com.example.zorgapp.models.Doctor;
import com.example.zorgapp.repositories.AppointmentRepository;
import com.example.zorgapp.repositories.ClientRepository;
import com.example.zorgapp.repositories.DoctorRepository;
import org.aspectj.apache.bcel.generic.InstructionConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public List<ClientDto> getAllClients() {
        return null;
    }

    @Override
    public ClientDto getClientById(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        if (client.isPresent()) {
           return transferToDto(client.get());
        } else {
            throw new RecordNotFoundException("No client found");

        }

    }

    @Override
    public ClientDto addClient(ClientDto clientDto) {
        Client clientToBeAdded = transferToClient(clientDto);
        clientRepository.save(clientToBeAdded);
        return clientDto;
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public void updateClient(Long id, ClientDto clientDto) {
        if (clientRepository.findById(id).isPresent()){

            Client client = clientRepository.findById(id).get();
            client.setId(clientDto.getId());
            client.setFirstName(clientDto.getFirstName());
            client.setLastName(clientDto.getLastName());
            client.setDoctor(clientDto.getDoctor());
            client.setAddress(clientDto.getAddress());
        }
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

    @Override
    public void addAppointment(Long id, Long appointmentId) {

        var optionalAppointment = appointmentRepository.findById(appointmentId);
        var optionalClient = clientRepository.findById(id);
        if (optionalAppointment.isPresent() && optionalClient.isPresent()) {
            var client = optionalClient.get();
            var appointment = optionalAppointment.get();}
    }

    @Override
    public void addMessage(Long id, Long messageId) {

    }

    public Client transferToClient(ClientDto clientDto) {
        var client = new Client();
        client.setId(clientDto.getId());
        client.setFirstName(clientDto.getFirstName());
        client.setLastName(clientDto.getLastName());
        client.setDoctor(clientDto.getDoctor());
        client.setAddress(clientDto.getAddress());


        return client;
    }

    public ClientDto transferToDto (Client client){
        var ClientDto = new ClientDto();
        ClientDto.setId(client.getId());
        ClientDto.setFirstName(client.getFirstName());
        ClientDto.setLastName(client.getLastName());
        ClientDto.setAddress(client.getAddress());



        return ClientDto;
    }
}
