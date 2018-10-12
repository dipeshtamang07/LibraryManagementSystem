package GUI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainGUI extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

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

        //GridPanes
        GridPane bookGP = bookForm.getGp1();
        GridPane personGP = personForm.getGp2();
        GridPane borrowGP = borrowForm.getGp3();
        GridPane returnGP = returnForm.getGp4();

        //Tab Contents
        tab1.setContent(bookGP);
        tab2.setContent(personGP);
        tab3.setContent(borrowGP);
        tab4.setContent(returnGP);

        tabPane.getTabs().add(tab1);
        tabPane.getTabs().add(tab2);
        tabPane.getTabs().add(tab3);
        tabPane.getTabs().add(tab4);

        Scene scene = new Scene(tabPane, 500, 300);

        primaryStage.setTitle("LIBRARY");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
