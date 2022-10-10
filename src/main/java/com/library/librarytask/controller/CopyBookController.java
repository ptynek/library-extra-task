package com.library.librarytask.controller;

import com.library.librarytask.domain.CopyBook;
import com.library.librarytask.domain.Title;
import com.library.librarytask.domain.dto.CopyBookDto;
import com.library.librarytask.domain.dto.TitleDto;
import com.library.librarytask.exceptions.CopyBookException;
import com.library.librarytask.mapper.CopyBookMapper;
import com.library.librarytask.serivce.CopyBookDbService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/copybooks")
@RequiredArgsConstructor
public class CopyBookController {

    private final CopyBookMapper mapper;
    private final CopyBookDbService dbService;

    @GetMapping
    public ResponseEntity<List<CopyBookDto>> getCopyBooks(){
        List<CopyBook> copybooks = dbService.getAllCopyBooks();
        return ResponseEntity.ok(mapper.mapToCopyBookDtoList(copybooks));
    }

    @GetMapping(value = "{copybooksId}")
    public ResponseEntity<CopyBookDto> getCopyBook(@PathVariable long copybooksId) throws CopyBookException {
        return ResponseEntity.ok(mapper.mapToCopyBookDto(dbService.getCopyBookById(copybooksId)));
    }

    @PutMapping
    public ResponseEntity<CopyBookDto> updateCopyBook(@RequestBody CopyBookDto copyBookDto){
        CopyBook copyBook = mapper.mapToCopyBook(copyBookDto);
        CopyBook savedCopyBook = dbService.saveCopyBook(copyBook);
        return ResponseEntity.ok(mapper.mapToCopyBookDto(savedCopyBook));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createCopyBook(@RequestBody CopyBookDto copyBookDto){
        CopyBook copyBook = mapper.mapToCopyBook(copyBookDto);
        dbService.saveCopyBook(copyBook);

        return ResponseEntity.ok().build();
    }


}
