package br.com.jefferson.notebook.domain.repository;

import br.com.jefferson.notebook.domain.model.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends MongoRepository<Contact, String> {
}
