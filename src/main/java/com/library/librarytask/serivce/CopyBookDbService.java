package com.library.librarytask.serivce;

import com.library.librarytask.domain.CopyBook;
import com.library.librarytask.exceptions.CopyBookException;
import com.library.librarytask.repository.CopyBookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CopyBookDbService {

    private final CopyBookRepository copyBookRepository;

    public List<CopyBook> getAllCopyBooks(){
        return copyBookRepository.findAll();
    }

    public CopyBook getCopyBookById(final Long id) throws CopyBookException {
        return copyBookRepository.findById(id).orElseThrow(CopyBookException::new);
    }

    public CopyBook saveCopyBook(final CopyBook copyBook){
        return copyBookRepository.save(copyBook);
    }
}
