package com.example.playce;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueryController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/query")
    public List<Result> generateResults(@RequestParam(value="name", defaultValue="Firestone Grill") String name) {
       return new Result(name, 1, 1, "address is not given");
    }
 
    @RequestMapping("/questionnaire", method = RequestMethod.POST)
    public void generateResultsFromQuestionnaire(@RequestBody Questionnaire questionairreResult) {
       /*MysqlDataSource dataSource = new MysqlDataSource();
       dataSource.setURL("us-cdbr-iron-east05.cleardb.net");
       dataSource.setUser("bd9b14204c0c56");
       dataSource.setPassword("2daf5b5d");

       Connection conn = dataSource.getConnection();
       Statement stmt = conn.createStatement();
       ResultSet rs = stmt.executeQuery();
         */     

    }

}
