package com.library.librarytask.controller;

import com.library.librarytask.domain.Rents;
import com.library.librarytask.domain.dto.RentsDto;
import com.library.librarytask.mapper.RentsMapper;
import com.library.librarytask.serivce.RentsDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/rents")
@RequiredArgsConstructor
public class RentsController {

    private final RentsDbService service;

    private final RentsMapper mapper;

    @GetMapping
    public ResponseEntity<List<RentsDto>> getRents(){
        List<Rents> rents = service.getAllRents();
        return ResponseEntity.ok(mapper.mapToRentsDtoList(rents));
    }

    @GetMapping(value = "{rentsId}")
    public ResponseEntity<RentsDto> getRent(@PathVariable int rentsId) throws TaskNotFoundException{
        return ResponseEntity.ok(mapper.mapToRentsDto(service.getRents(rentsId)));
    }

    @PutMapping
    public ResponseEntity<RentsDto> updateRents(@RequestBody RentsDto rentsDto) {
        Rents rents = mapper.mapToRents(rentsDto);
        Rents savedRent = service.saveRent(rents);
        return ResponseEntity.ok(mapper.mapToRentsDto(savedRent));
    }

    @PostMapping
    public ResponseEntity<Void> createRent(@RequestBody RentsDto rentsDto){
        Rents rents = mapper.mapToRents(rentsDto);
        service.saveRent(rents);
        return ResponseEntity.ok().build();
    }
}
