package com.example.schedulingdesktopapplication.model;

/**
 * Model class for reports.
 *
 * @author Yonese James
 */
public class Report {
    /**
     * Variables for the report's
     */
    private String appointmentMonth;
    private int appointmentMonthTotal;
    private String appointmentType;
    private int appointmentTypeTotal;
    private String divisionName;
    private int customerTotal;

    public Report(String appointmentMonth, int appointmentMonthTotal, String appointmentType, int appointmentTypeTotal) {
        this.appointmentMonth = appointmentMonth;
        this.appointmentMonthTotal = appointmentMonthTotal;
        this.appointmentType = appointmentType;
        this.appointmentTypeTotal = appointmentTypeTotal;
    }

    public Report(String divisionName, int customerTotal) {
        this.divisionName = divisionName;
        this.customerTotal = customerTotal;
    }

    public String getAppointmentMonth() {
        return appointmentMonth;
    }

    public void setAppointmentMonth(String appointmentMonth) {
        this.appointmentMonth = appointmentMonth;
    }

    public int getAppointmentMonthTotal() {
        return appointmentMonthTotal;
    }

    public void setAppointmentMonthTotal(int appointmentMonthTotal) {
        this.appointmentMonthTotal = appointmentMonthTotal;
    }

    public String getAppointmentType() {
        return appointmentType;
    }

    public void setAppointmentType(String appointmentType) {
        this.appointmentType = appointmentType;
    }

    public int getAppointmentTypeTotal() {
        return appointmentTypeTotal;
    }

    public void setAppointmentTypeTotal(int appointmentTypeTotal) {
        this.appointmentTypeTotal = appointmentTypeTotal;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public int getCustomerTotal() {
        return customerTotal;
    }

    public void setCustomerTotal(int customerTotal) {
        this.customerTotal = customerTotal;
    }
}
