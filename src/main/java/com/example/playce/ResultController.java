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
import java.util.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.*;

@CrossOrigin
@RestController
public class ResultController {
   private static final String ADDRESS_NOT_GIVEN = "Address not given";
   private static final String NO_TYPE_GIVEN = "No type given";
   private static final String TYPE = "select * from playces where type=\"";
   private static final String PRICE = "\" and price<=\"";
   private static final String RATING = "\" and rating>=\"";

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
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                "jdbc:mysql://us-cdbr-iron-east-05.cleardb.net/heroku_3cf2d9a2c001143?reconnect=true", "bd9b14204c0c56", "2daf5b5d");
            stmt = con.createStatement();
            int price = questionnaire.getPrice().length();

          ArrayList<String> colNames = new ArrayList<>();
          ArrayList<String> colValues = new ArrayList<>();
          if (questionnaire.getCategory().equals("restaurant")) {
             if (questionnaire.isOver21()) {
                colNames.add(TYPE);
                colValues.add(questionnaire.getCategory());
                colNames.add("\" and cuisine=\"");
                colValues.add(questionnaire.getCuisine());
                colNames.add(PRICE);
                colValues.add(String.valueOf(price));
                colNames.add(RATING);
                colValues.add(String.valueOf(questionnaire.getRating()));
                colNames.add("\" and age<=\"");
                colValues.add(String.valueOf(questionnaire.getAge()));

                rs = getResultSet(colNames, colValues, stmt);

             }
             else {
                colNames.add(TYPE);
                colValues.add(questionnaire.getCategory());
                colNames.add("\" and cuisine=\"");
                colValues.add(questionnaire.getCuisine());
                colNames.add(PRICE);
                colValues.add(String.valueOf(price));
                colNames.add(RATING);
                colValues.add(String.valueOf(questionnaire.getRating()));
                colNames.add("\" and age=\"");
                colValues.add(String.valueOf(questionnaire.getAge()));

                rs = getResultSet(colNames, colValues, stmt);
             }
          }
          else if (questionnaire.getCategory().equals("shopping")) {
             if (questionnaire.isOver21()) {
                colNames.add(TYPE);
                colValues.add(questionnaire.getCategory());
                colNames.add(PRICE);
                colValues.add(String.valueOf(price));
                colNames.add(RATING);
                colValues.add(String.valueOf(questionnaire.getRating()));
                colNames.add("\" and age<=\"");
                colValues.add(String.valueOf(questionnaire.getAge()));

                rs = getResultSet(colNames, colValues, stmt);
             }
             else {
                colNames.add(TYPE);
                colValues.add(questionnaire.getCategory());
                colNames.add(PRICE);
                colValues.add(String.valueOf(price));
                colNames.add(RATING);
                colValues.add(String.valueOf(questionnaire.getRating()));
                colNames.add("\" and age=\"");
                colValues.add(String.valueOf(questionnaire.getAge()));

                rs = getResultSet(colNames, colValues, stmt);
             }
          }
          else {
                colNames.add("select * from playces where type=\"");
                colValues.add(questionnaire.getCategory());
                colNames.add(PRICE);
                colValues.add(String.valueOf(price));
                colNames.add(RATING);
                colValues.add(String.valueOf(questionnaire.getRating()));

                rs = getResultSet(colNames, colValues, stmt);
          }

            MultipleResults.MultipleResultsBuilder multR = MultipleResults.builder();

            int count = 0;
            Result[] r = new Result[5];
            while (rs.next() && count < 5) {
                r[count] = (new Result(rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getDouble(7), rs.getDouble(8)));
                count++;
            }
            
             double rlat = 0.0;
             double rlong = 0.0;
             double qlong = 0.0;
             double qlat = 0.0;
             double distance =0.0;
             
             qlat = questionnaire.getLatitude();
             qlong = questionnaire.getLongitude();

             for (int i = 0; i< count; i++){
                 rlat = r[i].getLatitude();
                 rlong = r[i].getLongitude();
                 distance = calculateDistance(rlat,rlong,qlat,qlong);
                 r[i].setDistance(distance);
            }

            Arrays.sort(r, new SortByDistance());

            return multR.results(r).build();
        } catch (Exception e) {
            Result[] r = new Result[1];
            r[0] = new Result(e.toString(), 0, 0, ADDRESS_NOT_GIVEN, NO_TYPE_GIVEN, 0, 0);
            closeConnections(rs, stmt, con);
            return new MultipleResults(r);
        } finally {
            closeConnections(rs, stmt, con);
        }
    }
    private void closeConnections(ResultSet rs, Statement stmt, Connection con) {
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) { /* ignored */ }
        }
        if (stmt != null) {
            try {
                stmt.close();
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

    private String createQuery(ArrayList<String> colNames, ArrayList<String> colValues) {
         StringBuilder query = new StringBuilder();
         for (int i = 0; i < colNames.size(); i++) {
             query.append(colNames.get(i));
             query.append(colValues.get(i));
         }

         query.append("\"");
         return query.toString();
    }

    private ResultSet getResultSet(ArrayList<String> colNames, ArrayList<String> colValues, Statement stmt) throws Exception {
        String query = createQuery(colNames, colValues);
        ResultSet rs = null;
        try {
           while (!rs.next() && colNames.size() > 1) {
              colNames.remove(colNames.size() - 1);
              colValues.remove(colValues.size() - 1);
              query = createQuery(colNames, colValues);
              rs = stmt.executeQuery(query);
           }
           return rs;
        } catch (Exception e) {
            throw new Exception();
        } finally {
            closeConnections(rs, null, null);
        }

    }
}
