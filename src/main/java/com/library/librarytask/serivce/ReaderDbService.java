package com.library.librarytask.serivce;

import com.library.librarytask.controller.TaskNotFoundException;
import com.library.librarytask.domain.Reader;
import com.library.librarytask.repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReaderDbService {

    @Autowired
    private final ReaderRepository readerRepository;

    public List<Reader> getAllReaders(){
        return readerRepository.findAll();
    }

    public Reader getReader(final int readerId) throws TaskNotFoundException {
        return readerRepository.findById(readerId).orElseThrow(TaskNotFoundException::new);
    }

    public Reader saveReader(final Reader reader){
        return readerRepository.save(reader);
    }

    public void deleteReader(final int id){
        readerRepository.deleteById(id);
    }



}
