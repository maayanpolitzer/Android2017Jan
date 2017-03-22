package com.company.ui;

import com.company.interfaces.ChangeSceneListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * Created by hackeru on 15/03/2017.
 */
public class MainScreen extends VBox {


    public MainScreen(final ChangeSceneListener listener){
        TextField input = new TextField();
        input.setPromptText("Enter account number");
        input.setFocusTraversable(false);
        Button enterAccountBtn = new Button("View account details");
        enterAccountBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                listener.changeScene(new DetailsScreen(listener));
            }
        });
        Button createAccountBtn = new Button("Create a new Account");
        /*
        createAccountBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                listener.changeScene(new CreateScreen());
                System.out.println("wow");

            }
        });
        */

        // LAMBDA EXPRESSIONS:
        createAccountBtn.setOnAction(event -> {
            listener.changeScene(new CreateScreen(listener));
            System.out.println("wow");
        });
        getChildren().addAll(input, enterAccountBtn, createAccountBtn);

    }

}
