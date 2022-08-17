package com.library.librarytask.repository;

import com.library.librarytask.domain.Title;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface TitleRepository extends CrudRepository<Title, Integer> {

    @Override
    List<Title> findAll();

    @Override
    Optional<Title> findById(Integer id);

    @Override
    Title save(final Title title);
}
