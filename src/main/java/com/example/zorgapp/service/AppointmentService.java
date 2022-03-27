package com.example.zorgapp.service;

import com.example.zorgapp.dto.AppointmentDto;
import com.example.zorgapp.models.Appointment;
import com.example.zorgapp.models.Doctor;

import java.util.List;

public interface AppointmentService {

    public List<Appointment> getAllAppointments();
    public Appointment getAppointment(Long id);
    AppointmentDto addAppointment (AppointmentDto appointmentDto);
    void deleteAppointment(Long id);
    void updateAppointment(Long id, Appointment appointment);
}
