package com.library.librarytask.dao;

import com.library.librarytask.domain.Rents;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface RentsDao extends CrudRepository<Rents, Integer> {
}
