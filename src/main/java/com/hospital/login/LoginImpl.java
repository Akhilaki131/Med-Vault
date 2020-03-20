package com.hospital.login;

import java.io.IOException;
import java.sql.SQLException;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.hospital.controller.LoginResponse;
import com.hospital.database.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path(value = "/doctors")
public class LoginImpl {
	DBConnectivity connectivity = new DBConnectivity();

	@POST
	@Path(value = "/login")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public LoginResponse login(@QueryParam("username") String username,
			@QueryParam("password") String password) throws Exception {

		boolean isAuthorized = false;
		if (username == null || password == null) {
			throw new Exception("invalid credentials");
		}
		UserDetails userDetails = connectivity.validateLogin(username);
		if (userDetails.getuserName().equals(username)
				&& userDetails.getPassword().equals(password)) {
			isAuthorized = true;
			System.out.println("welcome to Akhila's Hospital");
		} else {
			throw new Exception("incorrect login or password");
		}
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		LoginResponse response = new LoginResponse();
		response.setCode("success");
		String someJsonString = mapper.writeValueAsString(response);
		return mapper.readValue(someJsonString, LoginResponse.class);
	}

	@GET
	@Path(value = "/patientDetails")
	@Produces(MediaType.APPLICATION_JSON)
	public PatientDetailResponse getPatientDetails(
			@QueryParam("patientName") String username) throws SQLException,
			IOException {

		PatientDetails details = new PatientDetails();
		PatientDetailResponse detailResponse = new PatientDetailResponse();
		details = connectivity.getPatientDetails(username);
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		String someJsonString = mapper.writeValueAsString(details);
		connectivity.conn.close();
		detailResponse = mapper.readValue(someJsonString, PatientDetailResponse.class);
		return detailResponse;
	}

	@GET
	@Path(value = "/doctorDetails")
	@Produces(MediaType.APPLICATION_JSON)
	public DoctorDetails getDoctorDetails(
			@QueryParam("doctorName") String username) throws SQLException,
			IOException {

		DoctorDetails details = new DoctorDetails();
		details = connectivity.getDoctorDetails(username);
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		String someJsonString = mapper.writeValueAsString(details);
		connectivity.conn.close();
		return mapper.readValue(someJsonString, DoctorDetails.class);
	}

	@POST
	@Path(value = "/set/PatientDetails")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void setPatientDetails(PatientDetails details) throws SQLException {

		connectivity.setPatientDetails(details.getUsername(),
				details.getFirstname(), details.getLastname(),
				details.getAge(), details.getPhone(), details.getDisease(),
				details.getMedications());

	}

	@POST
	@Path(value = "/signup")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public LoginResponse signup(UserDetails details) throws SQLException {

		connectivity.insertLoginDetails(details.getuserName(),
				details.getPassword(), details.getEmail());
		LoginResponse response = new LoginResponse();
		response.setCode("success");
		return response;

	}

	@POST
	@Path(value = "/set/doctorDetails")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public LoginResponse setDoctorDetails(DoctorDetails details)
			throws SQLException {

		connectivity.setDoctorDetails(details.getUsername(),
				details.getFirstName(), details.getLastName(),
				details.getSpeciality());
		LoginResponse response = new LoginResponse();
		response.setCode("success");
		return response;

	}

	@POST
	@Path(value = "/update/PatientDetails")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void updatePatientDetails(PatientDetails details)
			throws SQLException {

		connectivity.updatePatientDetails(details.getUsername(),
				details.getPhone(), details.getDisease(),
				details.getMedications());

	}

}
