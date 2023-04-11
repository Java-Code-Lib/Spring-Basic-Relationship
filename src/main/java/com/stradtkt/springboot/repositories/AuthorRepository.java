package com.stradtkt.springboot.repositories;

import com.stradtkt.springboot.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {}
