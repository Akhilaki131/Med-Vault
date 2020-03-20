package com.hospital.database;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement
public class PatientDetails {

    @XmlElement
    @JsonIgnore
    @JsonBackReference
    private String username;
    @XmlElement
    @JsonIgnore
    @JsonBackReference
    private String firstname;
    @XmlElement
    @JsonIgnore
    @JsonBackReference
    private String lastname;
    @XmlElement
    @JsonIgnore
    @JsonBackReference
    private int age;
    @XmlElement
    @JsonIgnore
    @JsonBackReference
    private int phone;
    @XmlElement
    @JsonIgnore
    @JsonBackReference
    private String disease;
    @XmlElement
    @JsonIgnore
    @JsonBackReference
    private String medications;

    public PatientDetails(String username, String firstname, String lastname,
                          int age, int phone, String disease, String medications) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.phone = phone;
        this.disease = disease;
        this.medications = medications;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getMedications() {
        return medications;
    }

    public void setMedications(String medications) {
        this.medications = medications;
    }

    public PatientDetails() {
    }

}
