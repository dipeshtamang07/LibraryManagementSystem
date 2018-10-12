package GUI;

import Database.BorrowBook;
import Database.Database;
import Database.ReturnBook;
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
public class ReturnForm {

    Label lTitle;

    Label lBoId;

    TextField tfBoId;

    public Label getlTitle() {
        return lTitle;
    }

    public Label getlBoId() {
        return lBoId;
    }

    public TextField getTfBoId() {
        return tfBoId;
    }

    public Button getBtnReturn() {
        return btnReturn;
    }

    public GridPane getGp4() {
        return gp4;
    }

    Button btnReturn;

    GridPane gp4;

    public ReturnForm() {

        lTitle = new Label("ADD RETURN");
        lBoId = new Label("Borrow ID");
        tfBoId = new TextField();
        btnReturn = new Button("Submit");
        gp4 = new GridPane();

        //GridPane styling
        gp4.setHgap(20);
        gp4.setVgap(20);
        gp4.setAlignment(Pos.CENTER);

        gp4.add(lTitle, 0, 0);

        gp4.add(lBoId, 0, 1);
        gp4.add(tfBoId, 1, 1);
        gp4.add(btnReturn, 1, 2);
        btnReturn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                String boID = tfBoId.getText();
                int borrowID = Integer.parseInt(boID);

                System.out.println(borrowID);

                Database d = new Database();
                ReturnBook rb = new ReturnBook(borrowID);
                try {
                    rb.insertReturnBook(d.openConnection());
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(ReturnForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    d.closeConnection();
                } catch (SQLException ex) {
                    Logger.getLogger(ReturnForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }

}
