package com.hospital.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;

public class DBConnectivity {
    static Connection conn = null;
    static Statement stmt = null;
    static String url = "jdbc:mysql://localhost:3306/Hospital";

    private void setup() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, "root", "password");
            stmt = conn.createStatement();
        } catch (SQLException e) {
            throw new Error("Problem", e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public UserDetails validateLogin(String username) throws SQLException {
        setup();
        UserDetails userDetails = new UserDetails();
        String query = String.format("select * from user where username= '%s'", username);
        ResultSet rs = stmt.executeQuery(query);
        System.out.println("Got it!");
        while (rs.next()) {
            userDetails.setUserName(rs.getString(1));
            userDetails.setPassword(rs.getString(3));
            userDetails.setEmail(rs.getString(2));
            System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  "
                    + rs.getString(3));
//			conn.close();
        }
        return userDetails;
    }

    public void insertLoginDetails(String username, String password,
                                   String email, Calendar cal) throws SQLException {
        UserDetails details = new UserDetails(username, password, email);
        String InsertData = "INSERT INTO user VALUES(" + username + ","
                + password + "," + email + ","
                + Calendar.getInstance().toString() + ")";

        ResultSet rs = stmt.executeQuery(InsertData);
        System.out.println(details);
        conn.close();

    }

    public PatientDetails getPatientDetails() throws SQLException {
        PatientDetails details = null;

        ResultSet rs = stmt.executeQuery("Select * from PatientDetails");
        while (rs.next()) {
            details = new PatientDetails(rs.getInt(1), rs.getString(2),
                    rs.getString(3), rs.getInt(4), rs.getInt(5),
                    rs.getString(6), rs.getString(7));
            System.out.println(details);
            conn.close();
        }
        return details;
    }

    public void setPatientDetails(int id, String firstName, String lastName,
                                  int age, int phone, String disease, String medications)
            throws SQLException {
        String InsertData = "INSERT INTO patient VALUES(" + id + ","
                + firstName + "," + lastName + "," + age + "," + phone + ","
                + disease + "," + medications + ")";

        ResultSet rs = stmt.executeQuery(InsertData);
        conn.close();
    }

    public void updatePatientDetails(String username, long phone,
                                     String disease, String medications) throws SQLException {

        String updateStatement = "UPDATE patient SET" + "phone =" + phone + ","
                + "disease =" + disease + "," + "medications =" + medications
                + "WHERE username=" + username;

        ResultSet rs = stmt.executeQuery(updateStatement);
        conn.close();

    }

    public DoctorDetails getDoctorDetails(String username) throws SQLException {
        DoctorDetails details = null;

        ResultSet rs = stmt.executeQuery("Select * from doctor where username="
                + username);
        details = new DoctorDetails(rs.getString(1), rs.getString(2),
                rs.getString(3), rs.getString(4));

        return details;
    }
}
