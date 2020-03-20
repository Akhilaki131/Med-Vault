package com.hospital.database;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement
public class DoctorDetails {
    @XmlElement
    @JsonBackReference
    private String username;
    @XmlElement
    @JsonBackReference
    private String firstName;
    @XmlElement
    @JsonBackReference
    private String lastName;
    @XmlElement
    @JsonBackReference
    private String Speciality;

    public DoctorDetails(String username, String firstName, String lastName,
                         String speciality) {
        super();
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        Speciality = speciality;
    }

    public DoctorDetails() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSpeciality() {
        return Speciality;
    }

    public void setSpeciality(String speciality) {
        Speciality = speciality;
    }

}
