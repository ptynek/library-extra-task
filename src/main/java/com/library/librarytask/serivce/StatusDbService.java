package com.library.librarytask.serivce;

import com.library.librarytask.domain.Status;
import com.library.librarytask.exceptions.StatusException;
import com.library.librarytask.repository.StatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StatusDbService {

    @Autowired
    private final StatusRepository repository;

    public List<Status> getAllStatuses(){
        return repository.findAll();
    }

    public Status getStatus(final long statusId) throws StatusException {
        return repository.findById(statusId).orElseThrow(StatusException::new);
    }

    public int updateStatus(Status status, List<Long> copyBookList){
        return repository.updateStatusByCopybookId(status, copyBookList);
    }

    public Status saveStatus(final Status status){
        return repository.save(status);
    }
}
