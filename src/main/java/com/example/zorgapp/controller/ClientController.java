package com.example.zorgapp.controller;

import com.example.zorgapp.dto.ClientDto;
import com.example.zorgapp.models.Doctor;
import com.example.zorgapp.service.ClientService;
import com.example.zorgapp.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    ClientService clientService;

    @Autowired
    DoctorService doctorService;

    @GetMapping("/clients")
    public ResponseEntity<List<ClientDto>> getAllClients(){
        List<ClientDto> clientDtos = clientService.getAllClients();
       return ResponseEntity.ok().body(clientDtos);
    }

    @GetMapping("/clients/{id}")
    public ClientDto getClientById(@PathVariable("id") Long id){
        ClientDto dto = clientService.getClientById(id);
        return dto;
    }

    @PostMapping("/clients/new")
    public ClientDto addClient (@RequestBody ClientDto dto){
        ClientDto newClient = clientService.addClient(dto);
        return newClient;
    }

    @DeleteMapping("/clients/{id}")
    public void deleteClient (@PathVariable("id") Long id){
        clientService.deleteClient(id);
    }

    @PutMapping("/clients/{id}")
    public ClientDto updateClient (@PathVariable("id") Long id, @RequestBody ClientDto dto){
        clientService.updateClient(id,dto);
        return dto;
    }

}
