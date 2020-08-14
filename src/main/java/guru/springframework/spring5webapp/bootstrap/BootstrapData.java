package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by sousaJ on 12/08/2020
 * in package - guru.springframework.spring5webapp.bootstrap
 **/
@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) {

        try {
            System.out.println("Started Bootstrap");

            Publisher publisher = new Publisher();
            publisher.setName("SFG Publishing");
            publisher.setCity("St Petersburg");
            publisher.setState("FL");

            publisherRepository.save(publisher);

            System.out.println("publisherRepository.count() = " + publisherRepository.count());

            Author eric = new Author("Eric", "Evans");
            Book ddd = new Book("Domain Driven Design", "123123");
            eric.getBooks().add(ddd);
            ddd.getAuthors().add(eric);
            ddd.setPublisher(publisher);
            publisher.getBooks().add(ddd);

            authorRepository.save(eric);
            bookRepository.save(ddd);
            publisherRepository.save(publisher);

            Author rod = new Author("Rod", "Johnson");
            Book noEBJ = new Book("J2EE Development without EJB", "3939459459");
            rod.getBooks().add(noEBJ);
            noEBJ.getAuthors().add(rod);
            noEBJ.setPublisher(publisher);
            publisher.getBooks().add(noEBJ);

            authorRepository.save(rod);
            bookRepository.save(noEBJ);
            publisherRepository.save(publisher);


            System.out.println("Number of Books = " + bookRepository.count());
            System.out.println("Number of publishers = " + publisherRepository.count());
            System.out.println("publisherRepository.findAll().toString() = " + publisherRepository.findAll().toString());
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
