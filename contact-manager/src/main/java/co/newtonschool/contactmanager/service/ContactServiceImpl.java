package co.newtonschool.contactmanager.service;

import co.newtonschool.contactmanager.model.Person;
import co.newtonschool.contactmanager.repository.ContactRepository;
import co.newtonschool.contactmanager.request.PersonRequest;
import co.newtonschool.contactmanager.response.PersonResponse;
import co.newtonschool.contactmanager.response.SuccessResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ContactServiceImpl implements ContactService {
    private ContactRepository contactRepository;

    public ContactServiceImpl() {
        contactRepository = new ContactRepository();
    }

    @Override
    public ResponseEntity<?> addContact(PersonRequest personRequest) {
        Person person = new Person();
        person.setFirstName(personRequest.firstName());
        person.setLastName(personRequest.lastName());
        person.setCompany(personRequest.company());
        person.setLandline(personRequest.landline());
        person.setMobile(personRequest.mobile());
        person.setEmail(personRequest.email());

        contactRepository.getPersonMap().put(contactRepository.getId(), person);

        return ResponseEntity.ok(new SuccessResponse("Contact Added Successfully"));
    }

    @Override
    public ResponseEntity<?> getContactByPersonId(int personId) {
        Person person = contactRepository.getPersonMap().get(personId);

        PersonResponse personResponse = new PersonResponse(
                personId,
                person.getFirstName(),
                person.getLastName(),
                person.getCompany(),
                person.getLandline(),
                person.getMobile(),
                person.getEmail()
        );

        return new ResponseEntity<>(personResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAllContacts() {
        Map<Integer, Person> personMap = contactRepository.getPersonMap();

        List<PersonResponse> personResponseList = new ArrayList<>();
        for(Map.Entry<Integer, Person> entry : personMap.entrySet()) {
            int id = entry.getKey();
            Person person = entry.getValue();

            PersonResponse personResponse = new PersonResponse(
                    id,
                    person.getFirstName(),
                    person.getLastName(),
                    person.getCompany(),
                    person.getLandline(),
                    person.getMobile(),
                    person.getEmail()
            );

            personResponseList.add(personResponse);
        }

        return new ResponseEntity<>(personResponseList, HttpStatus.OK);
    }
}
