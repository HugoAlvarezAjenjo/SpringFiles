package es.hugoalvarezajenjo.photos.repository;

import es.hugoalvarezajenjo.photos.model.Photo;
import org.springframework.data.repository.CrudRepository;

public interface PhotoRepository extends CrudRepository<Photo, Integer> {
}
