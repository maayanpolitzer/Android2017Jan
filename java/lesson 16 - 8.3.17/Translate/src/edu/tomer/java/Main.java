package edu.tomer.java;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class Main extends Application implements EventHandler<ActionEvent> {

    private Word[] words = {
            new Word("כלב", "Dog"),
            new Word("חתול", "Cat"),
            new Word("יום", "Day"),
            new Word("לילה", "Night")
    };
    private int counter;
    private boolean working;
    private Button startBtn;
    private Button switchBtn;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage window) throws Exception {
        final TextField hebTextField = new TextField();
        final TextField engTextField = new TextField();
        switchBtn = new Button("Switch");
        startBtn = new Button("START");
        startBtn.setOnAction(this);
        Button morfixTranslateBtn = new Button("Translate english to hebrew using morfix");
        switchBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (counter == words.length){
                    counter = 0;
                }
                hebTextField.setText(words[counter].getHeb());
                engTextField.setText(words[counter].getEng());
                counter++;
            }
        });
        HBox hbox = new HBox(switchBtn, startBtn, morfixTranslateBtn);
        VBox layout = new VBox(hebTextField, engTextField, hbox);
        Scene scene = new Scene(layout, 600, 400);
        window.setScene(scene);
        window.show();
    }

    @Override
    public void handle(ActionEvent event) {
        if (!working){
            startWorking();
        }else{
            stopWorking();
        }
        working = !working;
    }

    private void startWorking(){
        startBtn.setText("STOP");
        switchBtn.setDisable(true);
    }

    private void stopWorking(){
        startBtn.setText("START");
        switchBtn.setDisable(false);
    }
}
