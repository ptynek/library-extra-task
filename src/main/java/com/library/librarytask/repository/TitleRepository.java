package com.library.librarytask.repository;

import com.library.librarytask.domain.Title;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TitleRepository extends CrudRepository<Title, Integer> {
}
