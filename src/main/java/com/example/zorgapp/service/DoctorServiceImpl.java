package com.example.zorgapp.service;

import com.example.zorgapp.dto.ClientDto;
import com.example.zorgapp.dto.DoctorDto;
import com.example.zorgapp.exceptions.RecordNotFoundException;
import com.example.zorgapp.models.Appointment;
import com.example.zorgapp.models.Client;
import com.example.zorgapp.models.Doctor;
import com.example.zorgapp.repositories.AppointmentRepository;
import com.example.zorgapp.repositories.ClientRepository;
import com.example.zorgapp.repositories.DoctorRepository;
import com.example.zorgapp.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public List<DoctorDto> getAllDoctors() {
        List<Doctor> doctorList = doctorRepository.findAll();
        List<DoctorDto> doctorDtoList = new ArrayList<>();


        for (Doctor doctor : doctorList) {
            DoctorDto dto = transfertoDto(doctor);
            doctorDtoList.add(dto);
        }
        return doctorDtoList;
    }

    @Override
    public DoctorDto getDoctorById(Long id) {
        Optional<Doctor> doctor = doctorRepository.findById(id);
        if (doctor.isPresent()) {
            return transfertoDto(doctor.get());
        } else {
            throw new RecordNotFoundException("No remotecontroller found");
        }
    }

    @Override
    public void addClient(Long id, Long clientId) {
        var optionalDoctor = doctorRepository.findById(id);
        var optionalClient = clientRepository.findById(clientId);

        if (optionalClient.isPresent() && optionalDoctor.isPresent()) {
            var doctor = optionalDoctor.get();
            var client = optionalClient.get();

            doctor.addClient(client);
            client.setDoctor(doctor);
            doctorRepository.save(doctor);
            clientRepository.save(client);
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
        dto.setId(id);
        if (doctorRepository.findById(id).isPresent()) {
            Doctor doctor = doctorRepository.findById(id).get();
            doctor.setId(doctor.getId());
            doctor.setFirstName(doctor.getFirstName());
            doctor.setLastName(doctor.getLastName());
            doctor.setWorkAddress(doctor.getWorkAddress());
            doctor.setEmail(doctor.getEmail());
            doctor.setPassword(doctor.getPassword());
            doctor.setUsername(doctor.getUsername());
            doctorRepository.save(doctor);
        }
    }

    public DoctorDto transfertoDto(Doctor doctor) {
        var dto = new DoctorDto();
        dto.setFirstName(doctor.getFirstName());
        dto.setId(doctor.getId());
        dto.setLastName(doctor.getLastName());
        dto.setClients(doctor.getClients());
        dto.setWorkAddress(doctor.getWorkAddress());
        dto.setEmail(doctor.getEmail());
        dto.setPassword(doctor.getPassword());
        dto.setUsername(doctor.getUsername());

        return dto;
    }

    public Doctor transferToDoctor(DoctorDto dto) {
        var doctor = new Doctor();

        doctor.setId(dto.getId());
        doctor.setFirstName(dto.getFirstName());
        doctor.setLastName(dto.getLastName());
        doctor.setWorkAddress(dto.getWorkAddress());
        doctor.setEmail(dto.getEmail());
        doctor.setPassword(dto.getPassword());
        return doctor;
    }

    @Override
    public void addAppointment(Long id, Long appointmentId) {

        var optionalAppointment = appointmentRepository.findById(appointmentId);
        var optionalDoctor = doctorRepository.findById(id);
        if (optionalAppointment.isPresent() && optionalDoctor.isPresent()) {
            var doctor = optionalDoctor.get();
            var appointment = optionalAppointment.get();

            var list = doctor.getAppointments();
            list.add(appointment);
            doctor.setAppointments(list);
           doctorRepository.save(doctor);
        }
    }



    @Override
    public void addMessage(Long id, Long messageId) {

        var optionalMessage = messageRepository.findById(messageId);
        var optionalClient = clientRepository.findById(id);
        if (optionalMessage.isPresent() && optionalClient.isPresent()) {
            var client = optionalClient.get();
            var message = optionalMessage.get();

            var list = client.getMessages();
            list.add(message);
            client.setMessages(list);
            clientRepository.save(client);
        }
    }


}