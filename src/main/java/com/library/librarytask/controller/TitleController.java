package com.library.librarytask.controller;


import com.library.librarytask.domain.Title;
import com.library.librarytask.domain.TitleDto;
import com.library.librarytask.mapper.TitleMapper;
import com.library.librarytask.serivce.TitleDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/titles")
@RequiredArgsConstructor
public class TitleController {

    private final TitleDbService service;
    private final TitleMapper mapper;

    @GetMapping
    public ResponseEntity<List<TitleDto>> getTitles(){
        List<Title> titles = service.getAllTitles();
        return ResponseEntity.ok(mapper.mapToTitleDtoList(titles));
    }

    @GetMapping(value = "{titleId}")
    public ResponseEntity<TitleDto> getTitle(@PathVariable int titleId) throws TaskNotFoundException {
        return ResponseEntity.ok(mapper.mapToTitleDto(service.getTitle(titleId)));
    }

    @DeleteMapping(value = "{titleId}")
    public ResponseEntity<Void> deleteTitle(@PathVariable int titleId){
        service.deleteTitle(titleId);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<TitleDto> updateTitle(@RequestBody TitleDto titleDto){
        Title title = mapper.mapToTile(titleDto);
        Title savedTitle = service.saveTitle(title)
        return ResponseEntity.ok(mapper.mapToTitleDto(savedTitle));
    }

    @PostMapping
    public ResponseEntity<Void> createTitle(@RequestBody TitleDto titleDto){
        Title title = mapper.mapToTile(titleDto);
        service.saveTitle(title);
        return ResponseEntity.ok().build();
    }
}
