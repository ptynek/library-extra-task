package com.library.librarytask.repository;

import com.library.librarytask.domain.Reader;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Transactional
@Repository
public interface ReaderRepository extends CrudRepository<Reader, Long> {

    @Override
    List<Reader> findAll();

    @Override
    Optional<Reader> findById(Long id);

    @Override
    Reader save(final Reader reader);
}
