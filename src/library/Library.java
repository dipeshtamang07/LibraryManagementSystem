/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.sql.Connection;
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
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author wenhawk
 */
public class Library extends Application {
    
    @Override
    public void start(Stage primaryStage) throws ClassNotFoundException {

        
        Button btnSubmit = new Button("SUBMIT");
        
        Label lTitle = new Label("BOOK");
        
        Label lName = new Label("BOOK NAME");
        Label lISBN = new Label("ISBN");
        Label lAuthor = new Label("AUTHOR");
        Label lPubG = new Label("PUBLISHER");
        
        TextField tfName = new TextField();
        TextField tfISBN = new TextField();
        TextField tfAuthor = new TextField();
        TextField tfPubG = new TextField();
        
        GridPane gp = new GridPane();
        gp.setHgap(20);
        gp.setVgap(20);
        
        gp.add(lTitle, 0, 0);
        
        gp.add(lName, 0, 1);
        gp.add(tfName, 1, 1);
        gp.add(lISBN, 0, 2);
        gp.add(tfISBN, 1, 2);
        gp.add(lAuthor, 0, 3);
        gp.add(tfAuthor, 1, 3);
        gp.add(lPubG, 0, 4);
        gp.add(tfPubG, 1, 4);
        
        gp.add(btnSubmit, 1, 5);       
        
        Scene scene = new Scene(gp, 500, 250);
        
        primaryStage.setTitle("LIBRARY");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        btnSubmit.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                try {
                    String name = tfName.getText();
                    String isbn = tfISBN.getText();
                    String auth = tfAuthor.getText();
                    String pubG = tfPubG.getText();
                    System.out.println(name);
                    System.out.println(isbn);
                    System.out.println(auth);
                    System.out.println(pubG);
                    
                    Database d = new Database();
                    Connection con = d.openConnection();     
                    Book b = new Book(name,isbn,auth,pubG);
                    b.insertBook(con);                    
                    con.close();
                    
                    
                } catch (SQLException ex) {
                    Logger.getLogger(Library.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Library.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
