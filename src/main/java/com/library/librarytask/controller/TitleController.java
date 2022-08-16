package com.library.librarytask.controller;


import com.library.librarytask.domain.TitleDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/titles")
public class TitleController {

    @GetMapping
    public List<TitleDto> getTitles(){
        return new ArrayList<>();
    }

    @GetMapping(value = "{titleId}")
    public TitleDto getTitle(@PathVariable int titleId){
        return new TitleDto(1,"Title 1", "Author 1", 2005);
    }

    @DeleteMapping
    public void deleteTitle(){

    }

    @PutMapping
    public TitleDto updateTitle(TitleDto titleDto){
        return new TitleDto(1, "Title 1 updated", "Author 1", 2005);
    }

    @PostMapping
    public void createTitle(TitleDto titleDto){

    }
}
