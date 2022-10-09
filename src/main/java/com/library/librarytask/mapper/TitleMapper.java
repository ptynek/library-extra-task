package com.library.librarytask.mapper;

import com.library.librarytask.domain.Title;
import com.library.librarytask.domain.dto.TitleDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<TitleDto> mapToTitleDtoList(final List<Title> titleList){
        return titleList.stream()
                .map(this::mapToTitleDto)
                .collect(Collectors.toList());
    }
}
