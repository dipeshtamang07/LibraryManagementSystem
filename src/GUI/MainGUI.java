package GUI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Controller.BookController;
import Database.PersonController;
import Database.Database;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MainGUI extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        
        primaryStage.setTitle("LIBRARY");
        
        //Book 
        Button btnbook = new Button("SUBMIT");
        
        Label lBTitle = new Label("BOOK");
        
        Label lBName = new Label("BOOK NAME");
        Label lAuthor = new Label("AUTHOR");
        Label lISBN = new Label("ISBN");
        Label lPublisher = new Label("PUBLISHER");
        
        TextField tfBName = new TextField();
        TextField tfAuthor = new TextField();
        TextField tfISBN = new TextField();
        TextField tfPublisher = new TextField();
        
        
        //Person
        Label lPTitle = new Label("PERSON");
        
        Label lPName = new Label("NAME");
        Label lEmail = new Label("EMAIL");
        Label lph_no = new Label("PHNO");
        
        TextField tfPName = new TextField();
        TextField tfEmail = new TextField();
        TextField tfph_no = new TextField();
        Button btnperson = new Button("SUBMIT");
        
        //GridPane 1
        GridPane gp1 = new GridPane();
        gp1.setHgap(20);
        gp1.setVgap(20);
        
        gp1.add(lBTitle, 0, 0);
        
        gp1.add(lBName, 0, 1);
        gp1.add(tfBName, 1, 1);
        gp1.add(lISBN, 0, 2);
        gp1.add(tfISBN, 1, 2);
        gp1.add(lAuthor, 0, 3);
        gp1.add(tfAuthor, 1, 3);
        gp1.add(lPublisher, 0, 4);
        gp1.add(tfPublisher, 1, 4);
        
        gp1.add(btnbook, 1, 5);
                
        //GridPane 2
        GridPane gp2 = new GridPane();
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
        
        Group grp = new Group();
        

        TabPane tabPane = new TabPane();

        BorderPane borderPane = new BorderPane();
        
            Tab tab = new Tab();
            tab.setText("Book");
            
            HBox hbox = new HBox();
            hbox.getChildren().add(gp1);
            //hbox.setAlignment(Pos.CENTER);
            tab.setContent(hbox);
            
        
        
            Tab tab1 = new Tab();
            tab1.setText("Person");
            
            HBox hbox1 = new HBox();
            hbox1.getChildren().add(gp2);
            //hbox.setAlignment(Pos.CENTER);
            tab1.setContent(hbox1);
            tabPane.getTabs().addAll(tab,tab1);
        
            
        Scene scene = new Scene(grp, 500, 300);
        borderPane.prefHeightProperty().bind(scene.heightProperty());
        borderPane.prefWidthProperty().bind(scene.widthProperty());
        
        borderPane.setCenter(tabPane);
        grp.getChildren().add(borderPane);
        
        
        
        
        
        
        btnbook.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                try {
                    String book_name = tfBName.getText();
                    String ISBN = tfISBN.getText();
                    String author = tfAuthor.getText();
                    String publisher = tfPublisher.getText();
                    
                    System.out.println(book_name);
                    System.out.println(ISBN);
                    System.out.println(author);
                    System.out.println(publisher);
                    
                    Database d = new Database();
                    Connection con = d.openConnection();     
                    BookController b = new BookController(book_name,ISBN,author,publisher);
                    b.insertBook(con);                    
                    con.close();
                    
                } 
                
                catch (ClassNotFoundException ex) {
                    Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
            }); 
        
        btnperson.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                try {
                    String name = tfPName.getText();
                    String email = tfEmail.getText();
                    String ph_no = tfph_no.getText();
                    
                    
                    System.out.println(name);
                    System.out.println(email);
                    System.out.println(ph_no);
                    
                    
                    Database d = new Database();
                    Connection con = d.openConnection();     
                    PersonController b = new PersonController(name,email,ph_no);
                    b.insertPerson(con);                    
                    con.close();
                    
                    
                } catch (SQLException ex) {
                    Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        primaryStage.setScene(scene);
        primaryStage.show();
        
                }
}