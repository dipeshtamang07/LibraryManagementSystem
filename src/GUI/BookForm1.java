/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Database.Book;
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
public class BookForm1 {

    Label lBTitle;

    Label lBName;
    Label lAuthor;
    Label lISBN;
    Label lPublisher;

    TextField tfBName;
    TextField tfAuthor;
    TextField tfISBN;
    TextField tfPublisher;

    Button btnBook;

    public Label getlBTitle() {
        return lBTitle;
    }

    public Label getlBName() {
        return lBName;
    }

    public Label getlAuthor() {
        return lAuthor;
    }

    public Label getlISBN() {
        return lISBN;
    }

    public Label getlPublisher() {
        return lPublisher;
    }

    public TextField getTfBName() {
        return tfBName;
    }

    public TextField getTfAuthor() {
        return tfAuthor;
    }

    public TextField getTfISBN() {
        return tfISBN;
    }

    public TextField getTfPublisher() {
        return tfPublisher;
    }

    public Button getBtnBook() {
        return btnBook;
    }

    public GridPane getGp1() {
        return gp1;
    }

    GridPane gp1;

    public BookForm1() {
        lBTitle = new Label("ADD BOOK");
        lBName = new Label("Name");
        lAuthor = new Label("Author");
        lISBN = new Label("ISBN");
        lPublisher = new Label("Publisher");

        tfBName = new TextField();
        tfAuthor = new TextField();
        tfISBN = new TextField();
        tfPublisher = new TextField();
        
        btnBook = new Button();
        btnBook.setText("Submit");
        
        gp1 = new GridPane();
        
        //GridPane styling
        gp1.setHgap(20);
        gp1.setVgap(20);
        gp1.setAlignment(Pos.CENTER);
        
        gp1.add(lBTitle, 0, 0);
        
        gp1.add(lBName, 0, 1);
        gp1.add(tfBName, 1, 1);
        gp1.add(lAuthor, 0, 2);
        gp1.add(tfAuthor, 1, 2);
        gp1.add(lISBN, 0, 3);
        gp1.add(tfISBN, 1, 3);
        gp1.add(lPublisher, 0, 4);
        gp1.add(tfPublisher, 1, 4);
        
        
        gp1.add(btnBook, 1, 5); 
        
        btnBook.setOnAction((ActionEvent e) -> {
            String name = tfBName.getText();
            String auther = tfAuthor.getText();
            String isbn = tfISBN.getText();
            String pub = tfPublisher.getText();
            
            System.out.println(name);
            System.out.println(auther);
            System.out.println(isbn);
            System.out.println(pub);
            
            Database d = new Database();
            Book b = new Book(name,auther,isbn,pub);
            try {
                b.insertBook(d.openConnection());
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(BookForm1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                d.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(BookForm1.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

    }

}
