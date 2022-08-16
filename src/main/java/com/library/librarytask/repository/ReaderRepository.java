package com.library.librarytask.repository;

import com.library.librarytask.domain.Reader;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReaderRepository extends CrudRepository<Reader, Integer> {

    List<Reader> findAll();
}
