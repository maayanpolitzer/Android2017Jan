package com.company.infrastructure;

import com.company.interfaces.ChangeSceneListener;
import com.company.ui.MainScreen;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

/**
 * Created by hackeru on 15/03/2017.
 */
public class BasicScreen extends VBox {

    public BasicScreen(final ChangeSceneListener listener){
        Button backBtn = new Button("back");
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                listener.changeScene(new MainScreen(listener));
            }
        });
        getChildren().add(backBtn);
    }


}
