package com.hospital.database;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement
public class PatientDetails {

    @XmlElement
    private String Username;
    @XmlElement
    private String FirstName;
    @XmlElement
    private String LastName;
    @XmlElement
    private int Age;
    @XmlElement
    private int Phone;
    @XmlElement
    private String Disease;
    @XmlElement
    private String Medications;

    public PatientDetails(String username, String firstName, String lastName,
                          int age, int phone, String disease, String medications) {
        Username = username;
        FirstName = firstName;
        LastName = lastName;
        Age = age;
        Phone = phone;
        Disease = disease;
        Medications = medications;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        this.Username = username;
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

    public PatientDetails() {
    }

}
