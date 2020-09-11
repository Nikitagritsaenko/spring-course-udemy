package com.example.course.bootstrap;

import com.example.course.domain.Author;
import com.example.course.domain.Book;
import com.example.course.domain.Publisher;
import com.example.course.repositories.AuthorRepository;
import com.example.course.repositories.BookRepository;
import com.example.course.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) {

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "13124");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        Publisher grits = new Publisher();
        ddd.setPublisher(grits);
        noEJB.setPublisher(grits);
        grits.getBooks().add(ddd);
        grits.getBooks().add(noEJB);

        publisherRepository.save(grits);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of publishers:   " + publisherRepository.count());
        System.out.println("Number of publisher's books:   " + grits.getBooks().size());
    }
}
