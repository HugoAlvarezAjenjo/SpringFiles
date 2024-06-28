package es.hugoalvarezajenjo.photos.controllers;

import es.hugoalvarezajenjo.photos.model.Photo;
import es.hugoalvarezajenjo.photos.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@RestController
public class PhotosController {

    private final PhotoService photoService;

    public PhotosController(@Autowired final PhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping("/")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/photos")
    public Iterable<Photo> getPhotos() {
        return this.photoService.get();
    }

    @GetMapping("/photos/{id}")
    public Photo getPhoto(@PathVariable Integer id) {
        final Photo photo = this.photoService.get(id);
        if (photo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            return photo;
        }
    }

    @DeleteMapping("/photos/{id}")
    public void deletePhoto(@PathVariable Integer id) {
        this.photoService.delete(id);
    }

    @PostMapping("/photos")
    public Photo createPhoto(@RequestPart("data") MultipartFile file) throws IOException {
        final Photo photo = new Photo();
        photo.setName(file.getOriginalFilename());
        photo.setData(file.getBytes());
        photo.setContentType(file.getContentType());
        this.photoService.add(photo);
        return photo;
    }
}
