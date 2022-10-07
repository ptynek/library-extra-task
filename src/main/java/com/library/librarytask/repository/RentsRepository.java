package com.library.librarytask.repository;

import com.library.librarytask.domain.Rents;
import org.hibernate.dialect.Ingres9Dialect;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RentsRepository  extends CrudRepository<Rents, Integer> {

    @Override
    List<Rents> findAll();

    @Override
    Optional<Rents> findById(Integer id);

    @Override
    Rents save(final Rents rents);
}
