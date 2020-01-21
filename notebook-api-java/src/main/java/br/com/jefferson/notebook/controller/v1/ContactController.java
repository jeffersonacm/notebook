package br.com.jefferson.notebook.controller.v1;

import br.com.jefferson.notebook.domain.model.Contact;
import br.com.jefferson.notebook.domain.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/api/v1/contact"})
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;

    @GetMapping
    private ResponseEntity<List<Contact>> findAll() {
        List<Contact> contacts = contactRepository.findAll();

        if(contacts.size() > 0) {
            return ResponseEntity.ok(this.contactRepository.findAll());
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping(value = "{id}")
    private ResponseEntity<Contact> findById(@PathVariable String id) {
        Optional<Contact> contact = contactRepository.findById(id);

        if(contact.isPresent()) {
            return ResponseEntity.ok(contact.get());
        } else {
            return ResponseEntity.noContent().build();
        }
    }

 }