package edu.tomer.java;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage window) throws Exception {
        Button btn = new Button("click me!!!");

        btn.setOnAction(new ButtonClick(btn));
        Button btn2 = new Button("click me 2 !!!");
        HBox layout = new HBox(btn, btn2);
        Scene mainScene = new Scene(layout, 500, 500);
        window.setScene(mainScene);
        window.show();
    }
}
