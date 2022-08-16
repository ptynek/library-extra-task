package com.library.librarytask.controller;

import com.library.librarytask.domain.Reader;
import com.library.librarytask.domain.ReaderDto;
import com.library.librarytask.mapper.ReaderMapper;
import com.library.librarytask.serivce.ReaderDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/readers")
@RequiredArgsConstructor
public class ReaderController {

    private final ReaderDbService readerDbService;
    private final ReaderMapper readerMapper;

    @GetMapping
    public List<ReaderDto> getReaders(){
        List<Reader> readers = readerDbService.getAllReaders();
        return readerMapper.mapToReaderDtoList(readers);
    }

    @GetMapping(value = "{readerId}")
    public ReaderDto getReader(@PathVariable int readerId){
        return new ReaderDto(1, "Jan", "Kowalski");
    }

    @DeleteMapping
    public void deleteReader(){

    }

    @PutMapping
    public ReaderDto updateReader(ReaderDto readerDto){
        return new ReaderDto(1, "Szymon", "Kasperczyk");
    }

    @PostMapping
    public void createReader(Reader reader){

    }
}
