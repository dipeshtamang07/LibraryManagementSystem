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
public class BorrowBook {
    public int p_id;
    public int b_id;

    public BorrowBook(int p_id, int b_id) {
        this.p_id = p_id;
        this.b_id = b_id;
    }
    
    public void insertBorrowBook(Connection con) throws SQLException{
        String sql = "insert into borrow values(null,?,?,null);";
           
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, this.p_id);
        ps.setInt(2, this.b_id);
        ps.executeUpdate();
        ps.close();      
    }
    
        

    public static ObservableList<BorrowBook> getAllBorrows(Connection con) throws SQLException {

        ObservableList<BorrowBook> borrowArray = FXCollections.observableArrayList();

        String sql = "select * from borrow;";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int p_id = rs.getInt(2);
            int b_id = rs.getInt(3);
            BorrowBook bb = new BorrowBook(p_id,b_id);

            borrowArray.add(bb);

        }
        rs.close();
        ps.close();
        return borrowArray;
    }

    public int getP_id() {
        return p_id;
    }

    public int getB_id() {
        return b_id;
    }
    

    
    
       
}
