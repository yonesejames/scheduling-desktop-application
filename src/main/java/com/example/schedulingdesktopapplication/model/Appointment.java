package com.example.schedulingdesktopapplication.model;

import java.sql.Timestamp;

/**
 * Model class for appointments.
 *
 * @author Yonese James
 */
public class Appointment {
    /**
     * Variables for the appointment's id, title, description, location, type, startDateTime, endDateTime, createDate,
     * createBy, lastUpdate, lastUpdatedBy, customerID, userID, contactID, and contactName.
     */
    private static Integer appointmentID;
    private String title;
    private String description;
    private String location;
    private String type;
    private Timestamp startDateTime;
    private Timestamp endDateTime;
    private Timestamp createDate;
    private String createBy;
    private Timestamp lastUpdate;
    private String lastUpdatedBy;
    private Integer customerID;
    private Integer userID;
    private Integer contactID;
    private String contactName;

    /**
     * Constructor that creates a new instance of the appointment object.
     *
     * @param appointmentID for the ID of the appointment.
     * @param title for the title of the appointment.
     * @param description for the description of the appointment.
     * @param location for the location of the appointment.
     * @param type for the type of the appointment.
     * @param startDateTime for the start date time of the appointment.
     * @param endDateTime for the end date time of the appointment.
     * @param createDate for the create date of the appointment.
     * @param createBy for the create by of the appointment.
     * @param lastUpdate for the last update of the appointment.
     * @param lastUpdatedBy for the last updated by of the appointment.
     * @param customerID for the customer ID of the appointment.
     * @param userID for the user ID of the appointment.
     * @param contactID for the contact ID of the appointment.
     */
    public Appointment(Integer appointmentID, String title, String description, String location, String type,
                       Timestamp startDateTime, Timestamp endDateTime, Timestamp createDate, String createBy,
                       Timestamp lastUpdate, String lastUpdatedBy, Integer customerID, Integer userID,
                       Integer contactID) {
        this.appointmentID = appointmentID;
        this.title = title;
        this.description = description;
        this.location = location;
        this.type = type;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.createDate = createDate;
        this.createBy = createBy;
        this.lastUpdate = lastUpdate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.customerID = customerID;
        this.userID = userID;
        this.contactID = contactID;
    }

    /**
     * Overloaded constructor that creates a new instance of the appointment object.
     *
     * @param appointmentID for the ID of the appointment.
     * @param title for the title of the appointment.
     * @param description for the description of the appointment.
     * @param location for the location of the appointment.
     * @param type for the type of the appointment.
     * @param startDateTime for the start date time of the appointment.
     * @param endDateTime for the end date time of the appointment.
     * @param customerID for the customer ID of the appointment.
     * @param userID for the user ID of the appointment.
     * @param contactID for the contact ID of the appointment.
     */
    public Appointment(Integer appointmentID, String title, String description, String location, String type,
                       Timestamp startDateTime, Timestamp endDateTime, Integer customerID, Integer userID, Integer contactID) {
        this.appointmentID = appointmentID;
        this.title = title;
        this.description = description;
        this.location = location;
        this.type = type;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.createDate = createDate;
        this.createBy = createBy;
        this.lastUpdate = lastUpdate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.customerID = customerID;
        this.userID = userID;
        this.contactID = contactID;
        this.contactName = contactName;
    }

    /**
     * Overloaded constructor that creates a new instance of the appointment object.
     *
     * @param appointmentID for the ID of the appointment.
     * @param title for the title of the appointment.
     * @param description for the description of the appointment.
     * @param location for the location of the appointment.
     * @param type for the type of the appointment.
     * @param startDateTime for the start date time of the appointment.
     * @param endDateTime for the end date time of the appointment.
     * @param customerID for the customer ID of the appointment.
     * @param userID for the user ID of the appointment.
     * @param contactID for the contact ID of the appointment.
     * @param contactName for the contact Name of the appointment.
     */
    public Appointment(Integer appointmentID, String title, String description, String location, String type,
                       Timestamp startDateTime, Timestamp endDateTime, Integer customerID, Integer userID, Integer contactID, String contactName) {
        this.appointmentID = appointmentID;
        this.title = title;
        this.description = description;
        this.location = location;
        this.type = type;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.createDate = createDate;
        this.createBy = createBy;
        this.lastUpdate = lastUpdate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.customerID = customerID;
        this.userID = userID;
        this.contactID = contactID;
        this.contactName = contactName;
    }

