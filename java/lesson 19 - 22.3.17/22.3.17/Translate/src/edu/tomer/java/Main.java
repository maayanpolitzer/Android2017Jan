package edu.tomer.java;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Main extends Application implements EventHandler<ActionEvent>, TimingListener {

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
    private TextField hebTextField;
    private TextField engTextField;
    private TimingThread timer;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public boolean isWorking(){
        return working;
    }

    @Override
    public void start(Stage window) throws Exception {
        hebTextField = new TextField();
        engTextField = new TextField();
        switchBtn = new Button("Switch");
        startBtn = new Button("START");
        startBtn.setOnAction(this);
        Button morfixTranslateBtn = new Button("Translate english to hebrew using morfix");
        morfixTranslateBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                sendDataToMorfix();
            }
        });
        switchBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                wow();
            }
        });
        HBox hbox = new HBox(switchBtn, startBtn, morfixTranslateBtn);
        VBox layout = new VBox(hebTextField, engTextField, hbox);
        Scene scene = new Scene(layout, 600, 400);
        window.setScene(scene);
        window.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                if (working){
                    working = false;
                    timer.interrupt();
                }
            }
        });
        window.show();
    }

    private void sendDataToMorfix() {
        String content = engTextField.getText().trim();
        content = content.replace(" ", "%20");
        if(!content.isEmpty()){
            String link = "http://www.morfix.co.il/" + content;
            try {
                URL url = new URL(link);
                InputStream in = url.openStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String line;
                while((line = reader.readLine()) != null) {
                    if (line.contains("translation translation_he heTrans")){
                        String from = ">";
                        String to = "</";
                        String translate = line.substring(line.indexOf(from) + 1, line.indexOf(to) - 1);
                        hebTextField.setText(translate);
                        break;
                    }
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void wow() {
        //System.out.println(Thread.currentThread().getName());
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                if (counter == words.length){
                    counter = 0;
                }
                hebTextField.setText(words[counter].getHeb());
                engTextField.setText(words[counter].getEng());
                counter++;
            }
        });
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
        // start a new thread and call changeWords() every 3 seconds.

        timer = new TimingThread(this);
        timer.start();
    }

    @Override
    public void changeWords(){
        wow();
    }

    private void stopWorking(){
        startBtn.setText("START");
        switchBtn.setDisable(false);
    }
}
