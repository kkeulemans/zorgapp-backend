package com.example.zorgapp.service;

import com.example.zorgapp.models.Client;
import com.example.zorgapp.models.Doctor;

import java.util.List;

public interface DoctorService {

    public List<Doctor> getAllDoctors();
    public Client addClient(Long id, Long clientId);
    Doctor addDoctor (Doctor doctor);
    void deleteDoctor(Long id);
    void updateDoctor(Long id, Doctor doctor);
}
