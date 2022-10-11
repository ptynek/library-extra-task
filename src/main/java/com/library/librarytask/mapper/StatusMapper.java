package com.library.librarytask.mapper;

import com.library.librarytask.domain.Status;
import com.library.librarytask.domain.dto.StatusDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatusMapper {

    public Status mapToStatus(final StatusDto statusDto){
        return new Status(
                statusDto.getId(),
                statusDto.getStatus()
        );
    }

    public StatusDto mapToStatusDto(final Status status){
        return new StatusDto(
                status.getId(),
                status.getStatus()
        );
    }

    public List<StatusDto> mapToStatusDtoList(final List<Status> statusList){
        return statusList.stream()
                .map(this::mapToStatusDto)
                .collect(Collectors.toList());
    }
}
