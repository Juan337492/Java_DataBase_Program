package javafxapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * Juan Rodriguez 
 * Lab 8
 * Java 2
 * 3-14-2021
 */
public class DBTester {
    public static void main(String[] args){
    System.out.println("Starting DB Tester..");    
    
    try{
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        
        Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Juan/OneDrive/ENGLISH  0900/java spring semester/Lab8/JavaFXApplication/src/javafxapplication/RegistrationDB.mdb");
        System.out.println("DB Connected");
        
        Statement stmt = con.createStatement();
        
        String sql;
        sql = "select  * from Instructors";
        System.out.println(sql);
        
        ResultSet rs;
        rs = stmt.executeQuery(sql);
        
        while ( rs.next() ){
    System.out.println(rs.getString(1));
    

    }
        con.close();
        
    }catch(Exception e){
        System.out.println("PP:"+e);
    }
    
    }
}
