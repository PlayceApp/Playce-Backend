package com.example.playce;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@RestController
public class ResultController {
    
    @RequestMapping("/result")
    public Result generateResult(@RequestParam(value="name", defaultValue="Firestone Grill") String name) {
       return new Result(name, 1, 1, "address is not given", "no category");
    }

    @RequestMapping("/getPlayceResult")
    public Result generatePlayceResult(@RequestParam(value="name", defaultValue = "Firestone Grill") String playceName) {
       try {
          Class.forName("com.mysql.jdbc.Driver");                             
          Connection con = DriverManager.getConnection(                       
          "jdbc:mysql://us-cdbr-iron-east-05.cleardb.net/heroku_3cf2d9a2c001143?reconnect=true", "bd9b14204c0c56", "2daf5b5d");                
          Statement stmt = con.createStatement();
          String query = "select * from playces where name=\"" + playceName + "\"";
          ResultSet rs = stmt.executeQuery(query);
          rs.next();  
	  return new Result(rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getString(5), rs.getString(6));
/*
// used in retrieving column names
          ResultSetMetaData rsmd = rs.getMetaData();
          int colCount = rsmd.getColumnCount();
          String secCol = rsmd.getColumnName(6);
          String thirdCol = rsmd.getColumnName(5);
          //return new Result(secCol, colCount, 1, thirdCol);
       // 1: id
       // 2: name
       // 3: price
       // 4: rating
       // 5: address
       // 6: type 
*/
       } catch (Exception e) {
         System.out.println(e);
         return new Result(e.toString(), 0, 0, "address is not given", "no type given");
       }

    }

    
    @RequestMapping(path = "/questionnaire", method = RequestMethod.POST)
    public MultipleResults generateResultsFromQuestionnaire(@RequestBody Questionnaire questionnaireResult) {
      try {
          Class.forName("com.mysql.jdbc.Driver");                             
          Connection con = DriverManager.getConnection(                       
          "jdbc:mysql://us-cdbr-iron-east-05.cleardb.net/heroku_3cf2d9a2c001143?reconnect=true", "bd9b14204c0c56", "2daf5b5d");                
          Statement stmt = con.createStatement();
          String query = "select * from playces where price<=\"" + questionnaireResult.getPrice() + "\" and type=\"" + questionnaireResult.getCategory() + "\" and rating>=\"" + questionnaireResult.getRating() + "\"";
          ResultSet rs = stmt.executeQuery(query);

          MultipleResults.MultipleResultsBuilder multR = MultipleResults.builder();
          int count = 1;
          while (rs.next() && count <= 5) {
             rs.next();
             if (count == 1) {
	        multR.firstResult(new Result(rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getString(5), rs.getString(6)));
             } 
             else if (count == 2) {
	        multR.secondResult(new Result(rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getString(5), rs.getString(6)));
             }             
             else if (count == 3) {
	        multR.thirdResult(new Result(rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getString(5), rs.getString(6)));
             }             
             else if (count == 4) {
	        multR.fourthResult(new Result(rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getString(5), rs.getString(6)));
             }             
             else if (count == 5) {
	        multR.fifthResult(new Result(rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getString(5), rs.getString(6)));
             }             
          }
 
	  return multR.build();
       } catch (Exception e) {
         return new MultipleResults(new Result(e.toString(), 0, 0, "address is not given", "no type given"), null, null, null, null);
       }
    }
}
