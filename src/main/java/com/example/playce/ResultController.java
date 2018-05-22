package com.example.playce;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.*;

@RestController
public class ResultController {
    
    @RequestMapping("/result")
    public Result generateResult(@RequestParam(value="name", defaultValue="Firestone Grill") String name) {
       return new Result(name, 1, 1, "address is not given");
    }

    @RequestMapping("/testDatabase")
    public Result generateResult() {
       try {
          Class.forName("com.mysql.jdbc.Driver");                             
          Connection con = DriverManager.getConnection(                       
          "jdbc:mysql:us-cdbr-iron-east-05.cleardb.net", "bd9b14204c0c56", "2daf5b5d");                
          Statement stmt = con.createStatement();
          ResultSet rs = stmt.executeQuery("select * from playces where name=FirestoneGrill");
          return new Result("firestone grill", 1, 1, "address is not given");
       ///return new Result(rs.getString(1), rs.getInt(2), rs.getDouble(3), rs.getString(4));
       } catch (Exception e) {
         System.out.println(e);
         return new Result(e.toString(), 1, 1, "address is not given");
       }

    }

    
}
