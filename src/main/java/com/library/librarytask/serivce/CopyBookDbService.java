package com.library.librarytask.serivce;

import com.library.librarytask.controller.TaskNotFoundException;
import com.library.librarytask.domain.CopyBook;
import com.library.librarytask.repository.CopyBookRepository;
import lombok.AllArgsConstructor;
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

    public CopyBook getCopyBookById(final Long id) throws TaskNotFoundException{
        return copyBookRepository.findById(id).orElseThrow(TaskNotFoundException::new);
    }

    public CopyBook saveCopyBook(final CopyBook copyBook){
        return copyBookRepository.save(copyBook);
    }
}
