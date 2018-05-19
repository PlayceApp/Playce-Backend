package com.example.playce;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

@RestController
public class ResultController {
    
    @RequestMapping("/result")
    public Result generateResult(@RequestParam(value="name", defaultValue="Firestone Grill") String name) {
       return new Result(name, 1, 1, "address is not given");
    }

    @RequestMapping("/testDatabase")
    public DatabaseResult generateDatabase() {

       MysqlDataSource dataSource = new MysqlDataSource();
       dataSource.setURL("us-cdbr-iron-east05.cleardb.net");
       dataSource.setUser("bd9b14204c0c56");
       dataSource.setPassword("2daf5b5d");

       Connection conn = dataSource.getConnection();
       Statement stmt = conn.createStatement();
       ResultSet rs = stmt.executeQuery();
    }
}
