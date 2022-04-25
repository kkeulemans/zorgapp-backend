package com.example.zorgapp.service;

import com.example.zorgapp.dto.ImageDto;
import org.springframework.stereotype.Service;

@Service
public interface ImageService {

    public ImageDto addImage(ImageDto dto);
    public ImageDto getImageById(Long id);
    public void deleteImage(Long id);
    public ImageDto updateImage (Long id, ImageDto dto);
    void addToMessage (Long id, Long messageId);
}
