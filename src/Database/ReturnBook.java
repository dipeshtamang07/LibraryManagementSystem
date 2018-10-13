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

/**
 *
 * @author dipesh
 */
public class ReturnBook {

    public int bo_id;

    public ReturnBook(int bo_id) {
        this.bo_id = bo_id;
    }

    public void insertReturnBook(Connection con) throws SQLException {
        String sql = "insert into return_book values(null,?,null);";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, this.bo_id);
        ps.executeUpdate();
        ps.close();
    }
    
    public static ObservableList<ReturnBook>getAllReturnBooks(Connection con) throws SQLException{
        ObservableList<ReturnBook> returnBookArray = FXCollections.observableArrayList();
        
        String sql = "select * from return_book;";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            
            int bo_id = rs.getInt(1);

            ReturnBook rb = new ReturnBook(bo_id);
            
            returnBookArray.add(rb);
            
            
        }
        rs.close();
        ps.close();
        return returnBookArray;

    }
}
