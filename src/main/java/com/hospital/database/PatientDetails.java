package com.hospital.database;

public class PatientDetails {

    private int ID;
    private String FirstName;
    private String LastName;
    private int Age;
    private int Phone;
    private String Disease;
    private String Medications;

    public PatientDetails(int iD, String firstName, String lastName, int age,
                          int phone, String disease, String medications) {
        ID = iD;
        FirstName = firstName;
        LastName = lastName;
        Age = age;
        Phone = phone;
        Disease = disease;
        Medications = medications;
    }

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public int getPhone() {
        return Phone;
    }

    public void setPhone(int phone) {
        Phone = phone;
    }

    public String getDisease() {
        return Disease;
    }

    public void setDisease(String disease) {
        Disease = disease;
    }

    public String getMedications() {
        return Medications;
    }

    public void setMedications(String medications) {
        Medications = medications;
    }

}
