package com.example.zorgapp.service;

import com.example.zorgapp.dto.AppointmentDto;
import com.example.zorgapp.dto.DoctorDto;
import com.example.zorgapp.exceptions.RecordNotFoundException;
import com.example.zorgapp.models.Appointment;
import com.example.zorgapp.models.Doctor;
import com.example.zorgapp.repositories.AppointmentRepository;
import com.example.zorgapp.repositories.ClientRepository;
import com.example.zorgapp.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public List<AppointmentDto> getAllAppointments() {
        List<Appointment> appointmentList = appointmentRepository.findAll();
        List<AppointmentDto> appointmentDtoList = new ArrayList<>();


        for (Appointment appointment : appointmentList) {
            AppointmentDto dto = transferToDto(appointment);
            appointmentDtoList.add(dto);
        }
        return appointmentDtoList;
    }

    @Override
    public AppointmentDto getAppointmentById(Long id) {
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        if (appointment.isPresent()) {
            return transferToDto(appointment.get());
        } else {
            throw new RecordNotFoundException("No remotecontroller found");
        }
    }

    @Override
    public AppointmentDto addAppointment(AppointmentDto appointmentDto) {
        Appointment appointmentToBeAdded = transferToAppointment(appointmentDto);
        appointmentRepository.save(appointmentToBeAdded);
        return appointmentDto;
    }

    @Override
    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }

    @Override
    public void updateAppointment(Long id, Appointment appointment) {
        if (!appointmentRepository.existsById(id)) {
            throw new RecordNotFoundException("No appointment found");
        }
        Appointment storedAppointment = appointmentRepository.findById(id).orElse(null);
        storedAppointment.setId(appointment.getId());
        storedAppointment.setClient(appointment.getClient());
        storedAppointment.setDoctor(appointment.getDoctor());
        storedAppointment.setDate(appointment.getDate());
        storedAppointment.setTime(appointment.getTime());

    }

    @Override
    public void assignToDoctor(Long id, Long doctorId) {
        var optionalAppointment = appointmentRepository.findById(id);
        var optionalDoctor = doctorRepository.findById(doctorId);
        if (optionalAppointment.isPresent() && optionalDoctor.isPresent()) {
            var doctor = optionalDoctor.get();
            var appointment = optionalAppointment.get();

            appointment.setDoctor(doctor);
            appointmentRepository.save(appointment);
        }

    }

    @Override
    public void assignToClient(Long id, Long clientId) {
        var optionalAppointment = appointmentRepository.findById(id);
        var optionalClient = clientRepository.findById(clientId);
        if (optionalAppointment.isPresent() && optionalClient.isPresent()) {
            var client = optionalClient.get();
            var appointment = optionalAppointment.get();

            appointment.setClient(client);
            appointmentRepository.save(appointment);
        }
    }

    public AppointmentDto transferToDto(Appointment appointment) {
        var dto = new AppointmentDto();
        dto.setId(appointment.getId());
        dto.setDate(appointment.getDate());
        dto.setTime(appointment.getTime());
        dto.setClient(appointment.getClient());
        dto.setDoctor(appointment.getDoctor());

        return dto;
    }

    public Appointment transferToAppointment(AppointmentDto appointmentDto) {
        var appointment = new Appointment();
        appointment.setId(appointmentDto.getId());
        appointment.setClient(appointmentDto.getClient());
        appointment.setTime(appointmentDto.getTime());
        appointment.setDate(appointmentDto.getDate());
        appointment.setDoctor(appointmentDto.getDoctor());

        return appointment;
    }

}


