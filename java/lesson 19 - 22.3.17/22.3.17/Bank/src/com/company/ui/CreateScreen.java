package com.company.ui;

import com.company.infrastructure.Account;
import com.company.infrastructure.BasicScreen;
import com.company.interfaces.ChangeSceneListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Created by hackeru on 15/03/2017.
 */
public class CreateScreen extends BasicScreen {

    public CreateScreen(ChangeSceneListener listener){
        super(listener);

        TextField accountOwnerInput = new TextField();

        Button createAccountBtn = new Button("Create");
        createAccountBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Account a = new Account(accountOwnerInput.getText());
                // add a to arrayList
                listener.addAccount(a);
                listener.changeScene(new DetailsScreen(listener, a));
            }
        });
        getChildren().add(0, accountOwnerInput);
        getChildren().add(1, createAccountBtn);

        /*
        ArrayList<Node> widgets = new ArrayList<>();
        widgets.add(accountOwnerInput);
        widgets.add(createAccountBtn);

        getChildren().addAll(0, widgets);
        */

    }

}
