

package library;

import Controller.PersonController;
import Database.Database;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
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


public class Person extends Application {
    
    @Override
    public void start(Stage primaryStage) throws ClassNotFoundException {

        
        Button btnSubmit = new Button("SUBMIT");
        
        Label lTitle = new Label("Person");
        
        Label lName = new Label("NAME");
        Label lEmail = new Label("EMAIL");
        Label lphno = new Label("PHNO");
        
        TextField tfName = new TextField();
        TextField tfEmail = new TextField();
        TextField tfphno = new TextField();

        
        GridPane gp1 = new GridPane();
        gp1.setHgap(20);
        gp1.setVgap(20);
        
        gp1.add(lTitle, 0, 0);
        
        gp1.add(lName, 0, 1);
        gp1.add(tfName, 1, 1);
        gp1.add(lEmail, 0, 2);
        gp1.add(tfEmail, 1, 2);
        gp1.add(lphno, 0, 3);
        gp1.add(tfphno, 1, 3);
        
        
        gp1.add(btnSubmit, 1, 5);       
        Group root = new Group();
        Scene scene = new Scene(root, 500, 250);
        
        TabPane tabPane1 = new TabPane();

        BorderPane borderPane1 = new BorderPane();
        
            Tab tab1 = new Tab();
            tab1.setText("Person");
            
            HBox hbox1 = new HBox();
            hbox1.getChildren().add(gp1);
            //hbox.setAlignment(Pos.CENTER);
            tab1.setContent(hbox1);
            tabPane1.getTabs().add(tab1);
            
            
            
            
            
        // bind to take available space
        borderPane1.prefHeightProperty().bind(scene.heightProperty());
        borderPane1.prefWidthProperty().bind(scene.widthProperty());
        
        borderPane1.setCenter(tabPane1);
        root.getChildren().add(borderPane1);
        
        primaryStage.setTitle("LIBRARY");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        btnSubmit.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                try {
                    String name = tfName.getText();
                    String email = tfEmail.getText();
                    String phno = tfphno.getText();
                    
                    
                    System.out.println(name);
                    System.out.println(email);
                    System.out.println(phno);
                    
                    
                    Database d = new Database();
                    Connection con = d.openConnection();     
                    PersonController p = new PersonController(name,email,phno);
                    p.insertPerson(con);                    
                    con.close();
                    
                    
                } catch (SQLException ex) {
                    Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
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
