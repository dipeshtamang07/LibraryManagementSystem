/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Database.Database;
import Database.Person;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
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
public class PersonForm1 {

    Label lPTitle;
    Label lPName;
    Label lEmail;
    Label lph_no;

    TextField tfPName;
    TextField tfEmail;
    TextField tfph_no;

    Button btnPerson;

    GridPane gp2;
    
    HBox hbox2; 

    public PersonForm1() throws ClassNotFoundException, SQLException {

        lPTitle = new Label("ADD PERSON");
        lPName = new Label("name");
        lEmail = new Label("email");
        lph_no = new Label("Phone");

        tfPName = new TextField();
        tfEmail = new TextField();
        tfph_no = new TextField();

        btnPerson = new Button();
        btnPerson.setText("Submit");

        gp2 = new GridPane();

        //GridPane styling
        gp2.setHgap(20);
        gp2.setVgap(20);
        gp2.setAlignment(Pos.CENTER);

        gp2.add(lPTitle, 0, 0);

        gp2.add(lPName, 0, 1);
        gp2.add(tfPName, 1, 1);
        gp2.add(lEmail, 0, 2);
        gp2.add(tfEmail, 1, 2);
        gp2.add(lph_no, 0, 3);
        gp2.add(tfph_no, 1, 3);

        gp2.add(btnPerson, 1, 5);
        
        //Tableview
        TableView t = new TableView();
        Database d2 = new Database();
        Connection con = d2.openConnection();
        ObservableList<Person> personArray = Person.getAllPerson(con);
        
        TableColumn <String,Person> tname = new TableColumn("Name");
        tname.setCellValueFactory(new PropertyValueFactory("name"));
        
        TableColumn <String,Person> temail = new TableColumn("Email");
        temail.setCellValueFactory(new PropertyValueFactory("Email"));
        
        TableColumn <String,Person> tph_no = new TableColumn("Ph_no");
        tph_no.setCellValueFactory(new PropertyValueFactory("Ph_no"));
        
        
        t.setItems(personArray);
        t.getColumns().addAll(tname,temail,tph_no);
        
        
        hbox2 = new HBox(gp2,t);

        btnPerson.setOnAction((ActionEvent event) -> {
            String name = tfPName.getText();
            String email = tfEmail.getText();
            String ph_no = tfph_no.getText();

            //Email Validation
            if (Validation.isEmailValid(email)) {
                System.out.println("Valid");
            } else {
                AlertBox.display("Error", "Invalid Email");
            }

            System.out.println(name);
            System.out.println(email);
            System.out.println(ph_no);

            Database d = new Database();
            Person b = new Person(name, ph_no,email);
            try {
                b.insertPerson(d.openConnection());
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(PersonForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                d.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(PersonForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

    }

    public Label getlPTitle() {
        return lPTitle;
    }

    public Label getlPName() {
        return lPName;
    }

    public Label getlEmail() {
        return lEmail;
    }

    public Label getLph_no() {
        return lph_no;
    }

    public TextField getTfPName() {
        return tfPName;
    }

    public TextField getTfEmail() {
        return tfEmail;
    }

    public TextField getTfph_no() {
        return tfph_no;
    }

    public Button getBtnPerson() {
        return btnPerson;
    }

    public GridPane getGp2() {
        return gp2;
    }

    public HBox getHbox2() {
        return hbox2;
    }
    

}
