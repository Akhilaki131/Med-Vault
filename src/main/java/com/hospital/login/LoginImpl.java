package com.hospital.login;

import com.hospital.controller.LoginResponse;
import com.hospital.database.DBConnectivity;
import com.hospital.database.UserDetails;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

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
        mapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);
        LoginResponse response = new LoginResponse();
        response.setCode("success");
        String someJsonString = mapper.writeValueAsString(response);
        return mapper.readValue(someJsonString,
                LoginResponse.class);
    }

}
