package com.example.schedulingdesktopapplication.model;

import java.sql.Timestamp;

/**
 * Model class for countries.
 *
 * @author Yonese James
 */
public class Country {
    /**
     * Variables for the country's id, name, createDate, createBy, lastUpdate, and lastUpdatedBy.
     */
    private int countryID;
    private String countryName;
    private Timestamp createDate;
    private String createBy;
    private Timestamp lastUpdate;
    private String lastUpdatedBy;

    /**
     * Constructor that creates a new instance of the country object.
     *
     * @param countryID for the ID of the country.
     * @param countryName for the name of the country.
     * @param createDate for the create date of the country.
     * @param createBy for the create by of the country.
     * @param lastUpdate for the last update of the country.
     * @param lastUpdatedBy for the last updated by of the country.
     */
    public Country(int countryID, String countryName, Timestamp createDate, String createBy,
                   Timestamp lastUpdate, String lastUpdatedBy) {
        this.countryID = countryID;
        this.countryName = countryName;
        this.createDate = createDate;
        this.createBy = createBy;
        this.lastUpdate = lastUpdate;
        this.lastUpdatedBy = lastUpdatedBy;
    }

    /**
     * Getter for the countryID of the country.
     *
     * @return the countryID.
     */
    public int getCountryID() {
        return countryID;
    }

    /**
     * Setter for the countryID of the country.
     *
     * @param countryID to be set for the country.
     */
    public void setCountryID(int countryID) {
        this.countryID = countryID;
    }

    /**
     * Getter for the countryName of the country.
     *
     * @return the countryName.
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * Setter for the countryName of the country.
     *
     * @param countryName to be set for the country.
     */
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    /**
     * Getter for the createDate of the country.
     *
     * @return the createDate.
     */
    public Timestamp getCreateDate() {
        return createDate;
    }

    /**
     * Setter for the createDate of the country.
     *
     * @param createDate to be set for the country.
     */
    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    /**
     * Getter for the createBy of the country.
     *
     * @return the createBy.
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * Setter for the createBy of the country.
     *
     * @param createBy to be set for the country.
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * Getter for the lastUpdate of the country.
     *
     * @return the lastUpdate.
     */
    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    /**
     * Setter for the lastUpdate of the country.
     *
     * @param lastUpdate to be set for the country.
     */
    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    /**
     * Getter for the lastUpdatedBy of the country.
     *
     * @return the lastUpdatedBy.
     */
    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    /**
     * Setter for the lastUpdatedBy of the country.
     *
     * @param lastUpdatedBy to be set for the country.
     */
    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }
}
