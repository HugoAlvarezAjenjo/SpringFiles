package es.hugoalvarezajenjo.photos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;

public class Photo {
    private String id;
    @NotEmpty
    private String name;
    @JsonIgnore
    private byte[] data;
    private String contentType;

    public Photo() {
    }

    public Photo(final String id, final String name) {
        this.id = id;
        this.name = name;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(final String contentType) {
        this.contentType = contentType;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(final byte[] data) {
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
