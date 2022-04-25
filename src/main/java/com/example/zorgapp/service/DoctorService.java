package com.example.zorgapp.service;

import com.example.zorgapp.dto.ClientDto;
import com.example.zorgapp.dto.DoctorDto;
import com.example.zorgapp.models.Client;
import com.example.zorgapp.models.Doctor;

import java.util.List;

public interface DoctorService {

    public List<DoctorDto> getAllDoctors();
    public DoctorDto getDoctorById(Long id);
    public void addClient(Long id, Long clientId);
    DoctorDto addDoctor (DoctorDto dto);
    void deleteDoctor(Long id);
    void updateDoctor(Long id, DoctorDto dto);
    void addMessage(Long id, Long messageId);
    void addAppointment(Long id, Long appointmentId);
    //List<Client> getAllDoctorsClients (Long id);
}
