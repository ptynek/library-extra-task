package com.library.librarytask.mapper;

import com.library.librarytask.domain.CopyBook;
import com.library.librarytask.domain.dto.CopyBookDto;
import com.library.librarytask.serivce.CopyBookDbService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CopyBookMapper {

    public CopyBook mapToCopyBook(final CopyBookDto copyBookDto){
        return new CopyBook(
                copyBookDto.getId(),
                copyBookDto.getTitle(),
                copyBookDto.getStatus()
        );
    }

    public CopyBookDto mapToCopyBookDto(final CopyBook copyBook){
        return new CopyBookDto(
                copyBook.getId(),
                copyBook.getTitle(),
                copyBook.getStatus()
        );
    }

    public List<CopyBookDto> mapToCopyBookDtoList(final List<CopyBook> copyBookList){
        return copyBookList.stream()
                .map(this::mapToCopyBookDto)
                .collect(Collectors.toList());
    }
}
