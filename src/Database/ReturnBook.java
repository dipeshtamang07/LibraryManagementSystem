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
}
