package com.library.librarytask.serivce;

import com.library.librarytask.controller.TaskNotFoundException;
import com.library.librarytask.helpers.Status;
import com.library.librarytask.repository.StatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StatusDbService {

    private final StatusRepository repository;

    public Status getStatus(final int statusId) throws TaskNotFoundException{
        return repository.findById(statusId).orElseThrow(TaskNotFoundException::new);
    }
}
