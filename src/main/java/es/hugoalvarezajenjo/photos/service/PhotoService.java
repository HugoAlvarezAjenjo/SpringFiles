package es.hugoalvarezajenjo.photos.service;

import es.hugoalvarezajenjo.photos.model.Photo;
import es.hugoalvarezajenjo.photos.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhotoService {
    final PhotoRepository photoRepository;

    public PhotoService(@Autowired final PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    public Iterable<Photo> get() {
        return this.photoRepository.findAll();
    }

    public Photo get(final Integer id) {
        return this.photoRepository.findById(id).orElse(null);
    }

    public void delete(final Integer id) {
        this.photoRepository.deleteById(id);
    }

    public void add(final Photo photo) {
        this.photoRepository.save(photo);
    }
}
