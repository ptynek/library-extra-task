package com.library.librarytask.repository;

import com.library.librarytask.domain.CopyBook;
import com.library.librarytask.domain.Status;
import com.library.librarytask.domain.Title;
import com.library.librarytask.domain.dto.CopyBookDto;
import com.library.librarytask.domain.dto.StatusDto;
import com.library.librarytask.domain.dto.TitleDto;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
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

    @Modifying
    @Query("update COPYBOOK c set c.title =:title where c.id = :copybook")
    int updateCopybookByTitleId(final List<Long> copybook, final List<Long> title);

    @Modifying
    @Query("update COPYBOOK c set c.status =:status where c.id = :copybook")
    int updateCopybookByStatusId(final List<Long> copybook, final List<Long> status);

}
