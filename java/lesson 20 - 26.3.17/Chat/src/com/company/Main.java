package com.company;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application implements EventHandler<ActionEvent>, UpdateUiListener {

    private final String MY_NAME = "Maayan";
    private TextField input;    // null
    private TextArea chatView;

    public static void main(String[] args) {
	    launch();
    }

    @Override
    public void start(Stage window) throws Exception {
        chatView = new TextArea();
        chatView.setPrefSize(500, 400);
        chatView.setEditable(false);
        input = new TextField();
        input.setPrefSize(400, 100);
        Button sendBtn = new Button("Send");
        sendBtn.setOnAction(this);
        sendBtn.setPrefSize(100, 100);
        HBox inputView = new HBox(input, sendBtn);
        VBox mainLayout = new VBox(chatView, inputView);
        Scene mainScene = new Scene(mainLayout, 300, 300);
        window.setScene(mainScene);
        window.show();

        new GetMessageThread(this).start();
    }

    @Override
    public void displayMessage(final String message) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                chatView.appendText(message + "\n");
            }
        });
    }

    @Override
    public void handle(ActionEvent event) {
        String str = input.getText().trim();
        if (!str.isEmpty()) {
            String message = MY_NAME + ": " + str;
            new SendMessageThread(message).start();
        }
    }
}
