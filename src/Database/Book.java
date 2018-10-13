package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Book {

    public int id;
    public String name;
    public String isbn;
    public String auth;
    public String pubG;

    public Book(String name, String isbn, String auth, String pubG) {
        this.name = name;
        this.isbn = isbn;
        this.auth = auth;
        this.pubG = pubG;
        System.out.println("HELLO");
    }

    public void insertBook(Connection con) throws SQLException {
        String sql = "insert into book values(null,?,?,?,?);";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, this.name);
        ps.setString(2, this.isbn);
        ps.setString(3, this.auth);
        ps.setString(4, this.pubG);
        ps.executeUpdate();
        ps.close();

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIsbn() {
        return isbn;
    }

    
    
        
    
    


    public String getAuth() {
        return auth;
    }

    public String getPubG() {
        return pubG;
    }

    public static ObservableList<Book> getAllBooks(Connection con) throws SQLException {

        ObservableList<Book> bookArray = FXCollections.observableArrayList();

        String sql = "select * from book;";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            //int id = rs.getInt(1);
            String name = rs.getString(2);
            String isbn = rs.getString(3);
            String auth = rs.getString(4);
            String pubG = rs.getString(5);
            Book b = new Book(name, isbn, auth, pubG);

            bookArray.add(b);

        }
        rs.close();
        ps.close();
        return bookArray;
    }

}
