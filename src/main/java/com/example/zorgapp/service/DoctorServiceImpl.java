package com.example.zorgapp.service;

import com.example.zorgapp.dto.DoctorDto;
import com.example.zorgapp.models.Client;
import com.example.zorgapp.models.Doctor;
import com.example.zorgapp.repositories.ClientRepository;
import com.example.zorgapp.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService{
@Autowired
private DoctorRepository doctorRepository;

@Autowired
private ClientRepository clientRepository;

    @Override
    public List<DoctorDto> getAllDoctors() {
        List<Doctor> doctorList= doctorRepository.findAll();
        List<DoctorDto> doctorDtoList = new ArrayList<>();


        for (Doctor doctor: doctorList){
            DoctorDto dto = transfertoDto(doctor);
            doctorDtoList.add(dto);
        }
        return doctorDtoList;
    }

    @Override
    public void addClient(Long id, Long clientId) {
       var optionalDoctor = doctorRepository.findById(id);
       var optionalClient = clientRepository.findById(clientId);

       if (optionalClient.isPresent() && optionalDoctor.isPresent()){
           var doctor = optionalDoctor.get();
           var client = optionalClient.get();

           doctor.addClient(client);
       }
    }

    @Override
    public DoctorDto addDoctor(DoctorDto dto) {

        Doctor doctor = transferToDoctor(dto);
        doctorRepository.save(doctor);

        return dto;

    }

    @Override
    public void deleteDoctor(Long id) {
            doctorRepository.deleteById(id);
    }

    @Override
    public void updateDoctor(Long id, DoctorDto dto) {
        if (doctorRepository.findById(id).isPresent()){
            Doctor doctor = doctorRepository.findById(id).get();
            doctor.setId(doctor.getId());
            doctor.setFirstName(doctor.getFirstName());
            doctor.setLastName(doctor.getLastName());
            doctor.setWorkAddress(doctor.getWorkAddress());
        }
    }

    public DoctorDto transfertoDto(Doctor doctor){
        var dto = new DoctorDto();
        dto.setFirstName(doctor.getFirstName());
        dto.setId(doctor.getId());
        dto.setLastName(doctor.getLastName());
        dto.setClients(dto.getClients());
        dto.setWorkAddress(dto.getWorkAddress());

        return dto;
    }

    public Doctor transferToDoctor (DoctorDto dto){
        var doctor = new Doctor();

        doctor.setId(dto.getId());
        doctor.setFirstName(dto.getFirstName());
        doctor.setLastName(dto.getLastName());
        doctor.setWorkAddress(doctor.getWorkAddress());
        return doctor;
    }
}
