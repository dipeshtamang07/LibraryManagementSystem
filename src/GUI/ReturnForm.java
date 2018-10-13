package GUI;

import Database.BorrowBook;
import Database.Database;
import Database.Person;
import Database.ReturnBook;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

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

    public HBox getHbox4() {
        return hbox4;
    }
    
    

    Button btnReturn;

    GridPane gp4;
    
    HBox hbox4; 

    public ReturnForm() throws ClassNotFoundException, SQLException {

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
        
        
        //Tableview
        TableView t = new TableView();
        Database d2 = new Database();
        Connection con = d2.openConnection();
        ObservableList<ReturnBook> returnBookArray = ReturnBook.getAllReturnBooks(con);
        
        TableColumn <Integer,ReturnBook> tbo_id = new TableColumn("Book-ID");
        tbo_id.setCellValueFactory(new PropertyValueFactory("Book-ID"));
        
        
        t.setItems(returnBookArray);
        t.getColumns().addAll(tbo_id);
        
        
        hbox4 = new HBox(gp4,t);
        
        
        
        
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
