package aarish.springbootApp.spring5webapp.repositories;

import aarish.springbootApp.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
