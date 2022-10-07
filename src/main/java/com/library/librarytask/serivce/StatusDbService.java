package com.library.librarytask.serivce;

import com.library.librarytask.controller.TaskNotFoundException;
import com.library.librarytask.domain.Status;
import com.library.librarytask.repository.StatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StatusDbService {

    private final StatusRepository repository;

    public Status getStatus(final int statusId) throws TaskNotFoundException{
        return repository.findById(statusId).orElseThrow(TaskNotFoundException::new);
    }

    public int updateStatus(Status status, List<Long> copyBookList){
        return repository.updateStatusByCopybookId(status, copyBookList);
    }
}
