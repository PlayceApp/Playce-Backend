package com.example.playce;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RestController
public class ResultController {
   private static final String ADDRESS_NOT_GIVEN = "Address not given";
   private static final String NO_TYPE_GIVEN = "No type given";

    @RequestMapping("/result")
    public Result generateResult(@RequestParam(value = "name", defaultValue = "Firestone Grill") String name) {
        return new Result(name, 1, 1, ADDRESS_NOT_GIVEN, "no category", 35.2862, -120.654);
    }

    @RequestMapping("/getPlayceResult")
    public Result generatePlayceResult(@RequestParam(value = "name", defaultValue = "Firestone Grill") String playceName) {
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        String query = "select * from playces where name=?";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                "jdbc:mysql://us-cdbr-iron-east-05.cleardb.net/heroku_3cf2d9a2c001143?reconnect=true", "bd9b14204c0c56", "2daf5b5d");

            pstmt = con.prepareStatement(query);
            pstmt.setString(1, playceName);

            rs = pstmt.executeQuery();
            rs.next();
            return new Result(rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getDouble(7), rs.getDouble(8));
        } catch (Exception e) {
            return new Result(e.toString(), 0, 0, ADDRESS_NOT_GIVEN, NO_TYPE_GIVEN, 0, 0);
        } finally {
            closeConnections(rs, pstmt, con);
        }
    }

    @RequestMapping(path = "/questionnaire", method = RequestMethod.POST)
    public MultipleResults generateResults(@RequestBody Questionnaire questionnaire) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                "jdbc:mysql://us-cdbr-iron-east-05.cleardb.net/heroku_3cf2d9a2c001143?reconnect=true", "bd9b14204c0c56", "2daf5b5d");
            int price = questionnaire.getPrice().length();

            String query = "";
            if (questionnaire.getCategory().equals("restaurant")) {
                if (questionnaire.isOver21()) {
                    query = "select * from playces where price <= ? and cuisine = ? and age <= ? and type = ? and rating >= ?";
                } else {
                    query = "select * from playces where price <= ? and cuisine = ? and age = ? and type = ? and rating >= ?";
                }
                pstmt = con.prepareStatement(query);
                pstmt.setInt(1, price);
                pstmt.setString(2, questionnaire.getCuisine());
                pstmt.setInt(3, questionnaire.getAge());
                pstmt.setString(4, questionnaire.getCategory());
                pstmt.setDouble(5, questionnaire.getRating());
            } else if (questionnaire.getCategory().equals("shopping")) {
                if (questionnaire.isOver21()) {
                    query = "select * from playces where price <= ? and age <= ? and type = ? and rating >= ?";
                } else {
                    query = "select * from playces where price <= ? and age = ? and type = ? and rating >= ?";
                }
                pstmt = con.prepareStatement(query);
                pstmt.setInt(1, price);
                pstmt.setInt(2, questionnaire.getAge());
                pstmt.setString(3, questionnaire.getCategory());
                pstmt.setDouble(4, questionnaire.getRating());
            } else {
                query = "select * from playces where price <= ? and type = ? and rating >= ?";
                pstmt = con.prepareStatement(query);
                pstmt.setInt(1, price);
                pstmt.setString(2, questionnaire.getCategory());
                pstmt.setDouble(3, questionnaire.getRating());
            }

            rs = pstmt.executeQuery();

            MultipleResults.MultipleResultsBuilder multR = MultipleResults.builder();
            
            int count = 0;
            Result[] r = new Result[5];
            while (rs.next() && count < 5) {
                r[count] = (new Result(rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getDouble(7), rs.getDouble(8)));
                count++;
            }

            return multR.results(r).build();
        } catch (Exception e) {
            Result[] r = new Result[1];
            r[0] = new Result(e.toString(), 0, 0, ADDRESS_NOT_GIVEN, NO_TYPE_GIVEN, 0, 0);
            return new MultipleResults(r);
        } finally {
            closeConnections(rs, pstmt, con);
        }
    }

    private void closeConnections(ResultSet rs, PreparedStatement pstmt, Connection con) {
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) { /* ignored */ }
        }
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (Exception e) { /* ignored */ }
        }
        if (con != null) {
            try {
                con.close();
            } catch (Exception e) { /* ignored */ }
        }
    }
    public double calculateDistance(double lat1, double long1, double lat2, double long2){
        
        int earthRadiusMi = 3959;
        //function sourced from stack overflow
        //it calculates linear distance between two specified coordinates
        double dLat = degreesToRadians(lat2-lat1);
        double dLon = degreesToRadians(long2-long1);
        double latitude1 = degreesToRadians(lat1);
        double latitude2 = degreesToRadians(lat2);        
        double a = Math.sin(dLat/2) * Math.sin(dLat/2) + Math.sin(dLon/2) * Math.sin(dLon/2) * Math.cos(latitude1) * Math.cos(latitude2); 
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a)); 
        
        return earthRadiusMi * c;
    }
    public static double degreesToRadians(double degrees) {
        return degrees * Math.PI / 180;
    
    }
}
