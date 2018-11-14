package aarish.springbootApp.spring5webapp.bootstrap;

import aarish.springbootApp.spring5webapp.model.Author;
import aarish.springbootApp.spring5webapp.model.Book;
import aarish.springbootApp.spring5webapp.model.Publisher;
import aarish.springbootApp.spring5webapp.repositories.AuthorRepository;
import aarish.springbootApp.spring5webapp.repositories.BookRepository;
import aarish.springbootApp.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by Aarish on 14-Nov-2018
 */
@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {


    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    private void initData() {

        Publisher p1 = new Publisher();
        p1.setName("BestPublisher");
        p1.setAddress("World");
        publisherRepository.save(p1);


        Author a1 = new Author("Abc", "Def");
        Book b1 = new Book("Java", "001", p1);
        a1.getBooks().add(b1);

        authorRepository.save(a1);
        bookRepository.save(b1);

        Author a2 = new Author("Pqr", "Xyz");
        Book b2 = new Book("Angular", "002", p1);
        a2.getBooks().add(b2);
        authorRepository.save(a2);
        bookRepository.save(b2);
    }
}
