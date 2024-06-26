package es.hugoalvarezajenjo.photos.controllers;

import es.hugoalvarezajenjo.photos.model.Photo;
import es.hugoalvarezajenjo.photos.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class DownloadController {
    final PhotoService photoService;

    public DownloadController(@Autowired final PhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> download(@PathVariable String id) {
        final Photo photo = this.photoService.get(id);
        if (photo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        final byte[] data = photo.getData();
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf(photo.getContentType()));
        ContentDisposition build = ContentDisposition.builder("attachment")
                .filename(photo.getName())
                .build();
        headers.setContentDisposition(build);
        return new ResponseEntity<>(data, headers, HttpStatus.OK);
    }
}
