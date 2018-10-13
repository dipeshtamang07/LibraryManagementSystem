/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Person {
    public String name;
    public String email;
    public String ph_no;
    
    public Person(String name, String email,String ph_no){
        this.name = name;
        this.email = email;
        this.ph_no = ph_no;
        System.out.println("HELLO");
        
        
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPh_no() {
        return ph_no;
    }
    
    public void insertPerson(Connection con) throws SQLException{
        String sql = "insert into person values(null,?,?,?);";
           
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, this.name);
        ps.setString(2, this.email);
        ps.setString(3, this.ph_no);
        ps.executeUpdate();
        ps.close();           
        
    }
    
    
    
    public static ObservableList<Person>getAllPerson(Connection con) throws SQLException{
        ObservableList<Person> personArray = FXCollections.observableArrayList();
        
        String sql = "select * from person;";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            
            String name = rs.getString(2);
            String email =rs.getString(3);
            String ph_no =rs.getString(4);
            Person p = new Person(name,email,ph_no);
            
            personArray.add(p);
            
            
        }
        rs.close();
        ps.close();
        return personArray;

    }
}

