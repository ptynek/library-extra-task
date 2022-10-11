package com.library.librarytask.repository;

import com.library.librarytask.domain.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface StatusRepository extends CrudRepository<Status, Long> {


    @Override
    Optional<Status> findById(Long id);

    @Override
    List<Status> findAll();

    @Override
    Status save(Status status);


    @Modifying
    @Query("update COPYBOOK c set c.status =:status where c.id = :copyBookList")
    int updateStatusByCopybookId(Status status, List<Long> copyBookList) ;

}
