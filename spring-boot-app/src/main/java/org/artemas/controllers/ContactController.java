package org.artemas.controllers;

import org.artemas.model.Contact;
import org.artemas.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ContactController {

    @Autowired
    ContactService contactService;

    /**
     * Method to Get all the contacts within the system.
     * @return - a list contacts
     */
	@RequestMapping("/contacts")
	public List<Contact> contactDetails(){
        return contactService.getAllContacts();
	}

    /**
     * Method to Get a specific contact within the system
     * passing in the referencing the Id.
     * @param id - unique identifier for the contact to be returned.
     * @return - a contact matching the id.
     */
	@RequestMapping("/contact/{id}")
	public Contact getContact(@PathVariable String id){
	    return contactService.getContact(id);
    }

    /**
     * Method to Add a Contact to the system.
     * @param contact - Contact object containing all the information to be stored in the system.
     */
	@RequestMapping(method = RequestMethod.POST, value = ("/contacts"))
	public void addContactDetails(Contact contact){
	    contactService.addContactDetails(contact);
    }
	
}
