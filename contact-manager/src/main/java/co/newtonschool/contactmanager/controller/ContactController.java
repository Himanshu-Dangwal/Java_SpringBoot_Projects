package co.newtonschool.contactmanager.controller;

import co.newtonschool.contactmanager.request.PersonRequest;
import co.newtonschool.contactmanager.response.PersonResponse;
import co.newtonschool.contactmanager.response.SuccessResponse;
import co.newtonschool.contactmanager.service.ContactService;
import co.newtonschool.contactmanager.service.ContactServiceImpl;
import jakarta.annotation.PostConstruct;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {
    private ContactService contactService;

    @PostConstruct
    void init() {
        contactService = new ContactServiceImpl();
    }

    @PostMapping("")
    public ModelAndView addContact(@ModelAttribute("person") PersonRequest personRequest) {
        contactService.addContact(personRequest);

        return new ModelAndView("redirect:" + "/contacts");
    }

    @GetMapping("")
    public ModelAndView getAllContacts() {
        ModelAndView modelAndView = new ModelAndView();
        ResponseEntity<?> responseEntity = contactService.getAllContacts();

        List<PersonResponse> personResponseList = (List<PersonResponse>) responseEntity.getBody();

        modelAndView.addObject("personList", personResponseList);
        modelAndView.setViewName("person-list-details");

        return modelAndView;
    }

    @GetMapping("/{personId}")
    public ModelAndView getContactByPersonId(@PathVariable("personId") int personId, Model model) {
        ModelAndView modelAndView = new ModelAndView();
        ResponseEntity<?> responseEntity = contactService.getContactByPersonId(personId);

        PersonResponse personResponse = (PersonResponse) responseEntity.getBody();

        modelAndView.addObject("person", personResponse);
        modelAndView.setViewName("person-details");
        
        return modelAndView;
    }
}
