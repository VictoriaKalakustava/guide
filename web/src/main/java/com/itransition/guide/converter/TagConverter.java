package com.itransition.guide.converter;


import com.itransition.guide.dto.TagDTO;
import com.itransition.guide.entity.Tag;
import org.springframework.stereotype.Component;

@Component
public class TagConverter {
    public static Tag convert(TagDTO dto) {
        Tag tag = new Tag();
        tag.setName(dto.getName());
        return tag;
    }

    public static TagDTO convert(Tag tag) {
        TagDTO dto = new TagDTO();
        dto.setId(tag.getId());
        dto.setName(tag.getName());
        return dto;
    }
}
