package edu.tomer.java;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 * Created by hackeru on 05/03/2017.
 */
public class ButtonClick implements EventHandler{

    private Button btn;

    public ButtonClick(Button btn){
        this.btn = btn;
    }

    @Override
    public void handle(Event event) {
        System.out.println("clicked!!!");
        btn.setText("wow");
    }
}
