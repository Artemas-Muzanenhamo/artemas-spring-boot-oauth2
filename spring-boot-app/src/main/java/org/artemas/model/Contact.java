package org.artemas.model;

/**
 * Created by amuzanenhamo on 21/03/2017.
 *
 * Model Class for our contacts
 */
public class Contact {

    private String id;
    private String name;
    private String surname;
    private String jobTitle;

    public Contact(String id, String name, String surname, String jobTitle) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.jobTitle = jobTitle;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

}
