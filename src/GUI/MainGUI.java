package GUI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.SQLException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;



import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MainGUI extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws ClassNotFoundException, SQLException {

        //FORMS
        BookForm1 bookForm = new BookForm1();
        PersonForm1 personForm = new PersonForm1();
        BorrowForm borrowForm = new BorrowForm();
        ReturnForm returnForm = new ReturnForm();

        TabPane tabPane = new TabPane();

        Tab tab1 = new Tab();
        tab1.setText("      Book        ");

        
        Tab tab2 = new Tab();
        tab2.setText("      Person        ");

        Tab tab3 = new Tab();
        tab3.setText("      Borrow        ");

        Tab tab4 = new Tab();
        tab4.setText("      Return        ");
        
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        HBox hBox1 = bookForm.gethBox1();
        HBox hbox2 = personForm.getHbox2();
        HBox hBox3 = borrowForm.gethBox3();
        HBox hbox4 = returnForm.getHbox4();
        
        
        

        //Tab Contents
        tab1.setContent(hBox1);
        tab2.setContent(hbox2);
        tab3.setContent(hBox3);
        tab4.setContent(hbox4);
        //Hbox
        

        //Tab Contents
        tab1.setContent(hBox1);
        tab2.setContent(hbox2);
        tab3.setContent(hBox3);
        tab4.setContent(hbox4);

        tabPane.getTabs().add(tab1);
        tabPane.getTabs().add(tab2);
        tabPane.getTabs().add(tab3);
        tabPane.getTabs().add(tab4);

        Scene scene = new Scene(tabPane, 600, 300);

        primaryStage.setTitle("LIBRARY");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
