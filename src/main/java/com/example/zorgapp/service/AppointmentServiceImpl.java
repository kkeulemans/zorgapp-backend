package com.example.zorgapp.service;

import com.example.zorgapp.models.Appointment;
import com.example.zorgapp.models.Doctor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Override
    public List<Appointment> getAllAppointments() {
        return null;
    }

    @Override
    public Appointment getAppointment(Long id) {
        return null;
    }

    @Override
    public Doctor addAppointment(Appointment appointment) {
        return null;
    }

    @Override
    public void deleteAppointment(Long id) {

    }

    @Override
    public void updateAppointment(Long id, Appointment appointment) {

    }
}
