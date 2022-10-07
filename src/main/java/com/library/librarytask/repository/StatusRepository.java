package com.library.librarytask.repository;

import com.library.librarytask.domain.Status;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface StatusRepository extends CrudRepository<Status, Integer> {

    @Override
    Optional<Status> findById(Integer id);


    @Modifying
    @Query("update COPYBOOK c set c.status =:status where c.id = :copyBookList")
    int updateStatusByCopybookId(Status status, List<Long> copyBookList) ;

}
