package com.library.librarytask.repository;

import com.library.librarytask.domain.Reader;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReaderRepository extends CrudRepository<Reader, Integer> {

    @Override
    List<Reader> findAll();

    @Override
    Optional<Reader> findById(Integer id);

    @Override
    Reader save(final Reader reader);
}
