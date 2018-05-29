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
import java.util.Optional;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
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
          String secCol = rsmd.getColumnName(7);
          String thirdCol = rsmd.getColumnName(5);
          //return new Result(secCol, colCount, 1, thirdCol);
       // 1: id
       // 2: name
       // 3: price
       // 4: rating
       // 5: address
       // 6: type 

         return new Result("getting col count", colCount, 0, , "no type given");
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
          int price = 0;
          String priceQuest = questionnaireResult.getPrice();
          if (priceQuest.equals("$")) {
             price = 1;
          }
          else if (priceQuest.equals("$$")) {
             price = 2;
          }
          else if (priceQuest.equals("$$$")) {
             price = 3;
          }
          else {
             price = 4;
          }

          String query = ""
          if (questionnaireResult.getCategory().equals("restaurant")) {
             if (questionnaireResult.isOver21()) {   
                query = "select * from playces where price<=\"" + price + "\" and cuisine=\"" + questionnaireResult.getCuisine() + "\" and age<=\"" + questionnaireResult.getAge() + "\" and type=\"" + questionnaireResult.getCategory() + "\" and rating>=\"" + questionnaireResult.getRating() + "\"";
             }
             else {
                query = "select * from playces where price<=\"" + price + "\" and cuisine=\"" + questionnaireResult.getCuisine() + "\" and age=\"" + questionnaireResult.getAge() + "\" and type=\"" + questionnaireResult.getCategory() + "\" and rating>=\"" + questionnaireResult.getRating() + "\"";
             }
          }
          else if (questionnaireResult.getCategory().equals("shopping")) {
             if (questionnaireResult.isOver21()) {   
                query = "select * from playces where price<=\"" + price + "\" and age<=\"" + questionnaireResult.getAge() + "\" and type=\"" + questionnaireResult.getCategory() + "\" and rating>=\"" + questionnaireResult.getRating() + "\"";
             }
             else {
                query = "select * from playces where price<=\"" + price + "\" and age=\"" + questionnaireResult.getAge() + "\" and type=\"" + questionnaireResult.getCategory() + "\" and rating>=\"" + questionnaireResult.getRating() + "\"";
             }
          }
          else {
                query = "select * from playces where price<=\"" + price + "\" and type=\"" + questionnaireResult.getCategory() + "\" and rating>=\"" + questionnaireResult.getRating() + "\"";
          }
          
          ResultSet rs = stmt.executeQuery(query);

          MultipleResults.MultipleResultsBuilder multR = MultipleResults.builder();
          int count = 0;
          Result[] r = new Result[5];
          while (rs.next() && count < 5) {
	     r[count] = (new Result(rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getString(5), rs.getString(6)));
             count++;             
          }
 
	  return multR.results(r).build();
       } catch (Exception e) {
          Result[] r = new Result[1];
          r[0] = new Result(e.toString(), 0, 0, "address is not given", "no type given");
         return new MultipleResults(r);
       }
    }
}
