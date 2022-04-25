package com.example.zorgapp.controller;

import com.example.zorgapp.dto.DoctorDto;
import com.example.zorgapp.models.Client;
import com.example.zorgapp.models.Doctor;
import com.example.zorgapp.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @GetMapping("/doctors")
    public ResponseEntity<List<DoctorDto>> getAllDoctors(){
        List<DoctorDto> allDoctors = doctorService.getAllDoctors();

        return ResponseEntity.ok().body(allDoctors);
    }

    @PostMapping("/doctors/new")
    public DoctorDto addDoctor (@RequestBody DoctorDto doctorDto) {
        DoctorDto newDoctor = doctorService.addDoctor(doctorDto);
        return newDoctor;
    }

    @GetMapping("/doctors/{id}")
    public DoctorDto getDoctorById(@PathVariable("id") Long id){
        DoctorDto dto = doctorService.getDoctorById(id);
        return dto;
    }

    @PutMapping("/doctors/{id}")
    public DoctorDto updateDoctor (@PathVariable("id") Long id, @RequestBody DoctorDto dto){
        doctorService.updateDoctor(id,dto);
        return dto;
    }

    @DeleteMapping("/doctors/{id}")
    public void deleteDoctor (@PathVariable("id") Long id){
        doctorService.deleteDoctor(id);
    }

    @PutMapping("/doctors/{id}/{clientId}")
    public void assignClient (@PathVariable("id") Long id, @PathVariable("clientId") Long clientId){
        doctorService.addClient(id,clientId);
    }

    @PutMapping("/doctors/{id}/messages/new")
    public void addMessage(@PathVariable("id") Long id, @RequestBody Long messageId){

    }

    @GetMapping("/doctors/{id}/clients")
    public ResponseEntity<List<Client>> getAllDoctorsClients (@PathVariable("id") Long id){
        DoctorDto doctor = doctorService.getDoctorById(id);
       List<Client> clients = doctor.getClients();
      return ResponseEntity.ok().body(clients);
    }

}
