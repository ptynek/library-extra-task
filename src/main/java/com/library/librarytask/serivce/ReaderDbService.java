package com.library.librarytask.serivce;

import com.library.librarytask.domain.Reader;
import com.library.librarytask.repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReaderDbService {

    private final ReaderRepository readerRepository;

    public List<Reader> getAllReaders(){
        return readerRepository.findAll();
    }

}
