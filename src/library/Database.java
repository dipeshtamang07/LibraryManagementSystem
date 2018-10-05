/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package library;
import java.sql.*;


public class Database { 

    Connection con;
    String password = "";
    String uri = "jdbc:mysql://localhost:3306/Book";
    String user = "root";
    
    public Connection openConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(uri, user, password);
        return con;
    }
    
    public void closeConnection() throws SQLException{
    	con.close();
    }

}
