import java.sql.*;  
    public class WeatherReport {                                                    
    private String city;                                                        
    private String state;                                                       
    private int celsius;                                                        
    private int fahrenheit;                                                     
                                                                                
    public WeatherReport(String city) {                                         
        try {                                                                   
            Class.forName("com.mysql.jdbc.Driver");                             
            Connection con = DriverManager.getConnection(                       
             "us-cdbr-iron-east-05.cleardb.net", "bd9b14204c0c56", "2daf5b5d");                
            Statement stmt = con.createStatement();                             
            ResultSet rs = stmt.executeQuery("select address, name from playces");
                                                                                
            while(rs.next()) {                                                  
               this.city = rs.getString(1);                                     
               this.state = rs.getString(2);                                    
               this.fahrenheit = rs.getInt(3);                                  
               this.celsius = rs.getInt(4);                                     
            }                                                                   
                                                                                
        } catch (Exception e) {                                                 
            System.out.println(e);                                              
        }                                                                       
    }                                                                           
                                                                                
    public String getCity() {                                                   
        return this.city;                                                       
    }                                                                           
                                                                                
    public String getState() {                                                  
        return this.state;                                                      
    }                                                                           
                                                                                
    public int getC() {                                                         
        return this.celsius;                                                    
    }                                                                           
                                                                                
    public int getF() {                                                         
        return this.fahrenheit;                                                 
    }                                                                           
}    
