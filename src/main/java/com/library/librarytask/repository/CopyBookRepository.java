package com.library.librarytask.repository;

import com.library.librarytask.domain.CopyBook;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CopyBookRepository  extends CrudRepository<CopyBook, Long> {

    @Override
    List<CopyBook> findAll();

    @Override
    Optional<CopyBook> findById(Long id);

    @Override
    CopyBook save(CopyBook copyBook);

    @Modifying
    @Query("update COPYBOOK  c set c.status =?1 where c.id in ?2")
    int updateStatusByCopybookId(boolean status, List<Long> copyBookList) ;

}
