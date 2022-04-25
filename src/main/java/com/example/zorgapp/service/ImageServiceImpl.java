package com.example.zorgapp.service;


import com.example.zorgapp.dto.ImageDto;
import com.example.zorgapp.exceptions.RecordNotFoundException;
import com.example.zorgapp.models.Image;
import com.example.zorgapp.models.Message;
import com.example.zorgapp.repositories.ImageRepository;
import com.example.zorgapp.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;
    @Autowired
    private MessageRepository messageRepository;

    @Override
    public ImageDto addImage(ImageDto dto) {
        Image image = transferToImage(dto);
        imageRepository.save(image);

        return dto;
    }

    @Override
    public ImageDto getImageById(Long id) {
        if (imageRepository.findById(id).isPresent()){
            Image image = imageRepository.findById(id).get();
            ImageDto imageDto = transferToImageDto(image);
            return imageDto;
        }
        else {
            throw new RecordNotFoundException("No Image Found");
        }
    }

    @Override
    public void deleteImage(Long id) {
        imageRepository.deleteById(id);
    }

    @Override
    public ImageDto updateImage(Long id, ImageDto dto) {
        if (imageRepository.findById(id).isPresent()){
            Image image = imageRepository.findById(id).get();
            image.setId(image.getId());
            image.setContent(dto.getContent());
            imageRepository.save(image);
            return dto;
        }
        else {
            throw new RecordNotFoundException("No Image Found");
        }
    }

    @Override
    public void addToMessage(Long id, Long messageId) {

        Optional<Message> optionalMessage = messageRepository.findById(messageId);
        Optional<Image> optionalImage = imageRepository.findById(id);

        if (optionalMessage.isPresent() && optionalImage.isPresent()){
            var message = optionalMessage.get();
            var image = optionalImage.get();

            image.addToMessage(message);
            imageRepository.save(image);
        }
        else {
            throw new RecordNotFoundException("Image or Message not found");
        }
    }


    public ImageDto transferToImageDto(Image image){

        var dto = new ImageDto();

        dto.setId(image.getId());
        dto.setContent(image.getContent());
        return dto;
    }

    public Image transferToImage (ImageDto dto){
        var image = new Image();

        image.setId(dto.getId());
        image.setContent(dto.getContent());;

        return image;
    }
}
