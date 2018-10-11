/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PersonController {
    public String name;
    public String email;
    public String ph_no;
    
    public PersonController(String name, String email,String ph_no){
        this.name = name;
        this.email = email;
        this.ph_no = ph_no;
        System.out.println("HELLO");
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
    
}