    /**
     * Getter for the appointmentID of the appointment.
     *
     * @return the appointmentID.
     */
    public Integer getAppointmentID() {
        return appointmentID;
    }

    /**
     * Setter for the appointmentID of the appointment.
     *
     */
    public static int setAppointmentID() {
        return appointmentID++;
    }

    /**
     * Getter for the title of the appointment.
     *
     * @return the title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Setter for the title of the appointment.
     *
     * @param title to be set for the appointment.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Getter for the description of the appointment.
     *
     * @return the description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter for the description of the appointment.
     *
     * @param description to be set for the appointment.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter for the location of the appointment.
     *
     * @return the location.
     */
    public String getLocation() {
        return location;
    }

    /**
     * Setter for the location of the appointment.
     *
     * @param location to be set for the appointment.
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Getter for the type of the appointment.
     *
     * @return the type.
     */
    public String getType() {
        return type;
    }

    /**
     * Setter for the type of the appointment.
     *
     * @param type to be set for the appointment.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Getter for the startDateTime of the appointment.
     *
     * @return the startDateTime.
     */
    public Timestamp getStartDateTime() {
        return startDateTime;
    }

    /**
     * Setter for the startDateTime of the appointment.
     *
     * @param startDateTime to be set for the appointment.
     */
    public void setStartDateTime(Timestamp startDateTime) {
        this.startDateTime = startDateTime;
    }

    /**
     * Getter for the endDateTime of the appointment.
     *
     * @return the endDateTime.
     */
    public Timestamp getEndDateTime() {
        return endDateTime;
    }

    /**
     * Setter for the endDateTime of the appointment.
     *
     * @param endDateTime to be set for the appointment.
     */
    public void setEndDateTime(Timestamp endDateTime) {
        this.endDateTime = endDateTime;
    }

    /**
     * Getter for the createDate of the appointment.
     *
     * @return the createDate.
     */
    public Timestamp getCreateDate() {
        return createDate;
    }

    /**
     * Setter for the createDate of the appointment.
     *
     * @param createDate to be set for the appointment.
     */
    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    /**
     * Getter for the createBy of the appointment.
     *
     * @return the createBy.
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * Setter for the createBy of the appointment.
     *
     * @param createBy to be set for the appointment.
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * Getter for the lastUpdate of the appointment.
     *
     * @return the lastUpdate.
     */
    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    /**
     * Setter for the lastUpdate of the appointment.
     *
     * @param lastUpdate to be set for the appointment.
     */
    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    /**
     * Getter for the lastUpdatedBy of the appointment.
     *
     * @return the lastUpdatedBy.
     */
    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    /**
     * Setter for the lastUpdatedBy of the appointment.
     *
     * @param lastUpdatedBy to be set for the appointment.
     */
    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    /**
     * Getter for the customerID of the appointment.
     *
     * @return the customerID.
     */
    public Integer getCustomerID() {
        return customerID;
    }

    /**
     * Setter for the customerID of the appointment.
     *
     * @param customerID to be set for the appointment.
     */
    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    /**
     * Getter for the userID of the appointment.
     *
     * @return the userID.
     */
    public Integer getUserID() {
        return userID;
    }

    /**
     * Setter for the userID of the appointment.
     *
     * @param userID to be set for the appointment.
     */
    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    /**
     * Getter for the contactID of the appointment.
     *
     * @return the contactID.
     */
    public Integer getContactID() {
        return contactID;
    }

    /**
     * Setter for the contactID of the appointment.
     *
     * @param contactID to be set for the appointment.
     */
    public void setContactID(Integer contactID) {
        this.contactID = contactID;
    }

    /**
     * Getter for the contactName of the appointment.
     *
     * @return the contactName.
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * Setter for the contactName of the appointment.
     *
     * @param contactName to be set for the appointment.
     */
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }
}
