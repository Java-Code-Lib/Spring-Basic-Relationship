package com.stradtkt.springboot.repositories;

import com.stradtkt.springboot.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {}
