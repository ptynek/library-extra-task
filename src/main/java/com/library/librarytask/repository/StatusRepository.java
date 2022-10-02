package com.library.librarytask.repository;

import com.library.librarytask.helpers.Status;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StatusRepository extends CrudRepository<Status, Integer> {

    @Override
    Optional<Status> findById(Integer id);
}
