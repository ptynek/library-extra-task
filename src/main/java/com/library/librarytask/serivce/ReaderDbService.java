package com.library.librarytask.serivce;

import com.library.librarytask.domain.Reader;
import com.library.librarytask.exceptions.ReaderException;
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

    public Reader getReader(final long readerId) throws ReaderException {
        return readerRepository.findById(readerId).orElseThrow(ReaderException::new);
    }

    public Reader saveReader(final Reader reader){
        return readerRepository.save(reader);
    }

    public void deleteReader(final long id){
        readerRepository.deleteById(id);
    }



}
