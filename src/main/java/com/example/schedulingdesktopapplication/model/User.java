package com.example.schedulingdesktopapplication.model;
import java.util.Locale;
import java.sql.Timestamp;

/**
 * Model class for users.
 *
 * @author Yonese James
 */
public class User {
    /**
     * Variables for the user's id, name, password, createDate, createBy, lastUpdate, and lastUpdatedBy,
     */
    private int userID;
    private String userName;
    public String password;
    private Timestamp createDate;
    private String createBy;
    private Timestamp lastUpdate;
    private String lastUpdatedBy;

    /**
     * Constructor that creates a new instance of the user object.
     *
     * @param userID for the ID of the user.
     * @param userName for the name of the user.
     * @param password for the password of the user.
     * @param createDate for the create date of the user.
     * @param createBy for the create by of the user.
     * @param lastUpdate for the last update of the user.
     * @param lastUpdatedBy for the last updated by of the user.
     */
    public User(int userID, String userName, String password, Timestamp createDate,
                String createBy, Timestamp lastUpdate, String lastUpdatedBy) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.createDate = createDate;
        this.createBy = createBy;
        this.lastUpdate = lastUpdate;
        this.lastUpdatedBy = lastUpdatedBy;
    }

    /**
     * Overloaded Constructor that creates a new instance of the user object.
     *
     * @param userID for the ID of the user.
     * @param userName for the name of the user.
     * @param password for the password of the user.
     */
    public User(int userID, String userName, String password) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
    }

    /**
     * Overloaded Constructor that creates a new instance of the user object.
     *
     * @param userID for the ID of the user.
     * @param userName for the name of the user.
     */
    public User(int userID, String userName) {
        this.userID = userID;
        this.userName = userName;
    }

    /**
     * Getter for the userID of the user.
     *
     * @return the userID.
     */
    public int getUserID() {
        return userID;
    }

    /**
     * Setter for the userID of the user.
     *
     * @param userID to be set for the user.
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }

    /**
     * Getter for the userName of the user.
     *
     * @return the userName.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Setter for the userName of the user.
     *
     * @param userName to be set for the user.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Getter for the password of the user.
     *
     * @return the password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter for the password of the user.
     *
     * @param password to be set for the user.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter for the createDate of the user.
     *
     * @return the createDate.
     */
    public Timestamp getCreateDate() {
        return createDate;
    }

    /**
     * Setter for the createDate of the user.
     *
     * @param createDate to be set for the user.
     */
    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    /**
     * Getter for the createBy of the user.
     *
     * @return the createBy.
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * Setter for the createBy of the user.
     *
     * @param createBy to be set for the user.
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * Getter for the lastUpdate of the user.
     *
     * @return the lastUpdate.
     */
    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    /**
     * Setter for the lastUpdate of the user.
     *
     * @param lastUpdate to be set for the user.
     */
    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    /**
     * Getter for the lastUpdatedBy of the user.
     *
     * @return the lastUpdatedBy.
     */
    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    /**
     * Setter for the lastUpdatedBy of the user.
     *
     * @param lastUpdatedBy to be set for the user.
     */
    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }
}
