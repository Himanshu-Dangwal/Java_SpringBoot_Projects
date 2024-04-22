package co.newtonschool.contactmanager.service;

import co.newtonschool.contactmanager.request.PersonRequest;
import org.springframework.http.ResponseEntity;

public interface ContactService {
    ResponseEntity<?> addContact(PersonRequest personRequest);
    ResponseEntity<?> getContactByPersonId(int personId);
    ResponseEntity<?> getAllContacts();
}
