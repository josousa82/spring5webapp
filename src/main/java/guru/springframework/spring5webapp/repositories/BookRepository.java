package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by sousaJ on 12/08/2020
 * in package - guru.springframework.spring5webapp.repositories
 **/
@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
}
