/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;




/**
 *
  * Juan Rodriguez 
 * Lab 9
 * Java 2
 * 3-21-2021
 */
public class Student {
       
    private int SID;
    private String FirstName;
    private String LastName;
    private String Street;
    private String City;
    private String State;
    private String Zip;
    private String Email;
    private double Gpa;
    

    
    public Student(int Sid, String firstName, String lastName, String street, String city, String state, String zip , String email, double gpa){
    super();
    this.SID = Sid;
    this.FirstName = firstName;
    this.LastName = lastName;
    this.Street = street;
    this.City = city;
    this.State = state;
    this.Zip = zip;
    this.Email = email;
    this.Gpa = gpa;
    }
    
    public Student(){
    super();
   
    }
           public void Display(){
   System.out.println(" ID " + getSID() + "\n First Name " + getFirstName()

+ " \n Last Name " + getLastName() + " \n Email " + getEmail()

+ " \n City " + getCity() + " \n Street " + getStreet()

+ " \n State " + getState() + " \n Zip " + getZip()

+ " \n GPA " + getGpa());
    }
           
     public int setSID(int Sid){
       return SID = Sid;
    }
      public int getSID(){
        return SID;
    }
     public String setFirstName(String firstName){
     return FirstName = firstName;
     }
      public String getFirstName(){
        return FirstName;
    }
     public String setLastName(String lastName){
     return LastName = lastName;
     }
      public String getLastName() {
        return LastName;
    }
     public String setStreet(String street){
     return Street = street;
     }
     public String getStreet(){
        return Street;
    }
     public String setCity(String city){
     return City = city;
     }
      public String getCity(){
        return City;
    }
     public String setState(String state) {
     return State = state;
     }
     public String getState() {
        return State;
    }
     public String setZip(String zip) {
     return Zip = zip;
     }
       public String getZip(){
        return Zip;
    }
     public String setEmail(String email) {
     return Email = email;
     }
     public String getEmail() {
        return Email;
    }
     public double setGpa(Double gpa) {
     return Gpa = gpa;
     }
     public double getGpa() {
        return Gpa;
    }
 
     public void selectDB(int SID){
    this.SID = SID;
            
        try{
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        
        Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Juan/OneDrive/ENGLISH  0900/java spring semester/Lab8/JavaFXApplication/src/Business/RegistrationDB.mdb");
        System.out.println("DB Connected");
        
        Statement stmt = con.createStatement();
        
        String sql;
        sql = "SELECT * from Students where ID ='"+getSID()+"'";
        System.out.println(sql);
    
        ResultSet rs;
        rs = stmt.executeQuery(sql);
        rs.next();
     
      setSID(rs.getInt(1));
      setFirstName(rs.getString(2));
      setLastName(rs.getString(3));
      setStreet(rs.getString("Street"));
      setCity(rs.getString("City"));
      setState(rs.getString("State"));
      setZip(rs.getString("Zip"));
      setEmail(rs.getString("EMail"));
      setGpa(rs.getDouble("GPA"));
      
    }catch(Exception e){
        System.out.println(e);
        e.printStackTrace();
        }
    
}
    public void insertDB(int sid, String firstName, String lastName, String street, String city, String state, String zip, String email, Double gpa){
    
    this.SID = sid;
    this.FirstName = firstName;
    this.LastName = lastName;
    this.Street = street;
    this.City = city;
    this.State = state;
    this.Zip = zip;
    this.Email = email;
    this.Gpa = gpa;
    try{
    Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        
        Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Juan/OneDrive/ENGLISH  0900/java spring semester/Lab8/JavaFXApplication/src/Business/RegistrationDB.mdb");
        System.out.println("DB Connected");
        
        Statement stmt = con.createStatement();
        
      String sql = "INSERT INTO Students VALUES('"+getSID()+"','"+getFirstName()+"','"+getLastName()+"','"+getStreet()+"','"+getCity()+"','"+ getState()+"','"+getZip()+"','"+getEmail()+"','"+getGpa()+"')";
        System.out.println(sql);
            int n1 = stmt.executeUpdate(sql);
            if (n1==1){
                System.out.println("INSERT Successful!!!");
            } else{
                System.out.println("INSERT FAILED***********");
            con.close();
            
            }
    }catch(Exception e){
    System.out.println(e);
    e.printStackTrace();
    }
        
    }
     public void deleteDB(){
        
        try{
    Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        
        Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Juan/OneDrive/ENGLISH  0900/java spring semester/Lab8/JavaFXApplication/src/Business/RegistrationDB.mdb");
        System.out.println("DB Connected");
        
        Statement stmt = con.createStatement();
        System.out.println("Student id is :"+getSID());
          String sql = "DELETE FROM Students WHERE ID = '" + getSID() + "';";
          
           int n1 = stmt.executeUpdate(sql);
            if (n1==1)
                System.out.println("Delete Successful!!!");
            else
                System.out.println("Delete FAILED***********");

            con.close();
            System.out.println(sql);
        }catch(Exception e){
         System.out.println(e);
        }
     
     }
    
     public void updateDB(){
        int id = getSID();
        String fname = getFirstName();
        String lname = getLastName();
        String street = getStreet();
        String city = getCity();
        String state = getState();
        String email = getEmail();
        String zip = getZip();
        double gpa = getGpa();
     try{
     Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        
        Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Juan/OneDrive/ENGLISH  0900/java spring semester/Lab8/JavaFXApplication/src/Business/RegistrationDB.mdb");
        System.out.println("DB Connected");
        
        Statement stmt = con.createStatement();
     
          String sql = "UPDATE Students " +
                    "SET FirstName = '" + fname + "', LastName = '" + lname + "', Street = '" + street + "', City = '" + city + "', State = '" + state +
                    "', Zip = " + zip + ", Email = '" + email + "', GPA = " + gpa +" WHERE ID = "+ id ;

            stmt.executeUpdate(sql);
            System.out.println(sql);


            int n1 = stmt.executeUpdate(sql);
            if (n1==1)
                System.out.println("UPDATE Successful!!!");
            else
                System.out.println("UPDATE FAILED***********");

            con.close();
     }catch(Exception  e){
      System.out.println(e);
     }
     }

    
   public static void main(String[] args) {
        Student s1 = new Student();
        s1.selectDB(4);
        s1.Display();       
       
        Student s2 = new Student();
        s2.insertDB(45, "Frank", "Mayes", "123 Main street", "Atlanta", "GA", "30100" , "fMayes@Yahoo.com", 3.3);
        s2.Display();
        
        Student s3 = new Student();
        s3.selectDB(45);
        s3.deleteDB();

        Student s4 = new Student();
        s4.selectDB(7);
        s4.setZip("30106");
        s4.updateDB();
        
         System.out.println("Main is running");
        }

   

    
    
 
     
}
