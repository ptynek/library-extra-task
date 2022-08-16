package com.library.librarytask.repository;

import com.library.librarytask.domain.CopyBook;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CopyBookRepository  extends CrudRepository<CopyBook, Integer> {
}
