package org.artemas.services;

import org.artemas.model.Contact;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by amuzanenhamo on 21/03/2017.
 */

@Service
public class ContactService {


    private List<Contact> list = new ArrayList<>(Arrays.asList(
            new Contact("artemas", "Artemas", "Muzanenhamo", "Software Engineer"),
            new Contact("james", "James", "LeBron", "System Admin"),
            new Contact("mark", "Mark", "Jackson", "Software Engineer"),
            new Contact("john", "John", "Terry", "Project Manager"),
            new Contact("steve", "Steve", "Jobs", "Business Analyst"),
            new Contact("maria", "Maria", "Santa", "QA Tester"),
            new Contact("sally", "Sally", "James", "Project Manager")
    ));

    public List<Contact> getAllContacts(){
        //contactRepository.findAll().forEach(list :: add);

        return list;
    }

    public Contact getContact(String id) {

        return list.stream().filter(t -> t.getId().equals(id)).findFirst().get();

    }

    public void addContactDetails(Contact contact) {
        list.add(contact);
    }
}
