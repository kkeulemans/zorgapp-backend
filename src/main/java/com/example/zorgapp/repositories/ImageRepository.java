package com.example.zorgapp.repositories;
import com.example.zorgapp.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
