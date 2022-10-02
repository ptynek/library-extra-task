package com.library.librarytask.mapper;


import com.library.librarytask.domain.Reader;
import com.library.librarytask.domain.dto.ReaderDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReaderMapper {

    public Reader mapToReader(final ReaderDto readerDto){
        return new Reader(
                readerDto.getId(),
                readerDto.getFirstName(),
                readerDto.getLastName()
        );
    }

    public ReaderDto mapToReaderDto(final Reader reader){
        return new ReaderDto(
                reader.getId(),
                reader.getFirstName(),
                reader.getLastName()
        );
    }

    public List<ReaderDto> mapToReaderDtoList(final List<Reader> readerList){
        return readerList.stream()
                .map(this::mapToReaderDto)
                .collect(Collectors.toList());
    }

}
