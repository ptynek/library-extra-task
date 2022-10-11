package com.library.librarytask.controller;

import com.library.librarytask.domain.Reader;
import com.library.librarytask.domain.dto.ReaderCreateDto;
import com.library.librarytask.domain.dto.ReaderDto;
import com.library.librarytask.exceptions.ReaderException;
import com.library.librarytask.mapper.ReaderMapper;
import com.library.librarytask.serivce.ReaderDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/readers")
@RequiredArgsConstructor

public class ReaderController {


    private final ReaderDbService readerDbService;
    private final ReaderMapper readerMapper;

    @GetMapping
    public ResponseEntity<List<ReaderDto>> getReaders(){
        List<Reader> readers = readerDbService.getAllReaders();
        return ResponseEntity.ok(readerMapper.mapToReaderDtoList(readers));
    }

    @GetMapping(value = "{readerId}")
    public ResponseEntity<ReaderDto> getReader(@PathVariable int readerId) throws ReaderException {
        return ResponseEntity.ok(readerMapper.mapToReaderDto(readerDbService.getReader(readerId)));
    }

    @DeleteMapping(value = "{readerId}")
    public ResponseEntity<Void> deleteReader(@PathVariable int readerId){
        readerDbService.deleteReader(readerId);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<ReaderDto> updateReader(@RequestBody ReaderDto readerDto){
        Reader reader = readerMapper.mapToReader(readerDto);
        Reader savedReader = readerDbService.saveReader(reader);
        return ResponseEntity.ok(readerMapper.mapToReaderDto(savedReader));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createReader(@RequestBody ReaderCreateDto readerDto){
        Reader reader = readerMapper.mapToReaderCreate(readerDto);
        readerDbService.saveReader(reader);
        return ResponseEntity.ok().build();
    }
}
