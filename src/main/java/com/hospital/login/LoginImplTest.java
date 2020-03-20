package com.hospital.login;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hospital.controller.LoginResponse;
import com.hospital.database.*;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.IOException;
import java.sql.SQLException;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(PowerMockRunner.class)
public class LoginImplTest {

    @InjectMocks
    LoginImpl loginImpl;
    @Mock
    DBConnectivity connectivity;
    @Mock
    UserDetails userDetails;
    @Mock
    PatientDetails patientDetails;
    @Mock
    PatientDetailResponse patientDetail;
    @Mock
    DoctorDetails doctorDetails;
    @Mock
    ObjectMapper objectMapper;

    String username = "username1";
    String password = "password1";
    String email = "email";
    String dummyString = "dummyString";

    @Test
    public void login() throws Exception {
        when(userDetails.getuserName()).thenReturn(username);
        when(userDetails.getPassword()).thenReturn(password);
        when(userDetails.getEmail()).thenReturn(email);
        when(connectivity.validateLogin(Mockito.anyString())).thenReturn(userDetails);
        LoginResponse login = loginImpl.login(username, password);
        Assert.assertNotNull(login);
        assertEquals("success", login.getCode());
    }

    public void getPatientDetails() throws IOException, SQLException {
        when(patientDetails.getAge()).thenReturn(15);
        when(patientDetails.getDisease()).thenReturn(dummyString);
        when(patientDetails.getFirstname()).thenReturn(dummyString);
        when(patientDetails.getLastname()).thenReturn(dummyString);
        when(patientDetails.getMedications()).thenReturn(dummyString);
        when(patientDetails.getPhone()).thenReturn(123456);
        when(patientDetails.getUsername()).thenReturn(username);
        when(connectivity.getPatientDetails(Mockito.anyString())).thenReturn(patientDetails);
        when(objectMapper.writeValueAsString(Mockito.anyString())).thenReturn(Mockito.anyString());
        when(objectMapper.readValue(Mockito.anyString(), PatientDetailResponse.class)).thenReturn(patientDetail);
        PatientDetailResponse patientDetails = loginImpl.getPatientDetails(username);
        assertNotNull(patientDetails);
        assertEquals(dummyString, patientDetails.getFirstname());
        assertEquals(username, patientDetails.getUsername());
        assertEquals(dummyString, patientDetails.getLastname());
        assertEquals(dummyString, patientDetails.getDisease());
        assertEquals(dummyString, patientDetails.getMedications());
        assertEquals(15, patientDetails.getAge());
        assertEquals(123456, patientDetails.getPhone());
    }

    public void getDoctorDetails() throws SQLException, IOException {
        when(doctorDetails.getFirstName()).thenReturn(dummyString);
        when(doctorDetails.getLastName()).thenReturn(dummyString);
        when(doctorDetails.getSpeciality()).thenReturn(dummyString);
        when(doctorDetails.getUsername()).thenReturn(username);
        when(connectivity.getDoctorDetails(Mockito.anyString())).thenReturn(doctorDetails);
        DoctorDetails doctorDetails = loginImpl.getDoctorDetails(username);
        Assert.assertNotNull(doctorDetails);
    }

    @Test
    public void setPatientDetails() throws SQLException {
        when(patientDetails.getAge()).thenReturn(15);
        when(patientDetails.getDisease()).thenReturn(dummyString);
        when(patientDetails.getFirstname()).thenReturn(dummyString);
        when(patientDetails.getLastname()).thenReturn(dummyString);
        when(patientDetails.getMedications()).thenReturn(dummyString);
        when(patientDetails.getPhone()).thenReturn(123456);
        when(patientDetails.getUsername()).thenReturn(username);
        Mockito.doNothing().when(connectivity).setPatientDetails(anyString(), anyString(), anyString(), anyInt(), anyInt(), anyString(), anyString());
        loginImpl.setPatientDetails(patientDetails);
        Mockito.verify(connectivity, times(1)).setPatientDetails(anyString(), anyString(), anyString(), anyInt(), anyInt(), anyString(), anyString());
    }

    @Test
    public void signup() throws SQLException {
        when(userDetails.getuserName()).thenReturn(username);
        when(userDetails.getPassword()).thenReturn(password);
        when(userDetails.getEmail()).thenReturn(email);
        doNothing().when(connectivity).insertLoginDetails(anyString(), anyString(), anyString());
        LoginResponse signup = loginImpl.signup(userDetails);
        assertNotNull(signup);
        assertEquals("success", signup.getCode());
    }

    @Test
    public void setDoctorDetails() throws SQLException {
        when(doctorDetails.getUsername()).thenReturn(username);
        when(doctorDetails.getSpeciality()).thenReturn(dummyString);
        when(doctorDetails.getLastName()).thenReturn(dummyString);
        when(doctorDetails.getFirstName()).thenReturn(dummyString);
        doNothing().when(connectivity).setDoctorDetails(anyString(), anyString(), anyString(), anyString());
        LoginResponse loginResponse = loginImpl.setDoctorDetails(doctorDetails);
        assertNotNull(loginResponse);
        assertEquals("success", loginResponse.getCode());
    }

    @Test
    public void updatePatientDetails() throws SQLException {
        when(patientDetails.getUsername()).thenReturn(username);
        when(patientDetails.getPhone()).thenReturn(1234);
        when(patientDetails.getMedications()).thenReturn(dummyString);
        when(patientDetails.getFirstname()).thenReturn(dummyString);
        when(patientDetails.getLastname()).thenReturn(dummyString);
        when(patientDetails.getDisease()).thenReturn(dummyString);
        when(patientDetails.getAge()).thenReturn(20);
        doNothing().when(connectivity).updatePatientDetails(anyString(), anyLong(), anyString(), anyString());
        loginImpl.updatePatientDetails(patientDetails);
        verify(connectivity, times(1)).updatePatientDetails(anyString(), anyLong(), anyString(), anyString());
    }
}