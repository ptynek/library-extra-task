package com.library.librarytask.mapper;

import com.library.librarytask.domain.Title;
import com.library.librarytask.domain.TitleDto;
import org.springframework.stereotype.Service;

@Service
public class TitleMapper {

    public Title mapToTile(final TitleDto titleDto){
        return new Title(
                titleDto.getId(),
                titleDto.getTitle(),
                titleDto.getAuthor(),
                titleDto.getPublicationYear()
        );
    }

    public TitleDto mapToTitleDto(final Title title){
        return new TitleDto(
                title.getId(),
                title.getTitle(),
                title.getAuthor(),
                title.getPublicationYear()
        );
    }
}
