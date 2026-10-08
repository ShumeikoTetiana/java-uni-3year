package com.gallery.mapper;

import com.gallery.dto.PhotoRequest;
import com.gallery.dto.PhotoResponse;
import com.gallery.dto.TagDto;
import com.gallery.model.AccessLevel;
import com.gallery.model.Album;
import com.gallery.model.Photo;
import com.gallery.model.Tag;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.12.1 (Eclipse Adoptium)"
)
@Component
public class PhotoMapperImpl implements PhotoMapper {

    @Autowired
    private TagMapper tagMapper;

    @Override
    public PhotoResponse toResponse(Photo photo) {
        if ( photo == null ) {
            return null;
        }

        Long albumId = null;
        Long id = null;
        String title = null;
        String url = null;
        String description = null;
        AccessLevel accessLevel = null;
        Set<TagDto> tags = null;
        LocalDateTime createdAt = null;

        albumId = photoAlbumId( photo );
        id = photo.getId();
        title = photo.getTitle();
        url = photo.getUrl();
        description = photo.getDescription();
        accessLevel = photo.getAccessLevel();
        tags = tagSetToTagDtoSet( photo.getTags() );
        createdAt = photo.getCreatedAt();

        PhotoResponse photoResponse = new PhotoResponse( id, title, url, description, accessLevel, albumId, tags, createdAt );

        return photoResponse;
    }

    @Override
    public Photo toEntity(PhotoRequest request) {
        if ( request == null ) {
            return null;
        }

        Photo photo = new Photo();

        photo.setTitle( request.title() );
        photo.setUrl( request.url() );
        photo.setDescription( request.description() );
        photo.setAccessLevel( request.accessLevel() );

        return photo;
    }

    @Override
    public void update(PhotoRequest request, Photo photo) {
        if ( request == null ) {
            return;
        }

        photo.setTitle( request.title() );
        photo.setUrl( request.url() );
        photo.setDescription( request.description() );
        photo.setAccessLevel( request.accessLevel() );
    }

    private Long photoAlbumId(Photo photo) {
        Album album = photo.getAlbum();
        if ( album == null ) {
            return null;
        }
        return album.getId();
    }

    protected Set<TagDto> tagSetToTagDtoSet(Set<Tag> set) {
        if ( set == null ) {
            return null;
        }

        Set<TagDto> set1 = LinkedHashSet.newLinkedHashSet( set.size() );
        for ( Tag tag : set ) {
            set1.add( tagMapper.toDto( tag ) );
        }

        return set1;
    }
}
