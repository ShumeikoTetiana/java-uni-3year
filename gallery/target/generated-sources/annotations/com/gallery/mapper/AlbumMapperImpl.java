package com.gallery.mapper;

import com.gallery.dto.AlbumRequest;
import com.gallery.dto.AlbumResponse;
import com.gallery.model.Album;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.12.1 (Eclipse Adoptium)"
)
@Component
public class AlbumMapperImpl implements AlbumMapper {

    @Override
    public AlbumResponse toResponse(Album album) {
        if ( album == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        String description = null;
        LocalDateTime createdAt = null;

        id = album.getId();
        name = album.getName();
        description = album.getDescription();
        createdAt = album.getCreatedAt();

        AlbumResponse albumResponse = new AlbumResponse( id, name, description, createdAt );

        return albumResponse;
    }

    @Override
    public Album toEntity(AlbumRequest request) {
        if ( request == null ) {
            return null;
        }

        Album album = new Album();

        album.setName( request.name() );
        album.setDescription( request.description() );

        return album;
    }

    @Override
    public void update(AlbumRequest request, Album album) {
        if ( request == null ) {
            return;
        }

        album.setName( request.name() );
        album.setDescription( request.description() );
    }
}
