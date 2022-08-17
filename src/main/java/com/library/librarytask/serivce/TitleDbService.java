package com.library.librarytask.serivce;

import com.library.librarytask.controller.TaskNotFoundException;
import com.library.librarytask.domain.Title;
import com.library.librarytask.repository.TitleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TitleDbService {

    @Autowired
    private final TitleRepository titleRepository;

    public List<Title> getAllTitles(){
        return titleRepository.findAll();
    }

    public Title getTitle(final int titleId) throws TaskNotFoundException {
        return titleRepository.findById(titleId).orElseThrow(TaskNotFoundException::new);
    }

    public Title saveTitle(final Title title){
        return titleRepository.save(title);
    }

    public void deleteTitle(final int id){
        titleRepository.deleteById(id);
    }

}
