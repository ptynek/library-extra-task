package com.library.librarytask.controller;

import com.library.librarytask.domain.CopyBook;
import com.library.librarytask.domain.dto.CopyBookDto;
import com.library.librarytask.mapper.CopyBookMapper;
import com.library.librarytask.serivce.CopyBookDbService;
import com.library.librarytask.serivce.StatusDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/status")
@RequiredArgsConstructor
public class StatusController {

    private final CopyBookMapper mapper;
    private final CopyBookDbService dbService;
    private final StatusDbService statusDbService;

    @PutMapping
    public ResponseEntity<CopyBookDto> updateStatus(@RequestParam (name = "id") CopyBookDto copyBookDto, @RequestParam(name = "status") int status) throws TaskNotFoundException {
        CopyBook copyBook = mapper.mapToCopyBook(copyBookDto);
        copyBook.setStatus(statusDbService.getStatus(status));
        CopyBook savedCopyBook = dbService.saveCopyBook(copyBook);
        return ResponseEntity.ok(mapper.mapToCopyBookDto(savedCopyBook));
    }
}
