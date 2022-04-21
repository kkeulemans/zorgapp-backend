package com.example.zorgapp.controller;

import com.example.zorgapp.dto.AppointmentDto;
import com.example.zorgapp.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @GetMapping("/appointments")
    public List<AppointmentDto> getAllAppointments(){
        List<AppointmentDto> dtos = appointmentService.getAllAppointments();
        return dtos;
    }

    @GetMapping("/appointments/{id}")
    public AppointmentDto getAppointmentById(@PathVariable("id") Long id){
        AppointmentDto dto = appointmentService.getAppointmentById(id);
        return dto;
    }

    @PostMapping("/appointment")
    public AppointmentDto addAppointment (@RequestBody AppointmentDto dto){
        AppointmentDto appToBeAdded = appointmentService.addAppointment(dto);
        return appToBeAdded;
    }

    @DeleteMapping("/appointments/{id}")
    public void deleteAppointment(@PathVariable("id") Long id){
        appointmentService.deleteAppointment(id);
    }

    @PutMapping("/appointments/{id}")
    public AppointmentDto updateAppointment(@PathVariable("id") Long id, @RequestBody AppointmentDto dto){
        appointmentService.updateAppointment(id,dto);
        return dto;
    }
}
