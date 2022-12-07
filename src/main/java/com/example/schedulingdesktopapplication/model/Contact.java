package com.example.schedulingdesktopapplication.model;

/**
 * Model class for contacts.
 *
 * @author Yonese James
 */
public class Contact {
    /**
     * Variables for the contact's id, name, and email.
     */
    private int contactID;
    private String contactName;
    private String contactEmail;

    /**
     * Constructor that creates a new instance of the contact object.
     *
     * @param contactID for the ID of the contact.
     * @param contactName for the name of the contact.
     * @param contactEmail for the email of the contact.
     */
    public Contact(int contactID, String contactName, String contactEmail) {
        this.contactID = contactID;
        this.contactName = contactName;
        this.contactEmail = contactEmail;
    }

    /**
     * Getter for the contactID of the contact.
     *
     * @return the contactID.
     */
    public int getContactID() {
        return contactID;
    }

    /**
     * Setter for the contactID of the contact.
     *
     * @param contactID to be set for the contact.
     */
    public void setContactID(int contactID) {
        this.contactID = contactID;
    }

    /**
     * Getter for the contactName of the contact.
     *
     * @return the contactName.
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * Setter for the contactName of the contact.
     *
     * @param contactName to be set for the contact.
     */
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    /**
     * Getter for the contactEmail of the contact.
     *
     * @return the contactEmail.
     */
    public String getContactEmail() {
        return contactEmail;
    }

    /**
     * Setter for the contactEmail of the contact.
     *
     * @param contactEmail to be set for the contact.
     */
    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }
}
