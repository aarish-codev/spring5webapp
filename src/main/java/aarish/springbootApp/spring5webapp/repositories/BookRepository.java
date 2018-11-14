package aarish.springbootApp.spring5webapp.repositories;

import aarish.springbootApp.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Aarish on 14-Nov-2018
 */
public interface BookRepository extends CrudRepository<Book, Long> {
}
