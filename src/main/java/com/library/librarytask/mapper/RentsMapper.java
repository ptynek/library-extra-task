package com.library.librarytask.mapper;

import com.library.librarytask.domain.Rents;
import com.library.librarytask.domain.dto.RentsDto;
import com.library.librarytask.serivce.CopyBookDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RentsMapper {

    private final CopyBookDbService copyBookDbService;

    public Rents mapToRents(final RentsDto rentsDto) {
        return new Rents(
                rentsDto.getId(),
                rentsDto.getCopyBook(),
                rentsDto.getReader(),
                rentsDto.getRentDate(),
                rentsDto.getReturnDate()
        );
    }

    public RentsDto mapToRentsDto(final Rents rents) {
        return new RentsDto(
                rents.getId(),
                rents.getCopybook(),
                rents.getReader(),
                rents.getRentDate(),
                rents.getReturnDate()
        );
    }

    public List<RentsDto> mapToRentsDtoList(final List<Rents> rents){
        return rents.stream()
                .map(this::mapToRentsDto)
                .collect(Collectors.toList());
    }
}
