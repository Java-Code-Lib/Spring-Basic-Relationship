package com.stradtkt.springboot.bootstrap;

import com.stradtkt.springboot.domain.Author;
import com.stradtkt.springboot.domain.Book;
import com.stradtkt.springboot.repositories.AuthorRepository;
import com.stradtkt.springboot.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;

public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author kevin = new Author();
        kevin.setFirstName("Kevin");
        kevin.setLastName("Stradtman");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Development");
        ddd.setIsbn("123456");

        Author kevinSaved = authorRepository.save(kevin);
        Book dddSaved = bookRepository.save(ddd);


        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        Book noEJB = new Book();
        noEJB.setTitle("J2EE Development without EJB");
        noEJB.setIsbn("1234564334344344");

        Author rodSaved = authorRepository.save(rod);
        Book noEJBSaved = bookRepository.save(noEJB);

        kevinSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEJBSaved);
        authorRepository.save(kevinSaved);
        authorRepository.save(rodSaved);

        System.out.println("Author count: " + authorRepository.count());
        System.out.println("Book count: " + bookRepository.count());
    }
}
