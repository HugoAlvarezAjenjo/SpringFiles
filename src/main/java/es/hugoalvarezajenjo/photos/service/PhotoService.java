package es.hugoalvarezajenjo.photos.service;

import es.hugoalvarezajenjo.photos.model.Photo;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class PhotoService {
    final List<Photo> photos;

    public PhotoService() {
        this.photos = new LinkedList<>();
    }

    public List<Photo> get() {
        return photos;
    }

    public Photo get(final String id) {
        return this.photos.stream().filter(photo -> photo.getId().equals(id)).findFirst().orElse(null);
    }

    public boolean delete(final String id) {
        final Photo photo = this.get(id);
        return this.photos.remove(photo);
    }

    public void add(final Photo photo) {
        this.photos.add(photo);
    }
}
