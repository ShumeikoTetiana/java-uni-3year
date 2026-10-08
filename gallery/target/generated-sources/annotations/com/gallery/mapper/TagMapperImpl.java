package com.gallery.mapper;

import com.gallery.dto.TagDto;
import com.gallery.model.Tag;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.12.1 (Eclipse Adoptium)"
)
@Component
public class TagMapperImpl implements TagMapper {

    @Override
    public TagDto toDto(Tag tag) {
        if ( tag == null ) {
            return null;
        }

        Long id = null;
        String name = null;

        id = tag.getId();
        name = tag.getName();

        TagDto tagDto = new TagDto( id, name );

        return tagDto;
    }

    @Override
    public Tag toEntity(TagDto dto) {
        if ( dto == null ) {
            return null;
        }

        Tag tag = new Tag();

        tag.setName( dto.name() );

        return tag;
    }

    @Override
    public void update(TagDto dto, Tag tag) {
        if ( dto == null ) {
            return;
        }

        tag.setName( dto.name() );
    }
}
