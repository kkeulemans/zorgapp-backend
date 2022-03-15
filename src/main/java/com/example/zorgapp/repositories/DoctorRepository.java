package com.example.zorgapp.repositories;

import com.example.zorgapp.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository <Doctor, Long> {
}
