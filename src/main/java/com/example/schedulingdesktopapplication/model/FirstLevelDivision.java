package com.example.schedulingdesktopapplication.model;

import java.sql.Timestamp;

/**
 * Model class for first level division.
 *
 * @author Yonese James
 */
public class FirstLevelDivision {
    /**
     * Variables for the first level division's id, name, createDate, createBy, lastUpdate, lastUpdatedBy,
     * and countryID.
     */
    private int divisionID;
    private String divisionName;
    private Timestamp createDate;
    private String createBy;
    private Timestamp lastUpdate;
    private String lastUpdatedBy;
    public int countryID;

    /**
     * Constructor that creates a new instance of the first level division object.
     *
     * @param divisionID for the ID of the first level division.
     * @param divisionName for the name of the first level division.
     * @param createDate for the create date of the first level division.
     * @param createBy for the create by of the first level division.
     * @param lastUpdate for the last update of the first level division.
     * @param lastUpdatedBy for the last updated by of the first level division.
     * @param countryID for the country ID of the first level division.
     */
    public FirstLevelDivision(int divisionID, String divisionName, Timestamp createDate,
                              String createBy, Timestamp lastUpdate, String lastUpdatedBy, int countryID) {
        this.divisionID = divisionID;
        this.divisionName = divisionName;
        this.createDate = createDate;
        this.createBy = createBy;
        this.lastUpdate = lastUpdate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.countryID = countryID;
    }

    /**
     * Overloaded constructor that creates a new instance of the first level division object.
     *
     * @param divisionName for the name of the first level division.

     */
    public FirstLevelDivision(String divisionName) {

        this.divisionName = divisionName;

    }

    /**
     * Getter for the divisionID of the first level division.
     *
     * @return the divisionID.
     */
    public int getDivisionID() {
        return divisionID;
    }

    /**
     * Setter for the appointmentID of the first level division.
     *
     * @param divisionID to be set for the first level division.
     */
    public void setDivisionID(int divisionID) {
        this.divisionID = divisionID;
    }

    /**
     * Getter for the divisionName of the first level division.
     *
     * @return the divisionName.
     */
    public String getDivisionName() {
        return divisionName;
    }

    /**
     * Setter for the divisionName of the first level division.
     *
     * @param divisionName to be set for the first level division.
     */
    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    /**
     * Getter for the createDate of the first level division.
     *
     * @return the createDate.
     */
    public Timestamp getCreateDate() {
        return createDate;
    }

    /**
     * Setter for the createDate of the first level division.
     *
     * @param createDate to be set for the first level division.
     */
    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    /**
     * Getter for the createBy of the first level division.
     *
     * @return the createBy.
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * Setter for the createBy of the first level division.
     *
     * @param createBy to be set for the first level division.
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * Getter for the lastUpdate of the first level division.
     *
     * @return the lastUpdate.
     */
    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    /**
     * Setter for the lastUpdate of the first level division.
     *
     * @param lastUpdate to be set for the first level division.
     */
    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    /**
     * Getter for the lastUpdatedBy of the first level division.
     *
     * @return the lastUpdatedBy.
     */
    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    /**
     * Setter for the lastUpdatedBy of the first level division.
     *
     * @param lastUpdatedBy to be set for the first level division.
     */
    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    /**
     * Getter for the countryID of the first level division.
     *
     * @return the countryID.
     */
    public int getCountryID() {
        return countryID;
    }

    /**
     * Setter for the countryID of the first level division.
     *
     * @param countryID to be set for the first level division.
     */
    public void setCountryID(int countryID) {
        this.countryID = countryID;
    }

    @Override
    public String toString() {
        return divisionName;
    }
}
