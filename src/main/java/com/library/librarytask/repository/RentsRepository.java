package com.library.librarytask.repository;

import com.library.librarytask.domain.Rents;
import org.hibernate.dialect.Ingres9Dialect;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentsRepository  extends CrudRepository<Rents, Integer> {

    List<Rents> findAll();
}
