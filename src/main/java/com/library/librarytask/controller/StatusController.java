package com.library.librarytask.controller;

import com.library.librarytask.domain.Status;
import com.library.librarytask.domain.dto.StatusDto;
import com.library.librarytask.exceptions.StatusException;
import com.library.librarytask.mapper.StatusMapper;
import com.library.librarytask.serivce.StatusDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/status")
@RequiredArgsConstructor
public class StatusController {

    private final StatusDbService statusDbService;
    private final StatusMapper statusMapper;

    @GetMapping
    public ResponseEntity<List<StatusDto>> getStatuses(){
        List<Status> statusList = statusDbService.getAllStatuses();
        return ResponseEntity.ok(statusMapper.mapToStatusDtoList(statusList));
    }

    @GetMapping(value = "{statusId}")
    public ResponseEntity<StatusDto> getStatus(@PathVariable long statusId) throws StatusException {
        return ResponseEntity.ok(statusMapper.mapToStatusDto(statusDbService.getStatus(statusId)));
    }


    @PutMapping("/statusUpdate/{status}/{copyBookList}")
    public int updateStatus(@PathVariable Status status,
                            @PathVariable List<Long> copyBookList){
        return statusDbService.updateStatus(status, copyBookList);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createStatus(@RequestBody StatusDto statusDto){
        Status status = statusMapper.mapToStatus(statusDto);
        statusDbService.saveStatus(status);
        return ResponseEntity.ok().build();
    }

}
