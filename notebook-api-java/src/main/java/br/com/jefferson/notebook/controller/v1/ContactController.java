package br.com.jefferson.notebook.controller.v1;

import br.com.jefferson.notebook.domain.model.Contact;
import br.com.jefferson.notebook.domain.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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


    @PostMapping
    private ResponseEntity save(@RequestBody Contact contact) {
        Contact contactSaved = contactRepository.save(contact);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(contactSaved.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping
    private ResponseEntity update(@RequestBody Contact contact) {
        Optional<Contact> contact1 = contactRepository.findById(contact.getId());
        if(contact1.isPresent()) {
            contactRepository.save(contact);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "{id}")
    private ResponseEntity delete(@PathVariable String id) {
        Optional<Contact> contact = contactRepository.findById(id);

        if(contact.isPresent()) {
            contactRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

 }