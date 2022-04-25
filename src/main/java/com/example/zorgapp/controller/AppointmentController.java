package com.example.zorgapp.controller;

import com.example.zorgappfinal.dto.AppointmentDto;
import com.example.zorgappfinal.services.AccountAppointmentService;
import com.example.zorgappfinal.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @Autowired
    AccountAppointmentService accountAppointmentService;


    @GetMapping("/appointments")
    public List<AppointmentDto> getAllAppointments() {
        List<AppointmentDto> dtos = appointmentService.getAllAppointments();
        return dtos;
    }

    @GetMapping("/appointments/{id}")
    public AppointmentDto getAppointmentById(@PathVariable("id") Long id) {
        AppointmentDto dto = appointmentService.getAppointmentById(id);
        return dto;
    }

    @PostMapping("/appointments/new")
    public AppointmentDto addAppointment(@RequestBody AppointmentDto dto) {
        AppointmentDto appToBeAdded = appointmentService.addAppointment(dto);
        return appToBeAdded;
    }

    @DeleteMapping("/appointments/{id}")
    public void deleteAppointment(@PathVariable("id") Long id) {
        appointmentService.deleteAppointment(id);
    }

    @PutMapping("/appointments/{id}")
    public AppointmentDto updateAppointment(@PathVariable("id") Long id, @RequestBody AppointmentDto dto) {
        appointmentService.updateAppointment(id, dto);
        return dto;
    }

    @GetMapping("/{accountId}/appointments/")
    public ResponseEntity<List<AppointmentDto>> getAppointmentsByAccountId(@PathVariable("accountId") Long accountId){

        return ResponseEntity.ok().body(accountAppointmentService.getAllByAccountId(accountId));
    }

}