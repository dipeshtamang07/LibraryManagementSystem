/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Database.Database;
import Database.Person;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author dipesh
 */
public class PersonForm extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        //
        Label lPTitle = new Label("PERSON");
        
        Label lPName = new Label("NAME");
        Label lEmail = new Label("EMAIL");
        Label lph_no = new Label("PHNO");
        
        TextField tfPName = new TextField();
        TextField tfEmail = new TextField();
        TextField tfph_no = new TextField();
        Button btnperson = new Button("SUBMIT");
        
         //GridPane 2
        javafx.scene.layout.GridPane gp2 = new javafx.scene.layout.GridPane();
        gp2.setHgap(20);
        gp2.setVgap(20);
        
        gp2.add(lPTitle, 0, 0);
        
        gp2.add(lPName, 0, 1);
        gp2.add(tfPName, 1, 1);
        gp2.add(lEmail, 0, 2);
        gp2.add(tfEmail, 1, 2);
        gp2.add(lph_no, 0, 3);
        gp2.add(tfph_no, 1, 3);
        
        
        gp2.add(btnperson, 1, 5); 
        
        btnperson.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String name = tfPName.getText();
                String email = tfEmail.getText();
                String ph_no = tfph_no.getText();
                
                if (Validation.isEmailValid(email))
                    System.out.println("Valid");
                else
                    AlertBox.display("Error", "Invalid Email");
                
                System.out.println(name);
                System.out.println(email);
                System.out.println(ph_no);
                
                
                Database d = new Database();
                Person b = new Person(name,email,ph_no);
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
            }
        });
        
        Scene scene = new Scene(gp2, 500, 300);
        
        primaryStage.setScene(scene);
        primaryStage.show();

        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
