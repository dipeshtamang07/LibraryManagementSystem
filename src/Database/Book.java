
package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Book {
    
    public String name;
    public String isbn;
    public String auth;
    public String pubG;
    
    public Book(String name, String isbn, String auth, String pubG){
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
    
    public void DisplayBook(Connection con ) throws SQLException{
        String sql = "select * from book;";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            System.out.println(rs.getString(1));
            System.out.println(rs.getString(2));
            System.out.println(rs.getString(3));
            System.out.println(rs.getString(4));
            
        }
        
    }
    
}
