package com.vijaybheda.firebaseui_firestoreexample;

public class Note {
    private String title;
    private String description;
    private String retailerNameCode;
    private String DrContactNo;
    private String DrEmail;
    private String rate;
    private String speciality;
    private int priority=0;

    public Note() {
        //empty constructor needed
    }

    public Note(String title, String description, String retailerNameCode, String DrCoNo, String DrEmail, String rate, int priority, String spec) {
        this.title = title;
        this.description = description;
        this.retailerNameCode = retailerNameCode;
        this.DrContactNo = DrCoNo;
        this.DrEmail = DrEmail;
        this.priority = priority;
        this.speciality=spec;
        this.rate=rate;
    }

    public String getTitle() { return title; }

    public String getDescription() { return description; }

    public String getRetailerNameCode() { return retailerNameCode; }

    public String getDrContactNo() { return DrContactNo; }

    public String getDrEmail() { return DrEmail; }

    public int getPriority() { return priority; }

    public String getRate() { return rate; }

    public String getSpeciality() { return speciality; }
}
