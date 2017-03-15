package com.company.ui;

import com.company.infrastructure.BasicScreen;
import com.company.interfaces.ChangeSceneListener;
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
