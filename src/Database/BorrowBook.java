/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
    
    
    
    
    
}
