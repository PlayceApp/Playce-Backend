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
          "jdbc:mysql://us-cdbr-iron-east-05.cleardb.net/heroku_3cf2d9a2c001143?reconnect=true", "bd9b14204c0c56", "2daf5b5d");                
          Statement stmt = con.createStatement();
          ResultSet rs = stmt.executeQuery("select * from playces where name=\"Firestone Grill\"");
          ResultSetMetaData rsmd = rs.getMetaData();
          int colCount = rsmd.getColumnCount();
          String secCol = rsmd.getColumnName(6);
          String thirdCol = rsmd.getColumnName(5);
          //return new Result(secCol, colCount, 1, thirdCol);
       // 1: id
       // 2: name
       // 3: price
       // 4: result
       // 5: address
       // 6: type 
          return new Result(rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getString(5));
       } catch (Exception e) {
         System.out.println(e);
         return new Result(e.toString(), 1, 1, "address is not given");
       }

    }

    
}
