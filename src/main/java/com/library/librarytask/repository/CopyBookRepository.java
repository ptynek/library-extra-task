package com.library.librarytask.repository;

import com.library.librarytask.domain.CopyBook;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface CopyBookRepository  extends CrudRepository<CopyBook, Long> {

    @Override
    List<CopyBook> findAll();

    @Override
    Optional<CopyBook> findById(Long id);

    @Override
    CopyBook save(CopyBook copyBook);


}
