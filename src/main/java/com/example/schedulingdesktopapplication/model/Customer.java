package com.example.schedulingdesktopapplication.model;

import java.sql.Timestamp;

/**
 * Model class for customers.
 *
 * @author Yonese James
 */
public class Customer {
    /**
     * Variables for the customer's id, name, address, postalCode, phone, createDate, createBy, lastUpdate,
     * lastUpdatedBy, divisionID, and divisionName.
     */
    private int customerID;
    private String customerName;
    private String address;
    private String postalCode;
    private String phone;
    private Timestamp createDate;
    private String createBy;
    private Timestamp lastUpdate;
    private String lastUpdatedBy;
    private int divisionID;
    private String divisionName;
    private String country;

    /**
     * Constructor that creates a new instance of the customer object.
     *
     * @param customerID for the ID of the customer.
     * @param customerName for the name of the customer.
     * @param address for the address of the customer.
     * @param postalCode for the postal code of the customer.
     * @param phone for the phone of the customer.
     * @param createDate for the create date of the customer.
     * @param createBy for the create by of the customer.
     * @param lastUpdate for the last update of the customer.
     * @param lastUpdatedBy for the last updated by of the customer.
     * @param divisionID for the division ID of the customer.
     * @param divisionName for the division name of the customer.
     */
    public Customer(int customerID, String customerName, String address, String postalCode, String phone,
                    Timestamp createDate, String createBy, Timestamp lastUpdate, String lastUpdatedBy,
                    int divisionID, String divisionName) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.address = address;
        this.postalCode = postalCode;
        this.phone = phone;
        this.createDate = createDate;
        this.createBy = createBy;
        this.lastUpdate = lastUpdate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.divisionID = divisionID;
        this.divisionName = divisionName;
    }

    /**
     * Overloaded Constructor that creates a new instance of the customer object.
     *
     * @param customerID for the ID of the customer.
     * @param customerName for the name of the customer.
     * @param address for the address of the customer.
     * @param postalCode for the postal code of the customer.
     * @param phone for the phone of the customer.
     * @param createDate for the create date of the customer.
     * @param createBy for the create by of the customer.
     * @param lastUpdate for the last update of the customer.
     * @param lastUpdatedBy for the last updated by of the customer.
     * @param divisionID for the division ID of the customer.
     */
    public Customer(int customerID, String customerName, String address, String postalCode, String phone,
                    Timestamp createDate, String createBy, Timestamp lastUpdate, String lastUpdatedBy,
                    int divisionID) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.address = address;
        this.postalCode = postalCode;
        this.phone = phone;
        this.createDate = createDate;
        this.createBy = createBy;
        this.lastUpdate = lastUpdate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.divisionID = divisionID;
    }

    /**
     * Overloaded Constructor that creates a new instance of the customer object.
     *
     * @param customerID for the ID of the customer.
     * @param customerName for the name of the customer.
     * @param address for the address of the customer.
     * @param postalCode for the postal code of the customer.
     * @param phone for the phone of the customer.
     * @param divisionID for the division ID of the customer.
     */
    public Customer(int customerID, String customerName, String address, String postalCode, String phone, int divisionID) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.address = address;
        this.postalCode = postalCode;
        this.phone = phone;
        this.divisionID = divisionID;
    }

    /**
     * Overloaded Constructor that creates a new instance of the customer object.
     *
     * @param customerID for the ID of the customer.
     * @param customerName for the name of the customer.
     * @param address for the address of the customer.
     * @param postalCode for the postal code of the customer.
     * @param phone for the phone of the customer.
     * @param divisionName for the division name of the customer.
     * @param divisionID for the division ID of the customer.
     * @param country for the country of the customer.
     */
    public Customer(int customerID, String customerName, String address, String postalCode, String phone, String divisionName, int divisionID, String country) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.address = address;
        this.postalCode = postalCode;
        this.phone = phone;
        this.divisionName = divisionName;
        this.divisionID = divisionID;
        this.country = country;
    }

    /**
     * Overloaded constructor that creates a new instance of the Customer object.
     *
     */
    public Customer() {}

    /**
     * Getter for the customerID of the customer.
     *
     * @return the customerID.
     */
    public int getCustomerID() {
        return customerID;
    }

    /**
     * Setter for the customerID of the customer.
     * @return an increment of the customerID
     */
    public int setCustomerID() {
        return customerID++;
    }

    /**
     * Getter for the customerName of the customer.
     *
     * @return the customerName.
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Setter for the customerName of the customer.
     *
     * @param customerName to be set for the customer.
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * Getter for the address of the customer.
     *
     * @return the address.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Setter for the address of the customer.
     *
     * @param address to be set for the customer.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Getter for the postalCode of the customer.
     *
     * @return the postalCode.
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Setter for the postalCode of the customer.
     *
     * @param postalCode to be set for the customer.
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * Getter for the phone of the customer.
     *
     * @return the phone.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Setter for the phone of the customer.
     *
     * @param phone to be set for the customer.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Getter for the createDate of the customer.
     *
     * @return the createDate.
     */
    public Timestamp getCreateDate() {
        return createDate;
    }

    /**
     * Setter for the createDate of the customer.
     *
     * @param createDate to be set for the customer.
     */
    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    /**
     * Getter for the createBy of the customer.
     *
     * @return the createBy.
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * Setter for the createBy of the customer.
     *
     * @param createBy to be set for the customer.
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * Getter for the lastUpdate of the customer.
     *
     * @return the lastUpdate.
     */
    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    /**
     * Setter for the lastUpdate of the customer.
     *
     * @param lastUpdate to be set for the customer.
     */
    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    /**
     * Getter for the lastUpdatedBy of the customer.
     *
     * @return the lastUpdatedBy.
     */
    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    /**
     * Setter for the lastUpdatedBy of the customer.
     *
     * @param lastUpdatedBy to be set for the customer.
     */
    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    /**
     * Getter for the divisionID of the customer.
     *
     * @return the divisionID.
     */
    public int getDivisionID() {
        return divisionID;
    }

    /**
     * Setter for the divisionID of the customer.
     *
     * @param divisionID to be set for the customer.
     */
    public void setDivisionID(int divisionID) {
        this.divisionID = divisionID;
    }

    /**
     * Getter for the divisionName of the customer.
     *
     * @return the divisionName.
     */
    public String getDivisionName() {
        return divisionName;
    }

    /**
     * Setter for the divisionName of the customer.
     *
     * @param divisionName to be set for the customer.
     */
    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }


}
