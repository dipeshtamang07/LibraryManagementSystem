/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Database.BorrowBook;
import Database.Database;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author dipesh
 */
public class BorrowForm {

    Label lTitle;

    Label lBId;
    Label lPId;

    TextField tfBId;
    TextField tfPId;

    Button btnBorrow;

    GridPane gp3;

    public BorrowForm() {
        lTitle = new Label("ADD BORROW");
        lBId = new Label("Book ID");
        lPId = new Label("Person ID");
        tfBId = new TextField();
        tfPId = new TextField();
        btnBorrow = new Button("Submit");
        gp3 = new GridPane();
        
        //GridPane styling
        gp3.setHgap(20);
        gp3.setVgap(20);
        gp3.setAlignment(Pos.CENTER);
        
        gp3.add(lTitle, 0, 0);
        
        gp3.add(lBId, 0, 1);
        gp3.add(tfBId, 1, 1);
        gp3.add(lPId, 0, 2);
        gp3.add(tfPId, 1, 2);
        gp3.add(btnBorrow, 1, 3);
        

        btnBorrow.setOnAction((ActionEvent e) -> {
            String bkID = tfBId.getText();
            int bookID = Integer.parseInt(bkID);
            String perID = tfBId.getText();
            int personID = Integer.parseInt(perID);
            
            System.out.println(bookID);
            System.out.println(personID);
            
            Database d = new Database();
            BorrowBook bb = new BorrowBook(bookID, personID);
            try {
                bb.insertBorrowBook(d.openConnection());
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(BorrowForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                d.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(BorrowForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

    }

    public Label getlTitle() {
        return lTitle;
    }

    public Label getlBId() {
        return lBId;
    }

    public Label getlPId() {
        return lPId;
    }

    public TextField getTfBId() {
        return tfBId;
    }

    public TextField getTfPId() {
        return tfPId;
    }

    public Button getBtnBorrow() {
        return btnBorrow;
    }

    public GridPane getGp3() {
        return gp3;
    }

}
