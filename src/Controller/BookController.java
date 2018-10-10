
package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class BookController {
    
    public String name;
    public String isbn;
    public String auth;
    public String pubG;
    
    public BookController(String name, String isbn, String auth, String pubG){
        this.name = name;
        this.isbn = isbn;
        this.auth = auth;
        this.pubG = pubG;
        System.out.println("HELLO");
    }
    
    public void insertBook(Connection con) throws SQLException{
        String sql = "insert into book values(null,?,?,?,?);";
           
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, this.name);
        ps.setString(2, this.isbn);
        ps.setString(3, this.auth);
        ps.setString(4, this.pubG);
        ps.executeUpdate();
        ps.close();           
        
    }
    
}
