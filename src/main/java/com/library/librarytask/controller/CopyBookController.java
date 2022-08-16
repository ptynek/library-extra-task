package com.library.librarytask.controller;

import com.library.librarytask.domain.CopyBookDto;
import com.library.librarytask.domain.Title;
import com.library.librarytask.helpers.Status;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/copybooks")
public class CopyBookController {

    List<CopyBookDto> getCopyBooks(){
        return new ArrayList<>();
    }

    @GetMapping(value = "{copybooksId}")
    public CopyBookDto getCopyBook(@PathVariable int copybooksId){
        Title title = new Title(1, "Title1", "Author 1", 2005);
        Status status = new Status();
        String stat = status.statusList().get(0);
        return new CopyBookDto(1, title, stat);
    }

    @DeleteMapping
    public void deleteCopyBook(){

    }

    @PutMapping
    public CopyBookDto updateCopyBook(CopyBookDto copyBookDto){
        Title title = new Title(1, "Title1", "Author 1", 2005);
        Status status = new Status();
        String stat = status.statusList().get(1); //different status
        return new CopyBookDto(1, title, stat);
    }

    @PostMapping
    public void createCopyBook(CopyBookDto copyBookDto){

    }
}
