package com.library.librarytask.repository;

import com.library.librarytask.domain.Rents;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RentsRepository  extends CrudRepository<Rents, Long> {

    @Override
    List<Rents> findAll();

    @Override
    Optional<Rents> findById(Long id);

    @Override
    Rents save(final Rents rents);
}
