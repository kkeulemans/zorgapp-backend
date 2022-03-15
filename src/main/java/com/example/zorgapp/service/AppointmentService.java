package com.example.zorgapp.service;

import com.example.zorgapp.models.Appointment;
import com.example.zorgapp.models.Doctor;

import java.util.List;

public interface AppointmentService {

    public List<Appointment> getAllAppointments();
    public Appointment getAppointment(Long id);
    Doctor addAppointment (Appointment appointment);
    void deleteAppointment(Long id);
    void updateAppointment(Long id, Appointment appointment);
}
