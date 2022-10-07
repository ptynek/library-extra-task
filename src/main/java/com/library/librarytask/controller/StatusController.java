package com.library.librarytask.controller;

import com.library.librarytask.domain.CopyBook;
import com.library.librarytask.domain.Status;
import com.library.librarytask.domain.dto.CopyBookDto;
import com.library.librarytask.mapper.CopyBookMapper;
import com.library.librarytask.serivce.CopyBookDbService;
import com.library.librarytask.serivce.StatusDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/status")
@RequiredArgsConstructor
public class StatusController {

    private final StatusDbService statusDbService;

    @PutMapping("/statusUpdate/{status}/{copyBookList}")
    public int updateStatus(@PathVariable Status status,
                            @PathVariable List<Long> copyBookList){
        return statusDbService.updateStatus(status, copyBookList);
    }

}
